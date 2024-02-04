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
                    docker.image('maven:latest').inside {
                        sh 'mvn -version'
                        sh 'mvn clean install'
                    }
                }
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    docker.image('maven:latest').inside {
                        sh 'mvn test'
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Exemplo: Inicie a aplicação Java por 3 segundos
                    docker.image('seu-imagem-java').inside {
                        echo "Aplicativo pronto para uso"
                    }
                }
            }
        }
    }
}
