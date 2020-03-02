pipeline {
    agent any
    environment {
        withCredentials([string(credentialsId: 'default_password', variable: 'pw')]) {
            password = "${pw}"
        }
    }
    stages {
        stage ('Test') {
            steps {
                sh "mvn test"
            }
        }
    }
}
