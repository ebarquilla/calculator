# Calculator REST API (API-First)

This project is a calculator microservice implemented using an **API-First** approach with **OpenAPI 3.1.0**.

## Description

The application provides REST endpoints to perform basic arithmetic operations. The API interface and DTOs are **automatically generated** from the `openapi.yaml` specification file using the `openapi-generator-maven-plugin`.

**Endpoints:**
* Sum (`/api/v1/math/sum`)
* Subtraction (`/api/v1/math/subtract`)

## Requirements

* Java 25
* Maven 3.8+

## Development Workflow

1. **Edit API Spec**: Modify `openapi.yaml` to define new endpoints or models.
2. **Generate Code**: Run `mvn clean compile` to generate the Java interfaces and DTOs in `target/generated-sources/openapi`.
3. **Implement**: Implement the generated interfaces in the controller.

## Installation and Execution

1. Clone the repository:
   ```bash
   git clone https://github.com/ebarquilla/calculator.git
   cd calculator
   ```

2. Run the application using Maven:
   ```bash
   mvn spring-boot:run
   ```

3. **Build and Run as JAR**:
   
   Alternatively, you can package the application into a standalone JAR file:

   *   **Generate JAR**:
       ```bash
       mvn clean package
       ```
       This creates the executable file in `target/calculator-0.0.1-SNAPSHOT.jar`.

   *   **Execute JAR**:
       ```bash
       java -jar target/calculator-0.0.1-SNAPSHOT.jar
       ```

The application will start by default on port `8080`.

## API Usage

### Base URL
`http://localhost:8080/api/v1`

### Endpoints

#### 1. Sum
Performs the sum of two numbers.

**Request:** `POST /math/sum`

**Body:**
```json
{
  "numberA": 10.5,
  "numberB": 5.5
}
```

**Example (Linux/Mac/Bash):**
```bash
curl -X POST "http://localhost:8080/api/v1/math/sum" \
     -H "Content-Type: application/json" \
     -d '{ "numberA": 10.5, "numberB": 5.5 }'
```

**Example (Windows Command Prompt):**
```bash
curl -X POST "http://localhost:8080/api/v1/math/sum" -H "Content-Type: application/json" -d "{\"numberA\": 10.5, \"numberB\": 5.5}"
```

**Example (PowerShell):**
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/v1/math/sum" -Method POST -ContentType "application/json" -Body '{"numberA": 10.5, "numberB": 5.5}'
```

**Response:**
```json
{
  "result": 16.0
}
```

#### 2. Subtraction
Performs the subtraction of two numbers.

**Request:** `POST /math/subtract`

**Body:**
```json
{
  "numberA": 20,
  "numberB": 8
}
```

**Example (Linux/Mac/Bash):**
```bash
curl -X POST "http://localhost:8080/api/v1/math/subtract" \
     -H "Content-Type: application/json" \
     -d '{ "numberA": 20, "numberB": 8 }'
```

**Example (Windows Command Prompt):**
```bash
curl -X POST "http://localhost:8080/api/v1/math/subtract" -H "Content-Type: application/json" -d "{\"numberA\": 20, \"numberB\": 8}"
```

**Example (PowerShell):**
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/v1/math/subtract" -Method POST -ContentType "application/json" -Body '{"numberA": 20, "numberB": 8}'
```

**Response:**
```json
{
  "result": 12.0
}
```

## Error Handling

The application includes a centralized **Global Exception Handler** (`GlobalExceptionHandler`) to manage errors:

*   **400 Bad Request**: Returned when the input is invalid (e.g., malformed JSON, type mismatch).
    *   Example: Sending a string `"ten"` to a field expecting a number.
*   **500 Internal Server Error**: Returned for unexpected system exceptions.

## Custom Tracing Library

The application integrates a **custom tracing library** (`tracer-1.0.0.jar`) to trace all operations.

*   **Location**: `libs/tracer-1.0.0.jar`
*   **Dependency**: Configured in `pom.xml` with `scope=system`.
*   **Configuration**: The bean is exposed via `TracerConfiguration` class, instantiating `TracerImpl`.

## Project Structure

* `openapi.yaml`: The Single Source of Truth for the API.
* `pom.xml`: Configured with `openapi-generator-maven-plugin` (v7.18.0) and `build-helper-maven-plugin`.
* `src/main/java`:
  * `controller`: implementations of the generated API interfaces.
  * `service`: Business Logic.
  * `exception`: Global exception handling.
* `target/generated-sources/openapi`: **(Generated)** Contains the `MathApi` interface and DTOs (`MathRequest`, `MathResponse`, `ErrorResponse`).

## Technologies

* **Spring Boot 4**: Main framework.
* **OpenAPI Generator**: For API-First code generation.
* **Maven**: Dependency management and build tool.
