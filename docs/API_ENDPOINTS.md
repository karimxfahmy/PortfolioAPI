# API Endpoints Reference

Base URL: `http://localhost:8080`

## Authentication Endpoints

### 1. Register User
- **Endpoint:** `POST /api/auth/register`
- **Authentication:** Not required
- **Request Body:**
  ```json
  {
    "username": "string",
    "password": "string"
  }
  ```
- **Response:** `"User registered successfully"`

### 2. Login
- **Endpoint:** `POST /api/auth/login`
- **Authentication:** Not required
- **Request Body:**
  ```json
  {
    "username": "string",
    "password": "string"
  }
  ```
- **Response:**
  ```json
  {
    "token": "JWT_TOKEN_STRING"
  }
  ```

---

## Skills Endpoints

**Note:** All endpoints require JWT authentication via `Authorization: Bearer <token>` header

### 1. Get All Skills
- **Endpoint:** `GET /api/skills`
- **Response:** Array of skill objects

### 2. Create Skill
- **Endpoint:** `POST /api/skills`
- **Request Body:**
  ```json
  {
    "name": "string",
    "level": "string"
  }
  ```

### 3. Get Skill by ID
- **Endpoint:** `GET /api/skills/{id}`
- **Path Parameter:** `id` (Long)

### 4. Update Skill
- **Endpoint:** `PUT /api/skills/{id}`
- **Path Parameter:** `id` (Long)
- **Request Body:**
  ```json
  {
    "name": "string",
    "level": "string"
  }
  ```

### 5. Delete Skill
- **Endpoint:** `DELETE /api/skills/{id}`
- **Path Parameter:** `id` (Long)

---

## Projects Endpoints

**Note:** All endpoints require JWT authentication

### 1. Get All Projects
- **Endpoint:** `GET /api/projects`

### 2. Create Project
- **Endpoint:** `POST /api/projects`
- **Request Body:**
  ```json
  {
    "title": "string",
    "description": "string",
    "technologies": "string",
    "url": "string"
  }
  ```

### 3. Get Project by ID
- **Endpoint:** `GET /api/projects/{id}`

### 4. Update Project
- **Endpoint:** `PUT /api/projects/{id}`
- **Request Body:** Same as Create Project

### 5. Delete Project
- **Endpoint:** `DELETE /api/projects/{id}`

---

## Education Endpoints

**Note:** All endpoints require JWT authentication

### 1. Get All Education
- **Endpoint:** `GET /api/education`

### 2. Create Education
- **Endpoint:** `POST /api/education`
- **Request Body:**
  ```json
  {
    "institution": "string",
    "degree": "string",
    "field": "string",
    "startDate": "YYYY-MM-DD",
    "endDate": "YYYY-MM-DD"
  }
  ```

### 3. Get Education by ID
- **Endpoint:** `GET /api/education/{id}`

### 4. Update Education
- **Endpoint:** `PUT /api/education/{id}`
- **Request Body:** Same as Create Education

### 5. Delete Education
- **Endpoint:** `DELETE /api/education/{id}`

---

## Experience Endpoints

**Note:** All endpoints require JWT authentication

### 1. Get All Experience
- **Endpoint:** `GET /api/experience`

### 2. Create Experience
- **Endpoint:** `POST /api/experience`
- **Request Body:**
  ```json
  {
    "company": "string",
    "position": "string",
    "description": "string",
    "startDate": "YYYY-MM-DD",
    "endDate": "YYYY-MM-DD"
  }
  ```

### 3. Get Experience by ID
- **Endpoint:** `GET /api/experience/{id}`

### 4. Update Experience
- **Endpoint:** `PUT /api/experience/{id}`
- **Request Body:** Same as Create Experience

### 5. Delete Experience
- **Endpoint:** `DELETE /api/experience/{id}`

---

## Testing with Postman

Import the `portfolio-task2.postman_collection.json` file located in this directory to test all endpoints.

### Quick Start:
1. Register a new user
2. Login to get JWT token
3. Add the token to Authorization header: `Bearer <token>`
4. Test CRUD operations on Skills, Projects, Education, or Experience

