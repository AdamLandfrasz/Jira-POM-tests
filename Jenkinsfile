pipeline {
    agent any
    environment {
        withCredentials([string(credentialsId: 'JIRA_PW', variable: 'default_password')]) {
            password = "${default_password}"
        }
    }
    stages {
        stage ('Test') {
            steps {
                sh set +x
                sh 'mvn -Ddefault_pw=${password} test -DforkMode=never'
            }
        }
    }
}
