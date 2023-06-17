# Components
## TDLR:
In a Spring Boot application, the Controller receives and processes HTTP requests, DTOs define the data structure for request/response payloads, Models represent the domain entities, Repositories handle data access operations, and Services contain the business logic and coordinate the interactions between controllers and repositories. 

The client sends an HTTP request, which is received by a controller. The controller takes the request and calls the appropriate method in the service layer. The service layer performs the necessary business logic, which often involves querying the database through a repository. The service layer then returns the data (often encapsulated in a DTO) to the controller, which sends it back to the client.

## Flow of Sequence:
1. Client sends an HTTP request
2. Controller receives the request
3. Controller calls the appropriate method in the service layer
4. Service layer performs the necessary business logic
5. Service layer returns the data (often encapsulated in a DTO) to the controller
6. Controller sends the data back to the client

Client Request -> Controller -> DTO -> Service -> Repository (uses Model) -> Database (through Model)


### Controller:
The Controller is responsible for handling incoming HTTP requests and returning appropriate responses. It acts as an entry point for the application's API. Controllers typically contain methods (annotated with @RequestMapping or other annotations) that map to specific URLs and HTTP methods. They receive requests, extract necessary information, delegate processing to the relevant components, and return responses. Controllers are responsible for handling request validation, invoking services, and marshaling/unmarshaling DTOs or models.

Controller: The Controller, annotated with @RestController or @Controller, receives the client's request. It's responsible for handling all request mapping. The controller calls the appropriate service method and passes any necessary parameters (usually derived from the request).

Example: 
```java
@RestController
@RequestMapping("/todos")
public class ToDoController {
    private ToDoService toDoService;

    public ToDoController (ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping("")
    public ResponseEntity<ToDoDto> createToDo(@RequestBody CreateToDoDto newToDo) {
        ToDoDto toDoDTO = toDoService.createTodo(newToDo);
        return new ResponseEntity<>(toDoDTO, HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<ToDoDto> getToDos(@RequestParam Optional<Boolean> completed) {
        if (completed.isPresent()) {
            return toDoService.getToDos(completed.get());
        }
        return toDoService.getToDos();
    }

    @PutMapping("/{id}")
    public ToDoDto updateToDo(@PathVariable Long id, @RequestBody UpdateToDoDto updateToDo) {
        return toDoService.updateToDo(id, updateToDo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteToDo(@PathVariable Long id) {
        toDoService.deleteToDo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
```

### DTO (Data Transfer Object):
DTOs are objects used to transfer data between different layers or components of an application. They represent a simplified view of the data needed for a specific operation or request/response. DTOs are often used to encapsulate the data exchanged between the client and the server. They are commonly used in Spring Boot applications to define the structure of request and response payloads. DTOs provide a way to decouple the internal representation of data from the external API representation.

DTO (Data Transfer Object): DTOs are used to transfer data between the Service and Controller layers. They can also be used to encapsulate data sent from the client or data sent back to the client. The DTO does not usually interact with the database directly.

Example:
```java
@Data
@AllArgsConstructor
public class ToDoDto {
    private Long id;
    private String name;
    private Boolean completed;

    public ToDoDto(ToDo entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.completed = entity.getCompleted();
    }
}

@Data
public class CreateToDoDto {
    private String name;
    private Boolean completed;
}
```

### Service:
The Service layer contains the business logic of the application. It encapsulates the operations and workflows required by the application and acts as an intermediary between the Controller and the Repository. Services coordinate the data access and manipulation operations by utilizing the repositories. They apply business rules, perform validations, and handle complex operations that span multiple repositories or entities. Services are commonly used for transaction management, security checks, and other business-related tasks.

Service: The Service layer, annotated with @Service, contains the business logic of the application. It processes the request received from the controller. If the operation involves database interaction, it uses the appropriate method from the Repository layer. The service might also map Entity objects to/from DTO objects for data transfer between layers.

Example:
```java
@Service
public class ToDoService {
    private ToDoRepository toDoRepository;

    public ToDoService (ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public ToDoDto createTodo(CreateToDoDto createToDoDTO) {
        ToDo newToDo = new ToDo();
        newToDo.setName(createToDoDTO.getName());
        newToDo.setCompleted(createToDoDTO.getCompleted());
        ToDo toDo = toDoRepository.save(newToDo);
        return new ToDoDto(toDo);
    }

    public List<ToDoDto> getToDos() {
        List<ToDo> toDos = toDoRepository.findAll();
        return toDos.stream().map(entity -> new ToDoDto(entity)).toList();
    }

    public List<ToDoDto> getToDos(Boolean completed) {
        List<ToDo> toDos = toDoRepository.findByCompleted(completed);
        return toDos.stream().map(entity -> new ToDoDto(entity)).toList();
    }

    public ToDoDto getToDoById(Long id) {
        Optional<ToDo> toDo = toDoRepository.findById(id);
        if (toDo.isPresent()) {
            return new ToDoDto(toDo.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "getToDoById - to do not found");
        }
    }
}
```

### Model:
In the context of a Spring Boot application, the Model represents the domain objects or entities that are persisted in the database. It typically corresponds to the data structure used in the application's business logic. Models are often annotated with JPA annotations (such as @Entity, @Table, etc.) to define their relationships, constraints, and mapping to database tables. The Model objects are usually used by the Repository layer for database operations.

Model: The Model (or Entity), annotated with @Entity, represents a table in the database. Each instance of a model class represents a row in the table. The model is used by the repository to interact with the database.

Example:
```java
@Entity
@Data
@Table(name = "todos")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Boolean completed;
}
```

### Repository:
The Repository is responsible for handling the data access operations for the application. It provides an abstraction layer that encapsulates the details of interacting with the database. Repositories in Spring Boot are typically implemented using the Spring Data JPA framework. They define methods for querying, inserting, updating, and deleting data in the database. Repositories interact with the underlying database using ORM (Object-Relational Mapping) techniques, allowing developers to work with entities instead of writing complex SQL queries directly.

Repository: The Repository layer, annotated with @Repository, provides a way to interact with the database. It extends Spring Data JPA interfaces like JpaRepository or CrudRepository and thus inherits database interaction methods. The Repository interacts with Model entities and performs CRUD (Create, Read, Update, Delete) operations on the database.

Example:
```java
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findByCompleted(Boolean completed);
}
```



