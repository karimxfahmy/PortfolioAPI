# Portfolio API

> **Note:** This project was developed as a task for an internship at **InternIntelligence**.

A RESTful API built with Spring Boot for managing personal portfolio data including skills, projects, education, and experience. Features secure JWT-based authentication with per-user data isolation.

## 📋 Table of Contents

- [Features](#features)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Application](#running-the-application)
- [API Documentation](#api-documentation)
  - [Authentication](#authentication)
  - [Skills](#skills)
  - [Projects](#projects)
  - [Education](#education)
  - [Experience](#experience)
- [Database](#database)
- [Testing](#testing)
- [Contributing](#contributing)

## ✨ Features

- **User Authentication**: Secure registration and login with JWT tokens
- **Skills Management**: Create, read, update, and delete skills
- **Projects Management**: Full CRUD operations for portfolio projects
- **Education Management**: Track educational background
- **Experience Management**: Manage work experience entries
- **Data Isolation**: Each user can only access and modify their own data
- **Security**: Passwords encrypted with BCrypt, JWT-based authorization
- **In-Memory Database**: H2 database for quick setup and testing

## 🛠 Technology Stack

- **Java 17**
- **Spring Boot 3.5.3**
- **Spring Security** - Authentication and authorization
- **Spring Data JPA** - Data persistence
- **JWT (JSON Web Tokens)** - Token-based authentication
- **H2 Database** - In-memory database
- **Maven** - Dependency management and build tool

## 📁 Project Structure

```
InternIntelligence_PortfolioAPI-main/
├── docs/                    # Documentation
├── src/
│   ├── main/
│   │   ├── java/com/portfolioapi/
│   │   │   ├── config/           # Security configuration
│   │   │   ├── controller/       # REST controllers
│   │   │   ├── dto/             # Data Transfer Objects
│   │   │   ├── entity/          # JPA entities
│   │   │   ├── repository/      # Data repositories
│   │   │   ├── security/        # JWT authentication
│   │   │   └── service/         # Business logic
│   │   └── resources/
│   │       └── application.properties  # Application configuration
│   └── test/                # Test files
├── .gitignore              # Git ignore configuration
├── pom.xml                 # Maven configuration
└── README.md               # This file
```

> For a detailed project structure and architecture overview, see [docs/PROJECT_STRUCTURE.md](docs/PROJECT_STRUCTURE.md)

## 🚀 Getting Started

### Prerequisites

Before running this application, ensure you have the following installed:

- **Java Development Kit (JDK) 17 or higher**
  - Download from [Oracle](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.org/)
  - Verify installation: `java -version`

- **Maven 3.6+** (optional, project includes Maven Wrapper)
  - Download from [Apache Maven](https://maven.apache.org/download.cgi)
  - Verify installation: `mvn -version`

### Installation

1. **Clone or download this repository**

   ```bash
   git clone <repository-url>
   cd InternIntelligence_PortfolioAPI-main
   ```

2. **Build the project**

   Using Maven Wrapper (recommended):
   ```bash
   ./mvnw clean install
   ```

   Or using Maven directly:
   ```bash
   mvn clean install
   ```

### Running the Application

1. **Start the application**

   Using Maven Wrapper:
   ```bash
   ./mvnw spring-boot:run
   ```

   Or using Maven:
   ```bash
   mvn spring-boot:run
   ```

   Or run the compiled JAR:
   ```bash
   java -jar target/portfolio-api-0.0.1-SNAPSHOT.jar
   ```

2. **Access the application**

   The API will be available at: `http://localhost:8080`

3. **Access H2 Database Console** (optional)

   URL: `http://localhost:8080/h2-console`
   
   - **JDBC URL**: `jdbc:h2:mem:testdb`
   - **Username**: `sa`
   - **Password**: *(leave empty)*

## 📚 API Documentation

### Authentication

#### Register a New User

```http
POST /api/auth/register
Content-Type: application/json

{
  "username": "johndoe",
  "password": "securepassword123"
}
```

**Response:**
```
User registered successfully
```

#### Login

```http
POST /api/auth/login
Content-Type: application/json

{
  "username": "johndoe",
  "password": "securepassword123"
}
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

> **Note:** Include the received token in the `Authorization` header for all subsequent requests:
> ```
> Authorization: Bearer <your-token-here>
> ```

### Skills

#### Get All Skills

```http
GET /api/skills
Authorization: Bearer <token>
```

#### Create a New Skill

```http
POST /api/skills
Authorization: Bearer <token>
Content-Type: application/json

{
  "name": "Java",
  "level": "Advanced"
}
```

#### Get Skill by ID

```http
GET /api/skills/{id}
Authorization: Bearer <token>
```

#### Update a Skill

```http
PUT /api/skills/{id}
Authorization: Bearer <token>
Content-Type: application/json

{
  "name": "Java",
  "level": "Expert"
}
```

#### Delete a Skill

```http
DELETE /api/skills/{id}
Authorization: Bearer <token>
```

### Projects

Similar endpoints are available for projects at `/api/projects`:

- `GET /api/projects` - Get all projects
- `POST /api/projects` - Create a new project
- `GET /api/projects/{id}` - Get project by ID
- `PUT /api/projects/{id}` - Update a project
- `DELETE /api/projects/{id}` - Delete a project

**Example Project Object:**
```json
{
  "title": "Portfolio API",
  "description": "A RESTful API for managing portfolio data",
  "technologies": "Java, Spring Boot, JWT",
  "url": "https://github.com/username/portfolio-api"
}
```

### Education

Endpoints available at `/api/education`:

- `GET /api/education` - Get all education entries
- `POST /api/education` - Create a new education entry
- `GET /api/education/{id}` - Get education by ID
- `PUT /api/education/{id}` - Update education
- `DELETE /api/education/{id}` - Delete education

**Example Education Object:**
```json
{
  "institution": "University of Technology",
  "degree": "Bachelor of Science",
  "field": "Computer Science",
  "startDate": "2018-09-01",
  "endDate": "2022-06-30"
}
```

### Experience

Endpoints available at `/api/experience`:

- `GET /api/experience` - Get all experience entries
- `POST /api/experience` - Create a new experience entry
- `GET /api/experience/{id}` - Get experience by ID
- `PUT /api/experience/{id}` - Update experience
- `DELETE /api/experience/{id}` - Delete experience

**Example Experience Object:**
```json
{
  "company": "Tech Solutions Inc",
  "position": "Software Developer",
  "description": "Developed backend services using Spring Boot",
  "startDate": "2022-07-01",
  "endDate": "2024-12-31"
}
```

## 💾 Database

This application uses an **H2 in-memory database** for development and testing purposes. 

**Configuration** (in `application.properties`):
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
```

**Note:** Since H2 is in-memory, all data is lost when the application stops. For production use, configure a persistent database like PostgreSQL or MySQL.

## 🧪 Testing

A Postman collection is included in the repository: `docs/portfolio-task2.postman_collection.json`

**To use:**
1. Import the collection into [Postman](https://www.postman.com/)
2. Start the application
3. First, register a user and login to get a JWT token
4. Update the token in the Authorization header for other requests
5. Test all endpoints

For detailed API endpoint documentation, see [docs/API_ENDPOINTS.md](docs/API_ENDPOINTS.md)

## 🤝 Contributing

This project was created as an internship task. If you'd like to suggest improvements:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/improvement`)
3. Commit your changes (`git commit -am 'Add some improvement'`)
4. Push to the branch (`git push origin feature/improvement`)
5. Create a Pull Request

## 📄 License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

This project was created for educational purposes as part of the **InternIntelligence** internship program.

---

## 👤 Author

Developed by **Karim Fahmy** for **InternIntelligence** as part of the Java Development Internship program.

---

## 📧 Contact

For questions or feedback about this project, please reach out through the internship program.

---

**Developed as part of InternIntelligence Internship Program**
