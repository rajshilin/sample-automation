pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                url: 'https://github.com/rajshilin/sample-automation.git'
            }
        }

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
            emailext(
                subject: "✅ Build Success - ${env.JOB_NAME}",
                body: "Build Passed 🚀",
                to: "rajaccelya@gmail.com",
                attachmentsPattern: "**/test-output/*.html"
            )
        }

        failure {
            emailext(
                subject: "❌ Build Failed - ${env.JOB_NAME}",
                body: "Build Failed ❌",
                to: "rajaccelya@gmail.com"
            )
        }
    }
}