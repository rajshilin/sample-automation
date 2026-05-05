pipeline {
    agent any

    stages {

        stage('Clean') {
            steps {
                deleteDir()
            }
        }

        stage('Build & Test') {
            steps {
                bat '"C:\\Program Files\\Maven\\apache-maven-3.9.15\\bin\\mvn.cmd" clean test'
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: '**/test-output/**/*', allowEmptyArchive: true
            }
        }
    }

    post {
        success {
            emailext(
                subject: "Build Success ✅",
                body: "Automation Passed",
                to: "rajendrashilin@gmail.com",
                attachmentsPattern: 'test-output/ExtentReport.html'
            )
        }
        failure {
            emailext(
                subject: "Build Failed ❌",
                body: "Automation Failed",
                to: "rajendrashilin@gmail.com",
                attachmentsPattern: 'test-output/ExtentReport.html'
            )
        }
    }
}