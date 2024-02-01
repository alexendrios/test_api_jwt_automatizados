pipeline {
    agent any

    tools {
        // Especificando o JDK embutido no Jenkins
        jdk 'jdk8'
        // Configurando o Maven
        maven 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                script {
                    // Configurando o Maven
                    def mvnHome = tool 'Maven'
                    env.PATH = "${mvnHome}/bin:${env.PATH}"

                    // Compilando e testando o projeto Maven
                    sh 'mvn clean install'
                }
            }
        }

        // Adicione mais estágios conforme necessário
    }

    post {
        always {
            // Limpeza ou ações pós-build
            cleanWs()
        }
    }
}
