# Python CI/CD Pipeline using Jenkins Agent and Docker

This repository demonstrates a complete CI/CD workflow for a Python application using Jenkins and Docker.
The pipeline executes on a configured Jenkins worker node through SSH authentication and performs build, test, containerization, and image deployment to Docker Hub.

---

## Project Overview

The Jenkins pipeline automates the following:

* Cloning the source code from GitHub
* Compiling the Python application
* Running unit tests
* Building a Docker image
* Running the container locally on the agent
* Tagging and pushing the Docker image to Docker Hub

The pipeline runs on a labeled Jenkins agent: **`worker-node`**

---

## Common Issues Faced During Docker Stage

While running the pipeline on the worker node, two typical problems may occur:

### 1. Docker Legacy Builder Warning

```
DEPRECATED: The legacy builder is deprecated and will be removed in future versions.
```

This means Docker BuildKit / Buildx should be used for modern image builds.

### 2. Docker Socket Permission Error

```
permission denied while trying to connect to the Docker daemon socket
```

This happens because the Jenkins user does not have permission to access Docker.

---

## Fix 1: Install Docker Buildx on Jenkins Agent

Run the following commands on the worker node:

```bash
mkdir -p ~/.docker/cli-plugins
curl -SL https://github.com/docker/buildx/releases/download/v0.17.1/buildx-v0.17.1.linux-amd64 -o ~/.docker/cli-plugins/docker-buildx
chmod +x ~/.docker/cli-plugins/docker-buildx
```

Verify installation:

```bash
docker buildx version
```

---

## Fix 2: Grant Docker Permission to Jenkins User

Add the Jenkins execution user (for example `ubuntu` or `jenkins`) to the docker group:

```bash
sudo usermod -aG docker <user>
```

Apply the changes:

```bash
sudo reboot
```

---

## Pipeline Workflow

The Jenkins pipeline defined in the `Jenkinsfile` includes these stages:

1. **Clone Repository**
   Clones the `main` branch from:
   `https://github.com/ONEPRINCEISREAL/Jenkins-all-concept.git`

2. **Build Stage**
   Compiles `app.py` inside the directory:
   `python-jenkins-docker-app`

3. **Test Stage**
   Executes unit tests located in the `tests` folder.

4. **Docker Build Stage**
   Builds a Docker image named:

```
python-app:latest
```

5. **Docker Run Stage**
   Runs the built container on the Jenkins agent.

6. **Docker Tag and Push Stage**
   Logs into Docker Hub using Jenkins credentials (`kappapvt`), then pushes the image:

```
kappapvt/python-app:latest
```

---

## Prerequisites

* Jenkins controller with SSH configured agent
* Worker node labeled `worker-node`
* Docker installed on the agent
* Java installed on the agent (required for Jenkins remoting)
* Jenkins credentials configured for Docker Hub login
* Repository contains:

```
Jenkinsfile
Dockerfile
app.py
tests/
python-jenkins-docker-app/
```

---

## Running the Pipeline

1. Ensure the Jenkins agent is connected and online.
2. Trigger the pipeline job from Jenkins dashboard.
3. Verify that the Docker image is created:

```bash
docker images | grep python-app
```

4. Confirm the image is available on Docker Hub.

---

## Troubleshooting

### Buildx Not Working

* Ensure `curl` is installed:

```bash
sudo apt install curl
```

* Re-download the plugin if the version mismatch occurs.

### Docker Permission Still Denied

Check group membership:

```bash
groups <user>
```

If docker group is missing, re-run the `usermod` command and reboot.

### Workspace Permission Issue

If Jenkins cannot access files:

```bash
sudo chown -R <user>:<user> /home/ubuntu/workspace
sudo chmod -R u+rw /home/ubuntu/workspace
```

---

## References

* Docker Buildx Official Documentation
* Docker Post Installation Steps for Linux
* Jenkins Distributed Builds Documentation

