pipeline {
    agent any
    stages {
        stage ('Test') {
            steps {
                withCredentials([string(credentialsId: 'JIRA_PW', variable: 'default_password')]) {
                    sh set +x
                    sh 'mvn -Ddefault_pw=${default_password} test -DforkMode=never'
                }
            }
        }
    }
}
