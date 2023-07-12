# Phone Geo Lookup

Phone Geo Lookup is a web application that provides information about the country associated with a given phone number. It helps users identify the country of origin for a phone number, which can be useful in various scenarios such as verifying phone numbers, detecting potential fraud, or analyzing phone number data.

## Features

- **Country Lookup**: Enter a phone number and get instant information about the associated country.
- **Phone Number Validation**: Validate phone numbers to ensure they are in the correct format.

## Prerequisites

- [docker](https://www.docker.com/get-started)
- [docker-compose](https://docs.docker.com/compose/gettingstarted/)
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Apache Maven](https://maven.apache.org/download.cgi)

## Installation

To run the application locally using Docker Compose, follow these steps:

1. Clone the repository: `git clone https://github.com/ddulevich/phone-geo-lookup.git`
2. Navigate to the project directory: `cd phone-geo-lookup`
3. Build and start the Docker containers: `docker-compose up -d`
4. Access the application in your browser at: `http://localhost:3000`

## Running Maven Tests and Generating Reports

To run Maven tests for the application and generate reports, follow these steps:

1. Make sure you have Java and Maven installed on your machine.
2. Navigate to the project directory: `cd phone-geo-lookup` -> `cd phone-geo-lookup-service`
3. Run the Maven tests using the following command: `mvn surefire-report:report`
4. After the tests complete, the test reports will be generated in the `target/site` directory.
5. Open the test reports in a web browser to view the detailed test results.
