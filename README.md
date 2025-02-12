# outerspace-java

This is a Spring Boot application that provides a REST API wrapper for the SpaceX API. It allows you to fetch SpaceX launches data through simple REST endpoints.

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

## Building the Application

To build the application, run the following command in the project root directory:
```
mvn clean install
```


## Running the Application

There are two ways to run the application:

1. Using Maven:
```
mvn spring-boot:run
```

2. Using the JAR file directly:
```
java -jar target/spacex-api-0.0.1-SNAPSHOT.jar
```

The application will start on port 8080.

## API Endpoints

The following endpoints are available:

1. Get all launches:
```
GET http://localhost:8080/api/spacex/launches
```

2. Get a specific launch by ID:
```
GET http://localhost:8080/api/spacex/launches/{id}
```

3. Get all rockets:
```
GET http://localhost:8080/api/spacex/rockets
```

4. Get a specific rocket by ID:
```
GET http://localhost:8080/api/spacex/rockets/{id}
```

5. Get a random math fact:
```
GET http://localhost:8080/api/numbers/math/random
```

## Technologies Used

- Spring Boot 3.2.3
- Spring WebFlux
- Project Lombok
- Maven
