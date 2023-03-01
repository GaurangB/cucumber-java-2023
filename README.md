# cucumber-java-2023

This is a Java-based test automation framework designed for testing a web application. It uses Cucumber for test scenarios, Selenium WebDriver for interacting with the web application, and TestNG for test management and reporting.

## Requirements
- Java 8 or later
- Maven 3.5 or later
- ChromeDriver (or any other WebDriver executable) compatible with your Chrome browser version
## Usage
### Running tests
To run the tests, use the following command:
`mvn clean test`

This will run all the test scenarios defined in the `src/test/resources` directory.

You can also run specific test scenarios by using tags. For example, to run only the scenarios tagged with `@login`, use the following command:
`mvn clean test -Dcucumber.filter.tags="@login"`

### Test data
The test data is defined in a JSON file located in `src/test/resources/data/users.json`. You can add or modify the users as needed.

### Test configuration
The test configuration is defined in the `src/test/resources/config.properties` file. You can modify the URL of the web application, the WebDriver executable path, and other properties as needed.

### Hooks
The framework uses hooks defined in `src/test/java/Steps/Hooks/Hooks.java` to perform setup and cleanup tasks. The `@Before` hook is used to log the start of each scenario tagged with `@ui`, while the `@After` hook is used to take a screenshot and attach it to the test report if the scenario fails.

## Folder structure
```mermaid
src/
├── main/
│   └── java/
│       └── Pages/
│           ├── BasePage.java
│           ├── HomePage.java
│           └── LoginPage.java
│       └── util/
│           └── WebDriverFactory.java
│   └── resources/
│       └── config.properties
├── test/
│   └── java/
│       └── Steps/
│           ├── LoginSteps.java
│           └── Hooks/
│               └── Hooks.java
│       └── TestRunner.java
│   └── resources/
│       ├── data/
│       │   └── users.json
│       ├── features/
│       │   └── Login.feature
│       └── screenshots/
└── pom.xml
```
`Pages`: Contains page objects used by the test scenarios.

`util`: Contains a factory class for creating WebDriver instances.

`Steps`: Contains step definitions used by the test scenarios.

`Hooks`: Contains hooks used for setup and cleanup tasks.

`TestRunner.java`: Defines the Cucumber test runner class.

`data`: Contains test data in JSON format.

`features`: Contains Cucumber feature files.

`screenshots`: Contains screenshots taken on test failure.

`pom.xml`: Contains Maven dependencies and configuration.

### Author
This automation test framework was created by @GaurangB.