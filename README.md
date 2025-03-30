# Java Project

This is a basic Java project created with a standard Maven structure.

## Project Structure

```
src/
├── main/
│   └── java/
│       └── com/
│           └── example/
│               └── App.java
└── test/
    └── java/
```

## Requirements

- Java JDK 11 or higher
- Maven (for building the project)

## Building the Project

To build the project, run:

```bash
mvn clean install
```

## Running the Project

To run the project, use:

```bash
mvn exec:java -Dexec.mainClass="com.example.App"
```

## License

This project is open source and available under the MIT License.
