pipeline {
    agent any
    environment {
        withCredentials([string(credentialsId: 'JIRA_PW', variable: 'default_password')]) {
            DEFAULT_PW = "${default_password}"
        }
    }
    stages {
        stage ('Test') {
            steps {
                set +x
                sh 'mvn -Ddefault_pw=${DEFAULT_PW} test -DforkMode=never'
            }
        }
    }
}
