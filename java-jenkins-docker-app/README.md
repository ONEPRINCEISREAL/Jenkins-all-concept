# ☕ Java Jenkins Docker CI/CD Pipeline

This project demonstrates a **complete CI/CD workflow** for a minimal Java application using **Maven, Jenkins, Docker, and Docker Compose**.

It is designed for beginners and DevOps learners to understand how an application moves from **source code → build → test → containerization → execution** in an automated pipeline.

---

## 📖 Overview

This repository helps you learn:

* Building a simple Java application
* Compiling and testing using **Maven**
* Containerizing the application using **Docker**
* Running services using **Docker Compose**
* Automating the workflow using a **Jenkins Declarative Pipeline**

The application is a simple **Hello World Java program** with a basic **JUnit test case**.

---

## 📂 Project Structure

```
java-jenkins-docker/
│── src/
│   ├── main/java/com/example/App.java
│   └── test/java/com/example/AppTest.java
│── pom.xml
│── Dockerfile
│── docker-compose.yml
│── Jenkinsfile
│── README.md
```

---

## ⚙️ Maven Build Lifecycle

### 🔹 Build & Package

```bash
mvn clean package
```

* Removes previous build artifacts
* Compiles source code
* Runs tests
* Generates executable JAR

**Output File:**

```
target/java-jenkins-docker-1.0-SNAPSHOT.jar
```

---

### 🔹 Run Tests

```bash
mvn test
```

Runs all **JUnit test cases** inside:

```
src/test/java
```

---

### 🔹 Compile Source Code

```bash
mvn compile
```

Compiles `.java` files into `.class` files inside:

```
target/classes
```

---

## 🚀 Running Application Locally

After building the project:

```bash
java -jar target/java-jenkins-docker-1.0-SNAPSHOT.jar
```

### ✅ Expected Output

```
Hello from Java Application for Jenkins CI/CD!
```

---

## 🐳 Docker Workflow

### 🔹 Build Docker Image

```bash
docker build -t java-jenkins-docker:latest .
```

### 🔹 Run Docker Container

```bash
docker run --rm java-jenkins-docker:latest
```

---

## ⚙️ Docker Compose Execution

### 🔹 Start Services

```bash
docker-compose up --build
```

### 🔹 Stop Services

```bash
docker-compose down
```

---

## 🔄 Jenkins Pipeline Automation

The `Jenkinsfile` automates the CI/CD workflow:

```groovy
pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t java-jenkins-docker:latest .'
            }
        }

        stage('Docker Run') {
            steps {
                sh 'docker run --rm java-jenkins-docker:latest'
            }
        }
    }
}
```

### ✅ Pipeline Stages

1. **Build** → Compile and package Java application
2. **Test** → Execute JUnit tests
3. **Docker Build** → Create container image
4. **Docker Run** → Execute containerized application

---

## 🛠 Prerequisites

Make sure the following tools are installed:


* - [Java 17+](https://adoptium.net/)
* - [Apache Maven](https://maven.apache.org/)
* - [Docker](https://hub.docker.com/)
* - [Docker Compose](https://docs.docker.com/compose/)
* - [Jenkins](https://www.jenkins.io/) (optional for CI/CD testing)

---

## 🌟 Future Improvements

* Push Docker image to Docker Hub
* Add multi-stage Docker build for optimization
* Integrate pipeline notifications (Slack / Email)
* Deploy container to AWS EC2 / Kubernetes
* Add SonarQube code quality analysis

---

## 📜 License

This project is licensed under the **MIT License**.

