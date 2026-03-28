# Environment Variables in Jenkins (Rewritten Version)

Environment variables in Jenkins are simple key-value pairs used to store configuration data.
They help make pipelines more **dynamic, secure, and reusable** by removing hardcoded values such as credentials, file paths, or app names.

---

## What Do Environment Variables Mean?

Environment variables are values that Jenkins jobs or pipelines can access anytime during execution.
They allow pipelines to adjust behavior dynamically using details like:

* Build number
* Job name
* Git branch
* Docker credentials
* Deployment environment (DEV, QA, PROD)

Example:

```
echo "Current build number is: $BUILD_NUMBER"
```

Here, `$BUILD_NUMBER` is a default variable provided by Jenkins.

---

## Categories of Environment Variables in Jenkins

### 1. Default (Built-in) Variables

These variables are automatically available in every Jenkins job.

| Variable     | Example Value                         | Purpose                  |
| ------------ | ------------------------------------- | ------------------------ |
| BUILD_NUMBER | 25                                    | Unique ID for each build |
| JOB_NAME     | python-app-build                      | Name of the job          |
| WORKSPACE    | /var/lib/jenkins/workspace/python-app | Job workspace directory  |
| GIT_COMMIT   | ab12cd34                              | Git commit identifier    |

Usage:

```
echo "Build #$BUILD_NUMBER running inside $WORKSPACE"
```

---

### 2. Global Variables

Defined once and accessible across all Jenkins jobs.

**How to set them:**

* Go to **Manage Jenkins → Configure System**
* Enable **Global Properties**
* Add environment variables (e.g., `ENV_TYPE=QA`)

Usage:

```
echo "Deploying application to $ENV_TYPE"
```

---

### 3. Job-Level Variables

These variables are specific to a single Jenkins job.

**Steps:**

* Open job → Configure
* Enable **Inject environment variables**
* Add values (e.g., `APP_VERSION=1.0.0`)

Usage:

```
echo "Application version: $APP_VERSION"
```

---

### 4. Pipeline Variables

Declared inside a Jenkins pipeline (`Jenkinsfile`) using the `environment {}` block.

Example:

```
pipeline {
    agent any
    environment {
        APP_NAME = 'my-python-app'
        DEPLOY_ENV = 'DEV'
    }
    stages {
        stage('Build') {
            steps {
                echo "Building ${APP_NAME} for ${DEPLOY_ENV}"
            }
        }
    }
}
```

---

### 5. Credential-Based Variables

Used to safely handle sensitive data like usernames, passwords, and API tokens.
Jenkins stores them securely and injects them only when needed.

Example:

```
withCredentials([usernamePassword(credentialsId: 'Dockerhub-Cred', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
    sh '''
        echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
    '''
}
```

---

## Benefits of Using Environment Variables

* Prevents hardcoding sensitive information
* Makes pipelines reusable across environments
* Improves maintainability
* Simplifies configuration handling in CI/CD

---

## Best Practices

* Use clear names like `APP_VERSION`, `DEPLOY_ENV`
* Never store secrets in plain text—use Jenkins credentials
* Avoid printing sensitive values in logs
* Combine variables with parameters for flexibility

---

## Sample Jenkins Pipeline

```
pipeline {
    agent any
    environment {
        APP_NAME = 'python-app'
        ENV_TYPE = 'QA'
    }
    stages {
        stage('Build') {
            steps {
                echo "Building ${APP_NAME} for ${ENV_TYPE}"
            }
        }
    }
}
```

---

## Quick Recap

| Type        | Scope              | Example          |
| ----------- | ------------------ | ---------------- |
| Built-in    | Default in Jenkins | `$BUILD_NUMBER`  |
| Global      | All jobs           | `$ENV_TYPE`      |
| Job-level   | Single job         | `$APP_VERSION`   |
| Pipeline    | Jenkinsfile        | `${APP_NAME}`    |
| Credentials | Secure data        | `${DOCKER_USER}` |

---

## Final Thoughts

Environment variables form the foundation of flexible Jenkins pipelines.
They enable you to create **scalable, secure, and reusable CI/CD workflows** for applications like Python apps, Docker deployments, and cloud systems.




