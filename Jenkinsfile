pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[url: 'https://github.com/alexendrios/test_api_jwt_automatizados.git']]])
            }
        }

        stage('Build and Run Container - App') {
            steps {
                script {
                    // Build your Docker image if needed
                    docker.build('config_api_api-jwt-app')

                    // Run the Docker container
                    docker.image('config_api_api-jwt-app').withRun('-p 4000:4000') { c ->
                        // Additional commands to execute inside the running container
                        sh 'npm install'
                        sh 'npm start'
                    }
                }
            }
        }

        stage('Build') {
            steps {
                script {
                    docker.image('maven:3.8.3-openjdk-11').inside {
                        sh 'mvn -version'
                        sh 'javac --version'
                    }
                }
            }
        }

        stage('Check Docker Image') {
            steps {
                script {
                    def ipAddress = 'localhost'
                    def port = 4000
                    
                    docker.image('maven:3.8.3-openjdk-11').inside {
                        // Install the netcat package
                        sh 'apt-get update && apt-get install -y netcat'

                        // Check connectivity to a specific port
                        sh "nc -zv ${ipAddress} ${port}"
                    }
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    docker.image('maven:3.8.3-openjdk-11').inside {
                        // Print available commands in the Docker image
                        sh 'ls -l /usr/bin'
                        
                        // Add more debugging information
                        sh 'mvn clean test -X'
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                echo "Application ready for use"
            }
        }
    }
}
