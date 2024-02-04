pipeline {
    agent any

    stages {
        stage('Create Docker Network') {
            steps {
                script {
                    // Cria a rede Docker se ela não existir
                    sh 'docker network ls | grep -q apijwt-network || docker network create apijwt-network'
                }
            }
   }

    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], userRemoteConfigs: [[url: 'https://github.com/alexendrios/test_api_jwt_automatizados.git']]])
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
                    def ipAddress = '0.0.0.0'
                    def port = 4000
                    
                    docker.image('maven:3.8.3-openjdk-11').inside {
                        sh 'apt-get update && apt-get install -y netcat'
                        sh "nc -zv ${ipAddress} ${port}"
                    }
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    docker.image('maven:3.8.3-openjdk-11') {
                        sh 'mvn clean test'
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
