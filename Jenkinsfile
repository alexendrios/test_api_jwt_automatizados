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
                    docker.image('maven:3.8.3-openjdk-11').inside {
                        sh 'mvn -version'
                        sh 'javac --version'
                    }
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    docker.image('maven:3.8.3').inside {
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
