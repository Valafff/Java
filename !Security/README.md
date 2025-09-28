#Пример Регистрации Аутентификации пользователя. Блок пользователя после n попыток входа. Пэйджирование. Работа с базой
# Secure Spring Boot Application

This is a Spring Boot application that demonstrates user registration, login, and account management with security features like password hashing and account locking.

## Features

- User registration with password hashing (BCrypt)
- User login with authentication
- Account locking after 5 failed login attempts for 30 minutes
- User data page with a paginated table of login attempts
- Account deletion
- Session management

## Technologies Used

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL
- Thymeleaf
- Maven

## How to Run

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/your-username/secure1.git
    cd secure1
    ```
2.  **Create a PostgreSQL database:**
    - Create a database named `testDB`.
3.  **Configure the database connection:**
    - Open `src/main/resources/application.properties` and update the following properties with your PostgreSQL credentials:
      ```properties
      spring.datasource.url=jdbc:postgresql://localhost:5433/testDB
      spring.datasource.username=vi
      spring.datasource.password=12345
      ```
4.  **Run the application:**
    ```bash
    ./mvnw spring-boot:run
    ```
5.  **Access the application:**
    - Open your web browser and go to `http://localhost:8080`.

## Test Users

The application comes with three test users. The password for all users is `password`.

- `user1`
- `user2`
- `user3`
