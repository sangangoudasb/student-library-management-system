# student-library-management-system
Spring Boot–based Library Management System backend with REST APIs to manage students, authors, books, cards, and transactions. Built using layered architecture (Controller, Service, Repository), DTO-based request handling, JPA/Hibernate, pagination, sorting, and custom queries.
# Student Library Management System

A backend RESTful application built using Spring Boot to manage students, authors, books, library cards, and transactions.

## Features
- CRUD operations for Students, Authors, Books, Cards, and Transactions
- REST APIs using Spring Boot
- Layered architecture (Controller, Service, Repository)
- DTO-based request handling
- Pagination and sorting
- Custom queries using Spring Data JPA
- MySQL database integration using Hibernate

## Tech Stack
- Java
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL
- Maven
- Postman

## Project Structure
- controller
- service
- repository
- model
- requestdto
- converters
- enums

## How to Run
1. Clone the repository
2. Configure MySQL in `application.properties`
3. Run the application using IDE or `mvn spring-boot:run`
4. Test APIs using Postman
