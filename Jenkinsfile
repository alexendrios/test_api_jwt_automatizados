pipeline {
    agent any

    tools {
        maven "Maven"
        jdk "jdk"
    }

    stages {
        stage('Initialize'){
            steps{
                echo "PATH = ${M2_HOME}/bin:${PATH}"
                echo "M2_HOME = /opt/maven"
            }
        }
        stage('Build') {
            steps {
                dir("/var/lib/jenkins/workspace/testes-automatizados-api-jwt/") {
                sh 'mvn -B -DskipTests clean package'
                }
            
            }
        }
     }
    post {
       always {
          junit(
        allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
      )
      }
   } 
}