# Jenkins Agent Configuration using SSH Authentication

This guide explains how to set up a Jenkins worker node (agent) and securely connect it to the Jenkins controller using SSH key-based authentication.

## Requirements

* A running Jenkins controller with SSH enabled
* A Linux based agent machine (for example an Ubuntu EC2 instance)
* Proper network access between controller and agent

---

## Configuration Steps

### Step 1: Create SSH Key Pair on Jenkins Controller

Navigate to the SSH directory and generate a new key pair:

```bash
cd ~/.ssh
ssh-keygen -t ed25519
```

This command will create:

* `id_ed25519` → private key (must remain confidential)
* `id_ed25519.pub` → public key (to be copied to the agent)

To display the keys:

```bash
cat ~/.ssh/id_ed25519
cat ~/.ssh/id_ed25519.pub
```

---

### Step 2: Add and Configure Agent from Jenkins Dashboard

1. Open **Manage Jenkins** → **Nodes & Clouds** → **New Node**
2. Provide the following details:

* **Node Name:** worker-node
* **Remote Root Directory:** `/home/ubuntu`
* **Labels:** worker-node
* **Launch Method:** Launch agent via SSH
* **Host Address:** Public IP of the agent machine
* **Credentials:** Add new credential → SSH username with private key → paste the private key content

3. Save the configuration and start the agent connection.

---

### Step 3: Prepare the Agent Machine

1. Connect to the agent server.

2. Open the SSH authorized keys file:

```bash
vim ~/.ssh/authorized_keys
```

Paste the public key generated on the Jenkins controller.

3. Apply proper permissions:

```bash
chmod 700 ~/.ssh
chmod 600 ~/.ssh/authorized_keys
```

4. Install Java since Jenkins agents require it for communication:

```bash
sudo apt update
sudo apt install -y openjdk-17-jdk
```

---

### Step 4: Validate Agent Connectivity

Execute the Jenkins pipeline available in this repository.
If the build runs successfully on the labeled node, the SSH agent setup is working correctly.

---

## Key Points

* SSH key pair is generated on the Jenkins controller
* Public key is added to the agent’s `authorized_keys` file
* Jenkins node is configured to authenticate using the private key
* Java is installed on the agent to support Jenkins remoting
* Pipeline execution confirms successful agent communication

