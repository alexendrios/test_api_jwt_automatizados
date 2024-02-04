pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[url: 'https://github.com/alexendrios/test_api_jwt_automatizados.git']]])
            }
        }

        stage('Build') {
            steps {
                script {
                    docker.image('maven:3.8.3').inside {
                        sh 'mvn -version'
                        sh 'mvn clean install'
                    }
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    docker.image('maven:3.8.3').inside {
                        sh 'mvn test'
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Example: Start the Java application for 3 seconds
                    docker.image('your-java-image').inside {
                        echo "Application ready for use"
                    }
                }
            }
        }
    }
}
