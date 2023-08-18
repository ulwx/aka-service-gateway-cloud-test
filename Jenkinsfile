pipeline {
    agent any
    tools{
        maven 'maven_3.9.4'
    }
    stages {
       stage('拉取代码') {
            steps {
                git credentialsId: '3e1da5ee-aa23-4868-b11d-055fcce956a6', url: 'https://gitee.com/aka-soft/aka-service-gateway-cloud-test.git'
                echo '拉取成功'
            }
        }
        stage('执行构建') {
            steps {
                sh "mvn --version"

                sh "mvn clean package"
                echo '构建完成'
            }
        }

    }
}