# Resume Parser Application

## Overview
The Resume Parser Application is a simple application designed to analyze resumes for HR purposes. It aims to help HR professionals by extracting and counting word occurrences in resumes. Looking to further improve this project using AI based API to further analyze resumes.

## Features
- Upload resume in PDF format
- Extract text from PDF resumes
- Count the occurrence of each word

## Technologies Used
- Java
- Spring Boot
- Maven

## Setup and Installation

1. Clone the repository:
    ```sh
    git clone <your-repository-URL>
    cd resume-parser
    ```

2. Build the project using Maven:
    ```sh
    mvn clean install
    ```

3. Run the Spring Boot application:
    ```sh
    mvn spring-boot:run
    ```

4. Use Postman or any other API client to test the application:
    - URL: `http://localhost:8080/api/resume/upload`
    - Method: `POST`
    - Body: form-data, key: `file`, value: (select your PDF file)

## Endpoints
- `POST /api/resume/upload`: Upload a resume PDF and get the word occurrence count.

