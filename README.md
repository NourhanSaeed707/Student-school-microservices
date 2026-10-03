# 🎓 School Management Microservices

A **School Management System** built using **Java, Spring Boot, and Microservices Architecture**.

The project is designed to demonstrate how multiple independent services communicate with each other through **Service Discovery and an API Gateway**, while centralized configuration is handled using **Spring Cloud Config Server**.

The application is fully containerized using **Docker** and uses **PostgreSQL** for data persistence.

---

## 🏗️ Architecture

```text
                         ┌─────────────────┐
                         │     Client      │
                         └────────┬────────┘
                                  │
                                  ▼
                         ┌─────────────────┐
                         │  API Gateway    │
                         │     :8222       │
                         └────────┬────────┘
                                  │
                    ┌─────────────┴─────────────┐
                    │                           │
                    ▼                           ▼
          ┌─────────────────┐         ┌─────────────────┐
          │ Student Service │         │  School Service │
          │     :8090       │         │     :8070       │
          └────────┬────────┘         └────────┬────────┘
                   │                           │
                   └────────────┬──────────────┘
                                │
                                ▼
                       ┌─────────────────┐
                       │    PostgreSQL   │
                       └─────────────────┘

              ┌──────────────────────────────┐
              │       Eureka Server          │
              │       Service Discovery      │
              │          :8761               │
              └──────────────────────────────┘

              ┌──────────────────────────────┐
              │       Config Server         │
              │     Centralized Config      │
              │          :8888              │
              └──────────────────────────────┘
```

---

## 🚀 Microservices

### 🏫 School Service

Responsible for managing school-related information.

**Main responsibilities:**

* Create schools
* Retrieve schools
* Update schools
* Delete schools
* Manage school information
* Communicate with other services when required

**Port:** `8070`

---

### 🎓 Student Service

Responsible for managing students.

**Main responsibilities:**

* Create students
* Retrieve students
* Update students
* Delete students
* Manage student information
* Associate students with schools

**Port:** `8090`

---

## ☁️ Infrastructure Services

### 🔎 Eureka Server

Used for **Service Discovery**.

Instead of services communicating using hardcoded IP addresses and ports, they register themselves with Eureka.

For example:

```text
Student Service
      │
      │ registers
      ▼
Eureka Server
      ▲
      │ registers
      │
School Service
```

This allows services to discover each other dynamically.

**Port:** `8761`

---

### 🚪 API Gateway

The API Gateway acts as the **single entry point** for clients.

Instead of communicating directly with each microservice:

```text
Client → Student Service
Client → School Service
```

the client communicates through:

```text
Client
   │
   ▼
API Gateway
   │
   ├──→ Student Service
   │
   └──→ School Service
```

**Port:** `8222`

The Gateway is responsible for:

* Routing requests
* Hiding internal service addresses
* Providing a single entry point
* Integrating with service discovery

---

### ⚙️ Config Server

The Config Server provides **centralized configuration management**.

Instead of keeping configuration separately inside every service, configuration can be managed centrally.

Example:

```text
Config Server
      │
      ├── Student Service Configuration
      │
      └── School Service Configuration
```

**Port:** `8888`

---

## 🗄️ Database

The project uses **PostgreSQL** for persistent data storage.

Each microservice can manage its own data and database configuration independently.

Example:

```text
Student Service ──── PostgreSQL
School Service  ──── PostgreSQL
```

This follows the microservices principle of keeping services **loosely coupled**.

---

## 🛠️ Technologies Used

### Backend

* ☕ Java
* 🌱 Spring Boot
* 🌱 Spring Cloud
* Spring Data JPA
* Hibernate
* REST APIs

### Microservices

* Eureka Service Discovery
* Spring Cloud Gateway
* Spring Cloud Config Server

### Database

* PostgreSQL

### DevOps / Deployment

* Docker
* Docker Compose

### Tools

* IntelliJ IDEA
* Postman
* Maven
* Git & GitHub

---

## 📁 Project Structure

```text
school-management-microservices/
│
├── config-server/
│   └── src/
│
├── discovery-server/
│   └── src/
│
├── gateway/
│   └── src/
│
├── school-service/
│   └── src/
│
├── student-service/
│   └── src/
│
├── configurations/
│   ├── application.yml
│   ├── school-service.yml
│   └── student-service.yml
│
├── docker-compose.yml
│
└── README.md
```

---

🔄 How the Application Works
1️⃣ Application Startup

The infrastructure services start first:

Config Server
      ↓
Eureka Server
      ↓
API Gateway
      ↓
Student Service
      ↓
School Service
2️⃣ Service Registration

The Student and School services register themselves with Eureka.

Student Service ──────┐
                      │
                      ▼
                Eureka Server
                      ▲
                      │
School Service ───────┘

Eureka keeps track of:

Service name
Service instance
IP address
Port
Availability
3️⃣ Client Request

A client sends a request to the Gateway:

GET /api/v1/students

The request goes through:

Client
  │
  ▼
API Gateway
  │
  ▼
Eureka
  │
  ▼
Student Service
  │
  ▼
PostgreSQL

The response is then returned to the client.

🐳 Running with Docker

Make sure Docker is installed and running.

Clone the repository:

git clone https://github.com/your-username/school-management-microservices.git

Navigate to the project:

cd school-management-microservices

Start the containers:

docker-compose up -d

Check running containers:

docker ps

To stop the application:

docker-compose down
