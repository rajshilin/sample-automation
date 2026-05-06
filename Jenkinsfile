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
                archiveArtifacts artifacts: '**/test-output/**/*', allowEmptyArchive: true
            }
        }
    }

    post {
        always {
            emailext(
                to: 'rajaccelya@gmail.com''rajendrashilin@gmail.com',
                subject: "Build ${currentBuild.currentResult}: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
                <h3>Build Status: ${currentBuild.currentResult}</h3>

                <p><b>Job:</b> ${env.JOB_NAME}</p>
                <p><b>Build Number:</b> ${env.BUILD_NUMBER}</p>
                <p><b>Build URL:</b> <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>

                <p><b>Extent Report:</b><br>
                <a href="${env.BUILD_URL}artifact/test-output/ExtentReport.html">
                Click to view report
                </a></p>

                <p>Regards,<br>Jenkins CI</p>
                """,
                mimeType: 'text/html',
                attachLog: true
            )
        }
    }
}