pipeline {
    agent any

    tools {
        maven "Maven" // Use o nome configurado para a ferramenta Maven no Jenkins
        jdk "Java"   // Use o nome configurado para o JDK no Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                script {
                    def mvnHome = tool 'Maven'
                    env.PATH = "${mvnHome}/bin:${env.PATH}"
                    sh 'mvn clean install'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    def mvnHome = tool 'Maven'
                    env.PATH = "${mvnHome}/bin:${env.PATH}"
                    sh 'mvn test'
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
