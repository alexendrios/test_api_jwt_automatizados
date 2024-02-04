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
                    docker.image('maven:3.8.3-openjdk-11').inside("--network=skynet") {
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
                    
                    docker.image('maven:3.8.3-openjdk-11').inside("--network=skynet") {
                        sh 'apt-get update && apt-get install -y netcat'
                        sh "nc -zv ${ipAddress} ${port}"
                    }
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    docker.image('maven:3.8.3-openjdk-11').inside("--network=skynet") {
                        sh 'ls -l /usr/bin'
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
