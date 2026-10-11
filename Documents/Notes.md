# Backend Funtinality and Concepts
DAY1: Security and Rolebased Authentication
Stack: Spring Boot 3.3.4 application using Java 17, Spring Web, Spring Data JPA, H2, and Bean Validation.
>H2 Database is a small, lightweight relational database written in Java. It is commonly used in Spring Boot applications, especially for development, testing, and learning.
>The main difference is that H2 is very lightweight and can run inside your application.
>Instead of installing and configuring MySQL just to test your APIs, you can use H2.Spring Boot can start an H2 database automatically when your application starts.

One important point: we'll keep H2 initially so that we can develop authentication without introducing MySQL/PostgreSQL configuration problems. Once the backend structure is stable, we can decide whether Green Connect should move to a production database.

application.properties → Configuration || pom.xml → Dependencies & Project Setup

1: rolebased authentication, spring security, authentication package

DTO = Data Transfer Object is a Java class used to transfer data between layers of your application. DTO is a container/class used to carry only the data needed between different parts of an application.  
Database → Entity → Service → DTO → Controller → Frontend  

passwordEncoder.encode(request.getPassword()): We will never store the actual password in the database. {Path: auth/AuthService.java}

Your H2 configuration currently uses an in-memory database:
jdbc:h2:mem:greenconnect
and Hibernate is configured with:
spring.jpa.hibernate.ddl-auto=update
so the users table should be created from the new entity when the application starts
Green Connect Backend
│
├── Existing Modules
│   ├── Campaign
│   ├── Environmentalist
│   ├── Issue Report
│   ├── News
│   ├── Volunteer
│   └── Waste Management
│
└── Authentication
    │
    ├── User
    ├── Role
    │   ├── USER
    │   ├── ENVIRONMENTALIST
    │   └── SUPER_ADMIN
    │
    ├── Registration
    ├── Password Encryption
    └── Security Configuration
DAY2: Login + JWT Authentication.
JWT dependency: <groupId>io.jsonwebtoken</groupId>
in pom.xml: groupId = Who/which organization?, artifactId = Which application?, version = Which version?
JWT configuration:{src/main/resources/application.properties} this secret is only for our local development. Before production, we'll replace it with a secure environment variable.
                 GREEN CONNECT
                       │
                Authentication
                       │
             ┌─────────┴─────────┐
             │                   │
        REGISTER               LOGIN
             │                   │
             ▼                   ▼
          User DB             JWT Token
             │                   │
             └─────────┬─────────┘
                       ▼
                    NEXT
                       │
                       ▼
             Spring Security
                       │
          ┌────────────┼────────────┐
          ▼            ▼            ▼
        USER     ENVIRONMENTALIST  SUPER_ADMIN
DAY3: Testing the Login {Encountered Issue}
in authcontroller we did not add login api mapping and that was the reason we were not getting response when tested in postman so then added but when tried again with the wrong password then we got internal server error
so, under dto added:ErrorResponse.java and under auth added: GlobalExceptionHandler.java
Now when your AuthService does:
throw new RuntimeException("Invalid email or password");
instead of Spring returning:
500 Internal Server Error
our handler will return:
401 Unauthorized
Our current exception handler catches all RuntimeExceptions and converts them to 401.
That's okay temporarily while we're building authentication, but we won't leave it like that.
Later we'll introduce proper exceptions such as:
AuthenticationException
ResourceNotFoundException
BadRequestException
AccessDeniedException
so that:
Invalid login       → 401
Validation error    → 400
Not found           → 404
No permission       → 403
Server problem      → 500
                 AUTHENTICATION
                       │
          ┌────────────┴────────────┐
          ▼                         ▼
      REGISTER                    LOGIN
          │                         │
          ▼                         ▼
       User DB                 Find User
          │                         │
          ▼                         ▼
    BCrypt Password           Verify Password
                                    │
                              ┌─────┴─────┐
                              │           │
                           Correct      Wrong
                              │           │
                              ▼           ▼
                            JWT         401
                              │
                              ▼
                           USER

# Backend Funtinality and Concepts
DAY1: Security and Rolebased Authentication
Stack: Spring Boot 3.3.4 application using Java 17, Spring Web, Spring Data JPA, H2, and Bean Validation.
>H2 Database is a small, lightweight relational database written in Java. It is commonly used in Spring Boot applications, especially for development, testing, and learning.
>The main difference is that H2 is very lightweight and can run inside your application.
>Instead of installing and configuring MySQL just to test your APIs, you can use H2.Spring Boot can start an H2 database automatically when your application starts.
>
>
# 🌱 Green Connect

Green Connect is a web-based environmental awareness and community engagement platform designed to encourage people to participate in environmental protection activities.

## 📌 Project Overview

Green Connect connects citizens, environmentalists, and administrators through a centralized platform that promotes environmental awareness and community-driven initiatives.

## ✨ Features

- User Registration and Login
- JWT-Based Authentication
- Environmental Campaign Management
- Environmentalist Applications
- Role-Based Access Control
- Environmental Issue Reporting
- Volunteer Opportunities
- Environmental Awareness and Sustainability

## 🛠️ Tech Stack

### Backend
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Spring Security
- JWT Authentication

### Database
- H2 Database

### Frontend
- React.js

### Tools
- IntelliJ IDEA
- Maven
- Postman
- Git and GitHub

## 📂 Project Structure

```text
Green-Connect-Project/
├── backend/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       └── resources/
│   │           └── application.properties
│   └── pom.xml
├── frontend/
│   ├── src/
│   ├── public/
│   └── package.json
└── README.md
```

## ⚙️ Prerequisites

Make sure you have the following installed:

- Java JDK
- Maven
- Node.js and npm
- Git

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/Sindhuuu04/Green-Connect-Project.git
cd Green-Connect-Project
```

### 2. Run the Backend

Navigate to the backend directory containing `pom.xml`:

```bash
cd backend
```

Build the project:

```bash
mvn clean install
```

Start the Spring Boot application:

```bash
mvn spring-boot:run
```

The backend server runs at:

http://localhost:8080

### 3. Access the H2 Database Console

Open the following URL in your browser:

http://localhost:8080/h2-console

Enter the JDBC URL, username, and password configured in `application.properties`.

### 4. Run the Frontend

Open a new terminal and navigate to the frontend directory:

```bash
cd frontend
npm install
```

For a React application using Vite:

```bash
npm run dev
```

For a React application using Create React App:

```bash
npm start
```

## 🔐 Authentication and Authorization

The backend uses Spring Security and JWT to support authentication and authorization.

Supported user roles include:

- **USER:** Accesses general platform features.
- **ENVIRONMENTALIST:** Supports environmental initiatives.
- **SUPER_ADMIN:** Manages administrative operations.

Actual permissions depend on the application's security configuration.

## 🔗 API Testing

Use Postman to test the backend REST APIs.

Example authentication endpoints:

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/auth/register` | User registration |
| POST | `/api/auth/login` | User login |
| GET | `/api/campaigns` | Retrieve campaigns |

Confirm the endpoint paths against the actual controller mappings in the project.

## 🔮 Future Enhancements

- Campaign creation and participation
- Environmentalist application approval
- Environmental issue tracking
- Volunteer management
- Environmental impact dashboards
- Cloud deployment

## 🎯 Project Goal

To encourage environmental responsibility by connecting people with sustainability initiatives and environmental protection activities.

## 👩‍💻 Author

**Sindhu Harshitha Thoviti**

GitHub: [Sindhuuu04](https://github.com/Sindhuuu04)

---

**Green Connect — Connecting People for a Greener Future 🌍**
