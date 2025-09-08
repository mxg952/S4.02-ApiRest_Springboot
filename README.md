# S4.02 Api Rest amb Spring boot

## 📋 Project Description

This project implements a RESTful CRUD API for managing fruits using three different databases:
- **Level 1**: H2 in-memory database
- **Level 2**: MySQL relational database  
- **Level 3**: MongoDB document database

The API follows MVC architecture and implements proper HTTP verbs, status codes, and global exception handling.

## 🚀 Technologies Used

- **Java 24**
- **Spring Boot**
- **Spring Data JPA** (H2 & MySQL)
- **Spring Data MongoDB**
- **H2 Database**
- **MySQL**
- **MongoDB**
- **Gradle**

## 📁 Project Structure

```
S4T02N01_N02/                    # Levels 1 & 2 (H2 & MySQL)
├── src/
│   ├── main/java/cat/itacademy/s04/t02/n01/    # H2 implementation
│   └── main/java/cat/itacademy/s04/t02/n02/    # MySQL implementation
└── build.gradle

S4T02N03/                       # Level 3 (MongoDB)
├── src/main/java/cat/itacademy/s04/t02/n03/    # MongoDB implementation
└── build.gradle
```

## 🍏 Entity Model

```java
public class Fruita {
    private String id;          // MongoDB uses String ID
    private String nom;         // Fruit name
    private int quantitatQuilos; // Quantity in kilograms
}
```

## 🌐 API Endpoints

All endpoints are available at `http://localhost:8080/fruita/`

| Method | Endpoint | Description | HTTP Status |
|--------|----------|-------------|-------------|
| POST | `/add` | Create new fruit | 201 Created |
| GET | `/getOne/{id}` | Get fruit by ID | 200 OK / 404 Not Found |
| GET | `/getAll` | Get all fruits | 200 OK |
| PUT | `/update/{id}` | Update fruit | 200 OK / 404 Not Found |
| DELETE | `/delete/{id}` | Delete fruit | 200 OK / 404 Not Found |

## 🛠️ Installation & Setup

### Prerequisites
- Java 11 or higher
- Gradle
- MySQL (for Level 2)
- MongoDB (for Level 3, optional with Docker)

### Running the Applications by Terminal

#### Level 1 - H2 Database
```bash
cd S4T02N01_N02
./gradlew bootRun --args='--spring.profiles.active=h2'
```

Access H2 Console: http://localhost:8080/h2-console

#### Level 2 - MySQL Database
```bash
cd S4T02N01_N02  
./gradlew bootRun --args='--spring.profiles.active=mysql'
```

#### Level 3 - MongoDB
```bash
cd S4T02N03
./gradlew bootRun
```

## 📊 Testing the API

### Create a Fruit
```bash
curl -X POST http://localhost:8080/fruita/add \
  -H "Content-Type: application/json" \
  -d '{"nom": "Poma", "quantitatQuilos": 10}'
```

### Get All Fruits
```bash
curl -X GET http://localhost:8080/fruita/getAll
```

### Get Fruit by ID
```bash
curl -X GET http://localhost:8080/fruita/getOne/68be9acce0aab04b21f7b72c
```

### Update Fruit
```bash
curl -X PUT http://localhost:8080/fruita/update/68be9acce0aab04b21f7b72c \
  -H "Content-Type: application/json" \
  -d '{"nom": "Poma Golden", "quantitatQuilos": 15}'
```

### Delete Fruit
```bash
curl -X DELETE http://localhost:8080/fruita/delete/68be9acce0aab04b21f7b72c
```

## 🏗️ Architecture Features

- **MVC Pattern** with clear separation of concerns
- **Global Exception Handling** with `@ControllerAdvice`
- **Proper HTTP Status Codes** and responses
- **Repository Pattern** for data access
- **Service Layer** for business logic
- **RESTful API Design** best practices

## 🔧 Configuration Files

### application.properties (MySQL)
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/fruites_db
spring.datasource.username=user
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
```

### application.properties (MongoDB)
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/fruitesdb
spring.data.mongodb.database=fruitesdb
```

## 🎯 Key Learning Objectives

- ✅ HTTP Verbs implementation
- ✅ HTTP Status codes management  
- ✅ CRUD operations with Spring Boot
- ✅ Multiple database integration (H2, MySQL, MongoDB)
- ✅ Separation of layers architecture
- ✅ Global exception handling
- ✅ REST API best practices


## 🤝 Contributing

This project was developed as part of the Java & Spring Framework course at IT Academy, following specific requirements and learning objectives.

