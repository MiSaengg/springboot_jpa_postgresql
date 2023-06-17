# Springboot+JPA+PostgreSQL

```sh
- src
  - main
    - java
      - com
        - example
          - myapp
            - Application.java // Spring boot application main class
            - controller
              - UserController.java // REST controller
            - entity
              - User.java // JPA entity
            - repository
              - UserRepository.java // JPA repository
            - service
              - UserService.java // Business service
              - UserServiceImpl.java // Implementation of business service
    - resources
      - application.properties // or application.yml, your Spring Boot configuration file
  - test
    - (Similar structure to main for tests)
- pom.xml // or build.gradle if you're using Gradle, your build configuration file
```
# Dependencies
    Lombok
    Spring Web
    Spring Data JPA
    Flyway Migration
    PostgreSQL Driver

# Components
## TDLR:
In a Spring Boot application, the Controller receives and processes HTTP requests, DTOs define the data structure for request/response payloads, Models represent the domain entities, Repositories handle data access operations, and Services contain the business logic and coordinate the interactions between controllers and repositories. 

### Controller:
The Controller is responsible for handling incoming HTTP requests and returning appropriate responses. It acts as an entry point for the application's API. Controllers typically contain methods (annotated with @RequestMapping or other annotations) that map to specific URLs and HTTP methods. They receive requests, extract necessary information, delegate processing to the relevant components, and return responses. Controllers are responsible for handling request validation, invoking services, and marshaling/unmarshaling DTOs or models.

### DTO (Data Transfer Object):
DTOs are objects used to transfer data between different layers or components of an application. They represent a simplified view of the data needed for a specific operation or request/response. DTOs are often used to encapsulate the data exchanged between the client and the server. They are commonly used in Spring Boot applications to define the structure of request and response payloads. DTOs provide a way to decouple the internal representation of data from the external API representation.

### Model:
In the context of a Spring Boot application, the Model represents the domain objects or entities that are persisted in the database. It typically corresponds to the data structure used in the application's business logic. Models are often annotated with JPA annotations (such as @Entity, @Table, etc.) to define their relationships, constraints, and mapping to database tables. The Model objects are usually used by the Repository layer for database operations.

### Repository:
The Repository is responsible for handling the data access operations for the application. It provides an abstraction layer that encapsulates the details of interacting with the database. Repositories in Spring Boot are typically implemented using the Spring Data JPA framework. They define methods for querying, inserting, updating, and deleting data in the database. Repositories interact with the underlying database using ORM (Object-Relational Mapping) techniques, allowing developers to work with entities instead of writing complex SQL queries directly.

### Service:
The Service layer contains the business logic of the application. It encapsulates the operations and workflows required by the application and acts as an intermediary between the Controller and the Repository. Services coordinate the data access and manipulation operations by utilizing the repositories. They apply business rules, perform validations, and handle complex operations that span multiple repositories or entities. Services are commonly used for transaction management, security checks, and other business-related tasks.


