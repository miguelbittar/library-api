# Library Management API

A REST API for managing library books built with Clean Architecture principles and Spring Boot.

## Features

* **Book Management**: Create, update, delete, and retrieve books with search functionality.
* **Clean Architecture**: Organized in layers for maintainability.
* **RESTful API**: Standard REST endpoints with proper HTTP status codes.
* **Exception Handling**: Centralized error handling.
* **API Documentation**: Swagger/OpenAPI documentation.
* **Containerization**: Docker setup with PostgreSQL.
* **Java 17**: Using records and modern Java features.

## Tech Stack

* **Java 17**: Records and modern language features.
* **Spring Boot**: For rapid development and Spring Data JPA for database interaction.
* **Docker**: Containerized application with PostgreSQL database.
* **PostgreSQL**: Database backend.
* **Swagger/OpenAPI**: API documentation.

## Architecture

The project follows **Clean Architecture** principles:

* **Separation of Concerns**: Clear layers (Core, Infrastructure, and Presentation).
* **Dependency Inversion**: Core business logic independent of frameworks.
* **Testability**: Components with clear interfaces.
* **Maintainability**: Organized code structure.

## Project Structure

```
src
├── main
│   ├── java
│   │   └── dev.miguelbittar.library_api
│   │       ├── core           # Business logic and entities
│   │       │   ├── entities   # Domain entities
│   │       │   ├── enums      # Domain enums
│   │       │   ├── gateway    # Gateway interfaces
│   │       │   └── usecases   # Business use cases
│   │       └── infra          # Infrastructure layer
│   │           ├── beans      # Spring configuration
│   │           ├── dtos       # Data transfer objects
│   │           ├── exceptions # Exception handling
│   │           ├── gateway    # Gateway implementations
│   │           ├── mapper     # Object mappers
│   │           ├── persistence # JPA entities and repositories
│   │           └── presentation # REST controllers
│   └── resources
│       └── application.properties # Application configuration
└── docker-compose.yml        # Docker configuration
```

## Getting Started

### Prerequisites

Ensure you have the following installed:
* Java 17
* Docker & Docker Compose
* Maven (optional, if not using Docker)

### Installation

1. Clone the repository:
```bash
git clone https://github.com/miguelbittar/library-api.git
cd library-api
```

2. Start the database with Docker:
```bash
docker-compose up -d
```

3. Run the application:
```bash
./mvnw spring-boot:run
```

4. Access the API documentation (Swagger):
```
http://localhost:8080/swagger-ui.html
```

## API Endpoints

### Books
* **GET /api/v1/books**: Retrieve all books
* **POST /api/v1/books**: Create a new book
* **PUT /api/v1/books/{id}**: Update a book by ID
* **DELETE /api/v1/books/{id}**: Delete a book by ID
* **GET /api/v1/books/search?title={title}**: Search books by title

### Example Request Body (POST/PUT)
```json
{
  "title": "Clean Code",
  "description": "A guide to writing clean, maintainable code",
  "isbn": "9780132350884",
  "availableCopies": 5,
  "author": "Robert Martin",
  "category": "TECHNICAL",
  "publisher": "Prentice Hall"
}
```

## Database

Uses PostgreSQL database. Schema is created automatically by JPA/Hibernate.

### Available Categories
- FICTION
- NON_FICTION  
- TECHNICAL
- BIOGRAPHY
- CHILDREN
- ACADEMIC
- REFERENCE
- POETRY
- DRAMA
- HISTORY

## Testing

Run tests with:
```bash
./mvnw test
```

## License

This project is licensed under the MIT License.