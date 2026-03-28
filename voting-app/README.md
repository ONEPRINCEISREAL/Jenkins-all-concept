# 🚀 DevOps CI/CD Pipeline for Microservices Application

## 📌 Project Overview

This project demonstrates a complete **CI/CD pipeline implementation** for a microservices-based application using modern DevOps tools and practices.

The pipeline automates the entire workflow from **code integration → containerization → deployment**, simulating a real-world production environment.

---

## 🛠️ Tech Stack

* **CI/CD:** Jenkins (Pipeline as Code)
* **Containerization:** Docker
* **Cloud Platform:** AWS EC2
* **Version Control:** Git & GitHub
* **Database:** PostgreSQL
* **Message Broker:** Redis

---

## ⚙️ Key Features

* 🔄 Automated CI/CD pipeline using Jenkins
* 🐳 Multi-service Docker image build & push
* 📦 Version tagging for images (`v1`, `v2`, etc.)
* 🚀 Automated deployment on AWS EC2
* 🔁 Rollback support using version parameter
* 🔗 Service communication using Docker network
* 🧹 Clean container lifecycle management

---

## 🧱 Architecture

```
Developer → GitHub → Jenkins Pipeline → Docker Build → DockerHub → AWS EC2 Deployment
```

---

## 🔄 CI/CD Workflow

1. Code is pulled from GitHub
2. Jenkins pipeline triggers automatically
3. Docker images are built for:

   * Vote service (Python)
   * Result service (Node.js)
   * Worker service (.NET)
4. Images are pushed to DockerHub
5. Containers are deployed on EC2
6. Application becomes accessible via public IP

---

## 🌐 Application Access

* Voting App → `http://<EC2-PUBLIC-IP>:5000`
* Results App → `http://<EC2-PUBLIC-IP>:5001`

---

## 🧠 Key Learnings

* Implemented real-world CI/CD pipeline from scratch
* Understood Jenkins master-agent architecture
* Debugged Docker build and runtime issues
* Managed multi-container application deployment
* Learned importance of versioning and rollback

---

## 🚀 Future Improvements

* Implement Zero-Downtime Deployment
* Migrate deployment to Kubernetes
* Add Monitoring (Prometheus + Grafana)
* Integrate Security Scanning in pipeline

---

## 👨‍💻 Author

**Prince Singh Chauhan**
Aspiring DevOps Engineer | Cloud & Automation Enthusiast

---

## ⭐ Acknowledgment

This project is inspired by a microservices demo application and extended with a complete CI/CD pipeline and deployment automation.
