pipeline {
    agent any
    environment {
        PASSWORD = credentials('PASSWORD')
    }
    stages {
        stage ('Test') {
            steps {
                sh "mvn test"
            }
        }
    }
}
