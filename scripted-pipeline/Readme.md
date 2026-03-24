# Scripted Pipeline

This project demonstrates how to create and execute **Jenkins Scripted Pipelines** using Groovy scripting. Scripted Pipelines provide flexibility and full control over pipeline execution, allowing developers and DevOps engineers to implement complex CI/CD workflows.

The pipeline defined in this project automates the **build, test, and deployment process** of an application using Jenkins.

---

## `Jenkinsfile`

This file contains a basic example of a Jenkins Scripted Pipeline.

```groovy
node {
    stage('Build') {
        echo "Building project..."
        sh 'mkdir -p build && echo "Build successful" > build/output.txt'
    }

    stage('Test') {
        echo "Running tests..."
        sh 'cat build/output.txt'
    }

    stage('Deploy') {
        echo "Deploying application..."
        sh 'echo "Application deployed successfully"'
    }
}
```

---

## Key Concepts

### **`node` Block**

The `node` block is the core execution unit in a Scripted Pipeline.
It allocates an executor on a Jenkins agent and runs all enclosed steps inside the agent’s workspace.

### **`stage` Block**

Stages help organize the pipeline into logical phases such as Build, Test, and Deploy.
Using stages improves pipeline readability and provides better visualization in the Jenkins UI.

### **Pipeline Steps**

Steps are the actual commands executed inside stages.
Common examples include:

* `sh` → Executes shell commands (Linux agents)
* `echo` → Prints messages in Jenkins console logs
* Groovy scripting → Enables conditional logic and loops

---

## Project Workflow

1. Jenkins pulls the project from the Git repository.
2. Pipeline execution starts inside a Jenkins agent.
3. Build stage prepares application artifacts.
4. Test stage validates the build output.
5. Deploy stage simulates application deployment.

---

## Prerequisites

* Jenkins installed and configured
* Git repository configured in Jenkins job
* Jenkins agent with Linux shell access
* Basic knowledge of Groovy scripting

---

## How to Run

1. Create a new **Pipeline Job** in Jenkins.
2. Connect your GitHub repository.
3. Ensure the `Jenkinsfile` is present in the root directory.
4. Click **Build Now** to trigger the pipeline.

---

## Future Improvements

* Add parallel stages for faster execution
* Integrate Docker build and push
* Deploy to AWS EC2 / Kubernetes
* Add automated test reports

