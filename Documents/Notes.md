# Green Connect 🌱

Green Connect is an environmental awareness and community engagement platform that connects citizens, environmentalists, and volunteers to promote sustainable living and environmental protection.

## 🚀 Technologies Used

- Java
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA / Hibernate
- H2 Database
- Maven

## ✅ Implemented Features

- User registration and login
- JWT-based authentication
- Password encryption using BCrypt
- Role-based access control:
  - USER
  - ENVIRONMENTALIST
  - SUPER_ADMIN
- Super Admin initialization
- Environmentalist application submission
- Admin approval and rejection of applications
- Automatic role update when an application is approved
- Protected API endpoints
- Persistent local H2 database
- Git configuration to exclude local IDE settings and database files

## 🔐 Authentication APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/auth/register` | Register a user |
| POST | `/api/auth/login` | Authenticate and receive a JWT |
| POST | `/api/environmentalist-applications` | Apply to become an environmentalist |
| GET | `/api/admin/environmentalist-applications/pending` | View pending applications (Super Admin) |
| POST | `/api/admin/environmentalist-applications/{id}/approve` | Approve an application |
| POST | `/api/admin/environmentalist-applications/{id}/reject` | Reject an application |

## ⚙️ Run Locally

1. Clone the repository:
   ```bash
   git clone https://github.com/Sindhuuu04/Green-Connect-Project.git
   ```
2. Open the `backend` folder in IntelliJ IDEA.
3. Configure the database and JWT properties in `application.properties`.
4. Run the Spring Boot application.
5. Access the backend at `http://localhost:8080`.

H2 Console: `http://localhost:8080/h2-console`

## 🛠️ Project Status

Backend development is in progress. Additional environmental features and frontend integration are planned.

## 👩‍💻 Author

Sindhu Harshitha
