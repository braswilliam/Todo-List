# ToDo List Application

This is a simple ToDo List application built with Spring Boot and MySQL. It provides basic CRUD (Create, Read, Update, Delete) operations for managing to-do items.

## Features

- Create new to-do items
- List all to-do items
- Update existing to-do items
- Delete to-do items


## Technologies Used

- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- Swagger
- Jakarta Validation

## Setup and Installation

### Prerequisites

- Java 22 or higher
- Maven
- MySQL


### Database configuration
Ensure you have a MySQL database running. Create a database named todolist and update the application.properties file with your database credentials.

Configure application.properties
Update the `src/main/resources/application.properties` file with your database details:

git 
enter the information:
``` java
spring.datasource.url=jdbc:mysql://localhost:3306/todolist
spring.datasource.username=root
spring.datasource.password=Your_Password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
```

Build and Run the Application
Build the application:
`./mvnw clean install`

Run the application:`./mvnw spring-boot:run`
The application will start and listen on port 8080 by default.

## API Endpoints
### Create a ToDo
- URL: ``/todos``
- Method: ``POST ``
- Request Body:
```json
{
"name": "Buy groceries",
"description": "Milk, bread, eggs",
"carriedOut": false,
"priority": "High"
}
```
- Response: Returns the created to-do item.

### List All ToDos
- URL: ``/todos``
- Method: ``GET``
- Response: Returns a list of all to-do items.

### Update a ToDo
- URL: /todos
- Method: ``PUT``
- Request Body:
```json
{
  "id": 1,
  "name": "Buy groceries",
  "description": "Milk, bread, eggs, and butter",
  "carriedOut": false,
  "priority": "Medium"
}
```
- Response: Returns the updated list of to-do items.


### Delete a ToDo
- URL: `/todos/{id}`
- Method: `DELETE`
- Path Variable:
  - `id`: ID of the to-do item to be deleted.
- Response: Returns the updated list of to-do items after deletion.

## Automated Tests
Automated tests have been implemented to ensure the correct functioning of the main features of the application. They use JUnit and WebTestClient to perform the following checks:
### Successful Task Creation Test
- Method: ``testeCreateTodoSuccess()``
- Description: Verifies that a task is created correctly when valid data is provided.
- Validations:
  - ``HTTP Status 200 OK``.
  - Response in ``JSON`` format.
  - The created task data matches the provided data.

### Failed Task Creation Test
- Method: ``testeCreateTodoFailure()``
- Description: Verifies that task creation fails when invalid data is provided.
- Validations:
  - HTTP Status ``400 Bad Request``

### Get All Tasks Test
- Method: testeGetAllTodos()
- Description: Verifies that all tasks are listed correctly.
- Validations:
  - HTTP Status 200 OK.
  - Response in ``JSON`` array format.

### List Tasks Test
- Method: ``testeListTodos()``
- Description: Similar to the list tasks test, it ensures that the task listing works as expected.
- Validations:
  - HTTP Status 200 OK.
  - Response in JSON array format.

## Entity Model
### Todo
The `Todo` entity represents a to-do item with the following fields:
- `id` (Long): Unique identifier for the to-do item (auto-generated).
- `name` (String): Name of the to-do item (required).
- `description` (String): Description of the to-do item (required).
- ``carriedOut`` (boolean): Indicates whether the to-do item has been carried out.
- ``priority`` (String): Priority level of the to-do item.

### Clone the Repository
```bash
git clone https://github.com/braswilliam/Todo-List.git
cd todolist
```