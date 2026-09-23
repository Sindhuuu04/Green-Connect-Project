# Green Connect – Backend (Spring Boot)

Basic REST API skeleton for the Green Connect platform, built with Spring Boot 3
and an in-memory H2 database so it runs with zero setup.

## Modules included (mapped to the functional requirements)

| Module | Endpoint |
|---|---|
| News & Stories | `/api/news` |
| Plastic-Free Campaigns | `/api/campaigns` |
| Volunteering Opportunities | `/api/volunteer-opportunities` |
| Waste Management Guide | `/api/waste-categories` |
| Report an Issue | `/api/issue-reports` |
| Environmentalist Network | `/api/environmentalists` |

Each module has a `GET` (list), `GET /{id}`, and `POST` (create) endpoint to start with.
Update/delete endpoints, authentication, and the pollution/hazard indicator can be added
as the project grows.

## Prerequisites

- Java 17 (JDK)
- Maven (or use the included wrapper once generated — see below)

## Run it locally

```bash
cd backend/green-connect-backend
mvn spring-boot:run
```

The API will start on `http://localhost:8080`. Try `http://localhost:8080/api/news`
in your browser — it will return an empty list `[]` until you POST some data.

The H2 database console is available at `http://localhost:8080/h2-console`
(JDBC URL: `jdbc:h2:mem:greenconnect`, username: `sa`, no password).

## Next steps

- Point the frontend's fetch/AJAX calls at these endpoints instead of static data.
- Swap H2 for MySQL/PostgreSQL in `application.properties` before deploying.
- Add a `service` layer and DTOs once business logic grows beyond simple CRUD.
- Add Spring Security for the Login/Signup module.
