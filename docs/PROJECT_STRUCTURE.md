# Project Structure

## Directory Layout

```
InternIntelligence_PortfolioAPI-main/
│
├── docs/                                    # Documentation files
│   ├── API_ENDPOINTS.md                    # API endpoints reference
│   ├── PROJECT_STRUCTURE.md                # This file
│   └── portfolio-task2.postman_collection.json  # Postman test collection
│
├── src/
│   ├── main/
│   │   ├── java/com/portfolioapi/
│   │   │   ├── config/
│   │   │   │   └── SecurityConfig.java     # Spring Security configuration
│   │   │   │
│   │   │   ├── controller/                 # REST API Controllers
│   │   │   │   ├── AuthController.java     # Authentication endpoints
│   │   │   │   ├── EducationController.java
│   │   │   │   ├── ExperienceController.java
│   │   │   │   ├── ProjectController.java
│   │   │   │   ├── SkillController.java
│   │   │   │   ├── TestController.java
│   │   │   │   └── UserController.java
│   │   │   │
│   │   │   ├── dto/                        # Data Transfer Objects
│   │   │   │   ├── AuthRequest.java        # Login/Register request DTO
│   │   │   │   └── AuthResponse.java       # JWT token response DTO
│   │   │   │
│   │   │   ├── entity/                     # JPA Entities (Database Models)
│   │   │   │   ├── Education.java
│   │   │   │   ├── Experience.java
│   │   │   │   ├── Project.java
│   │   │   │   ├── Skill.java
│   │   │   │   └── User.java
│   │   │   │
│   │   │   ├── repository/                 # Data Access Layer (JPA Repositories)
│   │   │   │   ├── EducationRepository.java
│   │   │   │   ├── ExperienceRepository.java
│   │   │   │   ├── ProjectRepository.java
│   │   │   │   ├── SkillRepository.java
│   │   │   │   └── UserRepository.java
│   │   │   │
│   │   │   ├── security/                   # Security & JWT Implementation
│   │   │   │   ├── JwtAuthFilter.java      # JWT authentication filter
│   │   │   │   └── JwtService.java         # JWT token generation/validation
│   │   │   │
│   │   │   ├── service/                    # Business Logic Layer
│   │   │   │   ├── EducationService.java
│   │   │   │   ├── ExperienceService.java
│   │   │   │   ├── ProjectService.java
│   │   │   │   ├── SkillService.java
│   │   │   │   └── UserService.java
│   │   │   │
│   │   │   └── PortfolioApiApplication.java  # Main Spring Boot application
│   │   │
│   │   └── resources/
│   │       └── application.properties      # Application configuration
│   │
│   └── test/                               # Test files (if any)
│
├── target/                                 # Maven build output (ignored in git)
│
├── .gitignore                              # Git ignore file
├── mvnw                                    # Maven wrapper script (Unix)
├── mvnw.cmd                                # Maven wrapper script (Windows)
├── pom.xml                                 # Maven project configuration
└── README.md                               # Main documentation

```

## Architecture Overview

### Layered Architecture

The application follows a standard **layered architecture** pattern:

1. **Controller Layer** (`controller/`)
   - Handles HTTP requests and responses
   - Maps URLs to Java methods
   - Validates request data
   - Returns appropriate HTTP status codes

2. **Service Layer** (`service/`)
   - Contains business logic
   - Manages transactions
   - Coordinates between controllers and repositories
   - Enforces business rules

3. **Repository Layer** (`repository/`)
   - Data access layer using Spring Data JPA
   - Provides CRUD operations
   - Custom query methods

4. **Entity Layer** (`entity/`)
   - JPA entities representing database tables
   - Contains data model and relationships

5. **Security Layer** (`security/`, `config/`)
   - JWT authentication and authorization
   - Security configuration
   - Password encryption

6. **DTO Layer** (`dto/`)
   - Data Transfer Objects for API requests/responses
   - Decouples internal entities from external API

## Key Components

### Security Configuration
- **SecurityConfig.java**: Configures Spring Security, defines public/protected endpoints
- **JwtAuthFilter.java**: Intercepts requests to validate JWT tokens
- **JwtService.java**: Generates and validates JWT tokens

### Data Flow

```
Client Request
     ↓
Controller (receives request, validates input)
     ↓
Service (business logic, authorization check)
     ↓
Repository (database operations)
     ↓
Database (H2 in-memory)
     ↓
Repository (return data)
     ↓
Service (process data)
     ↓
Controller (format response)
     ↓
Client Response
```

### Authentication Flow

1. User registers → Password encrypted with BCrypt → Stored in database
2. User logs in → Credentials validated → JWT token generated → Token returned
3. Subsequent requests → JWT token validated → User authenticated → Access granted

### Data Isolation

Each entity (Skill, Project, Education, Experience) is linked to a User:
- On creation, the authenticated user is associated with the entity
- On retrieval, only entities belonging to the authenticated user are returned
- This ensures complete data isolation between users

## Configuration Files

### application.properties
```properties
# Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update

# H2 Console
spring.h2.console.enabled=true

# Server Configuration
server.port=8080
```

### pom.xml
Maven dependencies include:
- Spring Boot Starter Web
- Spring Boot Starter Security
- Spring Boot Starter Data JPA
- JWT libraries (jjwt-api, jjwt-impl, jjwt-jackson)
- H2 Database

## Building and Running

The project uses **Maven** for dependency management and building:

- **Build**: `./mvnw clean install`
- **Run**: `./mvnw spring-boot:run`
- **Package**: `./mvnw package` (creates JAR in `target/`)

## Development Notes

- **Java Version**: 17
- **Spring Boot Version**: 3.5.3
- **Database**: H2 (in-memory, data lost on restart)
- **Default Port**: 8080
- **Authentication**: JWT (JSON Web Tokens)
- **Password Encryption**: BCrypt

---

*This project structure was designed for the **InternIntelligence** internship program.*

