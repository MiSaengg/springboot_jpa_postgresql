## High level structure

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

    1. Application.java: This is the entry point of your Spring Boot application. It contains the public static void main(String[] args) method that gets your application up and running.

    2. UserController.java (inside controller package): This is your REST controller. It's responsible for handling incoming HTTP requests. It may use services to perform the business logic and will likely interact with repositories to get and store data.

    3. User.java (inside entity package): This represents your User database table. It's a plain old Java object (POJO) with fields that correspond to columns in your database table. It will be annotated with JPA annotations like @Entity, @Table, @Id, etc.

    4. UserRepository.java (inside repository package): This interface extends JpaRepository, CrudRepository, or PagingAndSortingRepository. By extending these interfaces, Spring Data JPA provides you with methods for performing CRUD operations on your User database table without you having to write any implementation code.

    5. UserService.java and UserServiceImpl.java (inside service package): This is where you implement your business logic. The interface (UserService.java) defines the methods that your service will implement. The implementation (UserServiceImpl.java) contains the actual logic. These services use repositories to interact with the database.

    6. application.properties (inside resources folder): This is your configuration file where you define properties like database connection details, server port, application context path, etc.

    7. pom.xml (or build.gradle): This is your build file. It's where you define your project dependencies and build settings.