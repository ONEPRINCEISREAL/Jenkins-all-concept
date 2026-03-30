def call(Map config = [:]) {

    def name = config.get("name", "User")
    def envName = config.get("env", "dev")
    def logLevel = config.get("logLevel", "INFO")

    log("Starting execution for ${name} in ${envName}", logLevel)

    echo "👋 Hello ${name}!"
    echo "🌍 Environment: ${envName}"

    log("Execution completed successfully", logLevel)
}

// reusable logging function
def log(String message, String level = "INFO") {
    echo "[${level}] ${message}"
}