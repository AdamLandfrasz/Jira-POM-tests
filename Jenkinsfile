withCredentials([string(credentialsId: 'default_password', variable: 'pw')]) {
    pipeline {
        agent any
        environment {
            password = ${pw}
            test = 'test'
        }
        stages {
            stage ('Test') {
                steps {
                    echo ${test}
                    sh "mvn test"
                }
            }
        }
    }
}
