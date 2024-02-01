pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                script {
                    // Executa o Docker para construir o projeto usando a imagem Maven
                    docker.image('maven').inside {
                        sh 'mvn clean install'
                    }
                }
            }
        }
    }
}