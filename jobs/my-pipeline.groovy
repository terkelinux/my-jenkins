pipeline {
    agent any // Run on any available agent
    stages {
        stage('Clone') {
            steps {
                deleteDir()
                sh 'git clone https://github.com/terkelinux/my-jenkins.git' // Replace with your repository URL
                sh 'pwd'
            }
        }

        stage('Build') {
            steps {
                sh 'echo javac' 
            }
        }

        stage('Parallel Tests') {
            parallel {
                stage('Unit test') {
                    steps {
                        sh 'echo “unit test”'
                    }
                }
                stage('ntegration test') {
                    steps {
                        sh 'echo “unit test”' 
                    }
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline completed.'
        }
        success {
            echo 'Pipeline completed success.'
        }
        failure {
            mail bcc: '', body: 'my pipe done fail', cc: '', from: '', replyTo: '', subject: 'my pipe', to: 'terkmail@gmail.com'
        }
    }
}