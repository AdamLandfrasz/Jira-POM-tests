pipeline {
    agent any
    withCredentials([string(credentialsId: 'default_password', variable: 'pw')]) {
        environment {
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
