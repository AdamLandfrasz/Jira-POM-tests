pipeline {
    agent any
    stages {
        stage ('Test') {
            steps {
                withCredentials([string(credentialsId: 'PASSWORD', variable: 'PASSWORD')]) {
                    sh 'mvn test'
                }
            }
        }
    }
}
