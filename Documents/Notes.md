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


## 🚧 Features to Be Implemented

### 1. User Profile Management
- View and update user profiles
- Store profile details such as location, interests, and profile picture
- Allow users to view their account information securely

### 2. Environmental News and Stories
- Create, view, update, and delete environmental news articles
- Allow environmentalists and admins to publish content
- Display environmental news and awareness stories to users

### 3. Environmental Campaigns
- Create and manage eco-friendly campaigns
- Browse campaigns and view campaign details
- Allow users to join or participate in campaigns
- Track campaign participants

### 4. Volunteer Management
- Browse volunteering opportunities
- Register for volunteer activities
- Allow environmentalists to create and manage opportunities
- Track volunteer registrations and participation

### 5. Report Environmental Issues
- Allow users to report environmental problems
- Capture issue descriptions, categories, locations, and photos
- Track issue status: PENDING, IN_PROGRESS, and RESOLVED
- Allow authorized users to review and update reports

### 6. Waste Management and Recycling
- Provide waste segregation and recycling guidelines
- Display information about reusable and recyclable materials
- Organize waste management resources by category

### 7. Environmentalist and Organization Management
- Manage environmentalist profiles
- Allow environmental organizations or NGOs to register
- Display environmentalist and organization details
- Connect users with environmental initiatives

### 8. Environmental Status and Awareness
- Display area-wise pollution and environmental hazard information
- Integrate external APIs for air quality and weather data, if needed
- Provide environmental safety tips and awareness resources

### 9. Community Engagement
- Allow users to share environmental experiences and initiatives
- Enable users to comment on and engage with community posts
- Add validation and moderation to prevent inappropriate content

### 10. Notifications
- Notify users about campaign updates and volunteering activities
- Notify applicants when environmentalist applications are approved or rejected
- Notify users about updates to their environmental issue reports

### 11. Testing and Security
- Add unit and integration tests for services and controllers
- Validate request payloads and handle errors consistently
- Enforce role-based permissions for every protected operation
- Prevent sensitive information, such as password hashes, from appearing in API responses
- Review JWT secret management and default admin credentials before deployment

### 12. Frontend Development and Integration
- Build responsive registration and login pages
- Create dashboards for users, environmentalists, and super admins
- Integrate frontend pages with backend REST APIs
- Add JWT-based session handling and protected routes
- Test complete user workflows end to end


## 👩‍💻 Author

Sindhu Harshitha
