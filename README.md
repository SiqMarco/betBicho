# JogoDoBicho - Betting Game Service

## Overview
This project is a Spring Boot application that simulates a betting game service called **JogoDoBicho**. It showcases the implementation of a basic betting system, focusing on game validation and result calculation. The logic behind the game is encapsulated within the `JogoDoBicho` service, and the project adheres to the requirements outlined in the document: **"src/main/java/org/example/docs/Exercício de Programação - JOGO DO BICHO.pdf"**.

## Features
- **Game Simulation**: Implements core logic for a betting game.
- **Game Validation**: The `validateGame` method evaluates user bets based on predefined rules.
- **Spring Boot Integration**: Utilizes Spring Boot's dependency injection for seamless component management.

## Project Structure
- **Main Class**: Entry point that initializes the Spring Boot application and executes the betting game logic.
- **Services**:
  - `JogoDoBicho`: Core service that handles the game's validation and result generation.
- **Docs**: Project requirements and instructions can be found in **"src/main/java/org/example/docs/Exercício de Programação - JOGO DO BICHO.pdf"**.

## Prerequisites
Before running the project, ensure the following tools are installed:
- **Java Development Kit (JDK)**: Version 17 or higher is required for compatibility with Spring Boot (Java 22 is not stable yet).
- **Build Tool**: You can use either **Maven** or **Gradle** for dependency management and building the project.
- **Spring Boot**: Spring Boot is already integrated in the project for application configuration and management.

## Getting Started

### 1. Clone the Repository
First, clone the project repository to your local machine:
```bash
git clone https://github.com/your-username/JogoDoBicho.git
```
### 2. Open in Your IDE
To open the project in your preferred IDE (e.g., IntelliJ IDEA):
- **IntelliJ IDEA**:
  - Open the application.
  - Navigate to **File > Open**, and select the folder where the repository is cloned.
  - IntelliJ will detect the project structure automatically.

## 3. Build the Project
After opening the project, ensure all dependencies are properly installed by building the project:
- If using **Maven**, execute:
  ```bash
  mvn clean install
  ```
- If using **Gradle**, execute:
  ```
    ./gradlew build
  ```
## 4. Running the Application
After building the project, you can run the application in the following ways:

- **From IntelliJ IDEA**:
  - Right-click the `Main` class and choose **Run 'Main'** to start the application.

- **From the Terminal (Gradle)**:
  - Run the following command:
    ```bash
    ./gradlew bootRun
    ```

This will start the application, and the **Spring Boot** context will be initialized.

## Usage Example
When the application is running, it performs the following steps:
1. The **Spring Boot Application Context** is initialized.
2. The **JogoDoBicho** service is retrieved from the context.
3. A sample bet is defined with fixed values for the bet number, bet value, and sorted number.
4. The **validateGame** method is called to validate the bet and return the result.
5. The result of the validation is printed to the console.

### Sample Output:
```text
Bet Number: 1234
Bet Value: 50.0
Sorted Number: 5678
Result: 800.00
```
## Dependencies
This project includes the following core dependencies:

- **Spring Boot 3.3.4**: Provides the application setup and dependency injection.
- **JUnit 5.10.0**: Used for writing and executing unit tests.
- **Mockito 5.5.0**: Allows for mocking dependencies during tests.
- **Lombok 1.18.34**: Helps reduce boilerplate code by generating methods like getters, setters, and constructors.

## Running Tests
To run the test suite, use the following command:

```bash
./gradlew test
```
## Contributing
We welcome contributions to the project! To get involved:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Implement your changes.
4. Submit a pull request (PR) and provide a detailed description of your changes.

Make sure your code follows best practices and includes tests where appropriate. All contributions will be reviewed before merging.

## License
This project is licensed under the **MIT License**. For more information, refer to the [LICENSE](LICENSE) file included in the repository.

## Contact
For any issues, questions, or feature requests, you can:

- Open an issue in the repository.
- Reach out to the project maintainers directly.


