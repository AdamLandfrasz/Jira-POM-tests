pipeline {
    agent any
    environment {
        test = "XDD"
    }
    stages {
        stage ('Test') {
            steps {
                sh echo "${test}"
                sh set +x
                sh 'mvn -Ddefault_pw=${password} test -DforkMode=never'
            }
        }
    }
}
