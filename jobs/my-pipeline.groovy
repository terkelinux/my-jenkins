pipeline {
    agent any // Run on any available agent
    stages {
        stage('Info') {
            steps {
                sh 'pwd'
                sh 'whoami'
                sh 'hostname'
                sh 'uptime'
            }
        }

        stage('Build') {
            steps {
                sh 'echo building...' 
            }
        }

        stage('Parallel Tests') {
            parallel {
                stage('Unit test') {
                    steps {
                        sh 'echo “unit test”'
                    }
                }
                stage('Integration test') {
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