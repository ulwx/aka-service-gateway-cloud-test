pipeline {
    agent any
    //这里导入maven，名字就是在全局工具配置中配置的，如下所示
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
               //先运行一下maven版本，看看maven是否配置好了， sh 是指执行shell脚本
                sh "mvn --version"
               // 如果maven可以运行，那么执行以下代码，这里需要注意一下，pom.xml文件是否在你创建的任务目录下
                sh "mvn clean package"
                echo '构建完成'
            }
        }
        stage('把jar包构建为docker镜像并运行') {
            steps {
                script {
                    def username = "Jenkins"
                    echo "Hello Mr. ${username}"
                    echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
                    echo "Running ${env.BUILD_URL} on ${env.JAVA_HOME}"
                    echo "${currentBuild.projectName}运行成功"
                   }
            }
        }
    }
}