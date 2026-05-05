pipeline {
    agent any

    stages {

        stage('Build & Test') {
            steps {
                bat '"C:\\Program Files\\Maven\\apache-maven-3.9.15\\bin\\mvn.cmd" clean test'
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: '**/test-output/*', allowEmptyArchive: true
            }
        }
    }

    post {
        success {
            echo 'Build Success ✅'
        }
        failure {
            echo 'Build Failed ❌'
        }
    }
}