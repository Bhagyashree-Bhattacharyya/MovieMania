# MovieMania

## Description

MovieMania is a Java-based web application (backend) developed using Spring Boot and Spring Framework technologies. It provides functionalities similar to BookMyShow, allowing users to browse movies, view showtimes, book tickets, and manage their bookings seamlessly.

## Features

- **User Authentication and Authorization**: Secure user registration and login mechanisms with Spring Security.
- **Movie Listings and Details**: Comprehensive listings of movies, including details such as synopsis, cast, and trailers.
- **Booking System**: Intuitive interface for selecting seats, managing bookings, and making payments.
- **Email Notifications**: Integration with Spring Boot's email module to send booking confirmations and updates.
- **Integration with Kafka**: Asynchronous event processing using Spring Kafka for real-time updates and notifications.

## Technologies Used

- **Java 17**: Programming language for backend development.
- **Spring Boot 3.3.1**: Framework for rapid application development.
  - `spring-boot-starter-data-jpa`
  - `spring-boot-starter-mail`
  - `spring-boot-starter-security`
  - `spring-boot-starter-web`
- **MySQL**: Relational database management system for data storage.
  - `mysql-connector-j` for JDBC connectivity.
- **Other Dependencies**:
  - `javax.validation` for input validation.
  - `com.googlecode.json-simple` for JSON processing.
  - `org.projectlombok` for reducing boilerplate code.
  - `spring-kafka` for event-driven architecture.

## Setup Instructions

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Bhagyashree-Bhattacharyya/MovieMania.git
   cd MovieMania
   ```

2. **Build and run using Maven**
   ```bash
    mvn clean install
    mvn spring-boot:run
   ```

3. **Access the application**
   
- Use http://localhost:8080 on PostMan to access MovieMania.

4. **Database Configuration**

- Ensure MySQL is installed and running.
- Update application.properties with your database credentials.
