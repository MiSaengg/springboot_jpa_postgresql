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
