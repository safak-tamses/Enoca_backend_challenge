# Enoca_backend_challenge
 Enoca firması için hazırlanmış işa alım mülakatı testi ve cevapları


This project includes a Spring Boot-based backend application.

## Requirements

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) (for the Backend)
- [PostgreSQL](https://www.postgresql.org/) database

## Backend (Spring Boot) Setup


1. Navigate to the `enoca_backend_challenge_soru5` folder: `cd enoca_backend_challenge_soru5`.

2. To set up the PostgreSQL database, configure the `application.properties` file located at `backend/src/main/resources/application.yml` with the necessary database connection details:

```bash
datasource:
    url: jdbc:postgresql://localhost:5432/enoca
    username: db Username
    password: db Password
```

## To start the application:
1. After configuring the database, build and install the required dependencies for the Spring project using Maven:

```bash
mvn clean install
```

2. Start the Spring Boot application by running the following command:

```bash
java -jar backend/target/application.jar
```

This command will launch the Spring Boot application.

## API Documentation

-> You can review the required technical requirements in the project from the following file: `Backend_Challenge_-3.pdf` located at the root path.

->  To access the Postman collection with predefined requests, import the file `EtsTurJavaTestCase.postman_collection.json` located at the root path.

->  To explore the backend API endpoints and make requests, you can access the Swagger documentation at `http://localhost:8080/swagger-ui/index.html`.

## Contact

->  For any questions or feedback regarding the project, you can contact us at safak.tamses@gmail.com .



