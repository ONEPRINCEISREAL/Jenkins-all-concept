# Python CI/CD Pipeline with Jenkins and Docker

This repository includes a **basic Python application** created to demonstrate a full **CI/CD pipeline implementation** using **Jenkins**, **Docker**, and **Docker Compose**.

---

## 📖 Project Overview

This project is perfect for beginners who want practical exposure to:

* Building a simple Python application
* Validating code using Python testing tools
* Creating Docker containers for application deployment
* Managing multi-container execution using Docker Compose
* Automating build and deployment by pushing Docker images to Docker Hub through Jenkins

The application itself is a lightweight **“Hello World” program**, along with unit tests implemented using Python’s built-in `unittest` module.

---

## 📂 Directory Structure

```
python-jenkins-docker/
│── app.py                  # Core Python application
│── tests/
│   └── test_app.py         # Unit test cases
│── requirements.txt        # Dependency list
│── Dockerfile              # Container build instructions
│── docker-compose.yml      # Service orchestration config
│── Jenkinsfile             # CI/CD pipeline definition
│── README.md               # Documentation
```

---

## ⚙️ Application Build, Test & Execution

### **1️⃣ Build Phase (Syntax Validation)**

Since Python is interpreted, compilation is not mandatory.
However, syntax verification and bytecode generation can be performed using:

```bash
python3 -m py_compile app.py
```

---

### **2️⃣ Testing Phase**

Run automated unit tests to confirm expected functionality:

```bash
python3 -m unittest discover tests
```

---

### **3️⃣ Local Execution**

Execute the program directly on your local system:

```bash
python3 app.py
```

**Expected Output:**

```
Hello from Python Application for Jenkins CI/CD!
```

---

## 🐳 Running the Application using Docker

### **1️⃣ Build the Docker Image**

```bash
docker build -t python-jenkins-docker:latest .
```

### **2️⃣ Start the Container**

```bash
docker run --rm python-jenkins-docker:latest
```

**Expected Output:**

```
Hello from Python Application for Jenkins CI/CD!
```

---

## ⚙ Running with Docker Compose

### **1️⃣ Build and launch services**

```bash
docker-compose up --build
```

### **2️⃣ Stop running services**

```bash
docker-compose down
```

---

## 🔄 CI/CD Automation using Jenkins

The included `Jenkinsfile` automates the entire pipeline workflow with the following stages:

1. **Build Stage** – Performs syntax validation through Python bytecode compilation
2. **Test Stage** – Executes unit tests using the `unittest` framework
3. **Docker Build Stage** – Creates a Docker image from the project source
4. **Docker Push Stage** – Uploads the generated image to Docker Hub

Additionally, the pipeline runs the container to verify successful deployment.

**Important:**
You must configure Jenkins credentials with the ID `dockerhub-creds`, which should contain your Docker Hub username and password.

---

## 🛠 Requirements

Ensure the following tools are installed before running the project:

* Python 3.11 or higher
* Docker
* Docker Compose
* Jenkins (required only for CI/CD pipeline execution)

---

## 📜 License

This project is distributed under the **MIT License**.


