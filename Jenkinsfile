pipeline {
    agent any
    environment {
        test = 'test'
    }
    stages {
        stage ('Test') {
            steps {
                echo "${test}"
                sh "mvn test"
            }
        }
    }
}
