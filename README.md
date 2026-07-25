# MS MPOS Integration Service

A Spring Boot microservice developed during my internship, focused on integrating multiple internal banking services through secure REST APIs and OpenFeign clients.

The project demonstrates enterprise backend development practices, external service integrations, request/response mapping, and layered architecture.

> **Note**
> This repository is shared for educational and portfolio purposes only. Confidential business logic, credentials, and sensitive information have been removed.


## Features

- RESTful API development
- Integration with multiple external services
- OpenFeign declarative HTTP clients
- OAuth2-secured service communication
- Request and response mapping
- Layered architecture
- Exception handling
- Swagger/OpenAPI documentation
- Configuration-based client management
- MapStruct object mapping

## Tech Stack

| Category | Technologies |
|----------|--------------|
| Language | Java 21 |
| Framework | Spring Boot 3.3 |
| Security | Spring Security, OAuth2 Client |
| Communication | OpenFeign |
| Database | Oracle Database |
| Mapping | MapStruct |
| Documentation | Swagger / OpenAPI |
| Build Tool | Gradle |
| Utilities | Lombok |

## External Integrations

The service communicates with several external systems using OpenFeign clients.

Current integrations include:

- Account Service
- Atlas Service
- Commission Service
- Taxes Service

Each client has its own configuration and is managed independently.

## Getting Started

Clone the repository

```bash
git clone https://github.com/nurcannafi/ms-mpos-kapital.git
```

Run the application

```bash
./gradlew bootRun
```

---

## API Documentation

After starting the application:

http://localhost:8080/swagger-ui/index.html

## Architecture

The project follows a layered architecture.

Client Layer (OpenFeign)
          │
          ▼
Controller Layer
          │
          ▼
Service Layer
          │
          ▼
External Banking Services

