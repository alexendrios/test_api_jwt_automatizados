pipeline {
    agent any

    stages {
        stage('Create Docker Network') {
            steps {
                script {
                    // Cria a rede Docker se ela não existir
                    sh 'docker network ls | grep -q backend-api-jwt_apijwt-network'
                }
            }
        }

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
                    def ipAddress = 'localhost'
                    def port = 4000

                    docker.image('maven:3.8.3-openjdk-11').inside("--network=backend-api-jwt_apijwt-network") {
                        // Instala o pacote netcat
                        sh 'apt-get update && apt-get install -y netcat'

                        // Verifica a conectividade para uma porta específica
                        sh "nc -zv ${ipAddress} ${port}"
                    }
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    docker.image('maven:3.8.3-openjdk-11').inside("--network=backend-api-jwt_apijwt-network") {
                        // Imprime os comandos disponíveis na imagem Docker
                        sh 'ls -l /usr/bin'

                        // Adiciona mais informações de depuração
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
