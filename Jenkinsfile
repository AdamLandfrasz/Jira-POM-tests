pipeline {
    agent any
    environment {
        withCredentials([secretText(credentialsId: 'PASSWORD', secretText: 'PASSWORD')]) {
            PASSWORD = credentials('$PASSWORD')
        }
    }
    stages {
        stage ('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
