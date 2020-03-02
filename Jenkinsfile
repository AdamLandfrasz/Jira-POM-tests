pipeline {
    agent any
    environment {
        password = credentials('default_password')
    }
    stages {
        stage ('Test') {
            steps {
                sh "mvn test"
            }
        }
    }
}
