# Declarative Pipeline

This project demonstrates how to create and execute **Jenkins Declarative Pipelines** using a structured and simplified syntax. Declarative Pipelines are designed to make CI/CD pipeline definitions more readable, maintainable, and easier to implement compared to Scripted Pipelines.

The pipeline automates the **Build → Test → Deploy** workflow of an application.

---

## `Jenkinsfile`

This file contains a basic example of a Jenkins Declarative Pipeline.

```groovy
pipeline {
    agent any

    stages {
        stage("Build") {
            steps {
                echo "Building project..."
                sh 'mkdir -p build && echo "Build successful" > build/output.txt'
            }
        }

        stage("Test") {
            steps {
                echo "Running tests..."
                sh 'cat build/output.txt'
            }
        }

        stage("Deploy") {
            steps {
                echo "Deploying application..."
                sh 'echo "Application deployed successfully"'
            }
        }
    }
}
```

---

## Key Concepts

### **`pipeline` Block**

This is the main block that defines the entire pipeline structure. All stages, agents, and steps are written inside this block.

### **`agent` Directive**

Defines where the pipeline or stage will run.
`agent any` allows Jenkins to execute the pipeline on any available agent.

### **`stages` Block**

This block contains multiple stages that represent the CI/CD workflow phases such as Build, Test, and Deploy.

### **`stage` Block**

Each stage defines a logical unit of work in the pipeline. Stage names are displayed in the Jenkins UI pipeline visualization.

### **`steps` Block**

Contains the actual commands or actions executed during a stage.

Common steps include:

* `sh` → Execute shell commands on Linux agents
* `echo` → Print logs in Jenkins console output
* Jenkins plugins steps → Docker, Git, AWS, etc.

---

## Project Workflow

1. Jenkins fetches the project source code from the Git repository.
2. Pipeline execution starts on an available Jenkins agent.
3. Build stage prepares application artifacts.
4. Test stage validates the build output.
5. Deploy stage simulates deployment.

---

## Prerequisites

* Jenkins installed and configured
* Pipeline plugin enabled
* GitHub repository integrated with Jenkins
* Linux-based Jenkins agent
* Basic understanding of CI/CD concepts

---

## How to Run

1. Create a **New Pipeline Job** in Jenkins.
2. Configure **Pipeline script from SCM**.
3. Select Git and provide repository URL.
4. Ensure the `Jenkinsfile` exists in the root directory.
5. Click **Build Now** to trigger the pipeline.

---

## Future Enhancements

* Add parallel stages for faster pipeline execution
* Integrate Docker image build and push
* Deploy application to AWS EC2 / Kubernetes
* Add test reporting and pipeline notifications
* Add environment-based deployments (Dev / Stage / Prod)

