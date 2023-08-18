pipeline {
    agent any
    triggers {
        gitee (
            // 推送代码
            triggerOnPush: false,
            // 评论提交记录
            triggerOnCommitComment: false,
            // 新建 Pull Requests
            triggerOnOpenPullRequest: true,
            // 更新 Pull Requests "0":None "1":Source Branch updated "2":Target Branch updated "3":Both Source and Target Branch updated
            triggerOnUpdatePullRequest: "0",
            // 接受 Pull Requests
            triggerOnAcceptedPullRequest: true,
            // 关闭 Pull Requests
            triggerOnClosedPullRequest: true,
            // 审查通过 Pull Requests
            triggerOnApprovedPullRequest: true,
            // 测试通过 Pull Requests
            triggerOnTestedPullRequest: true,
            // 评论 Pull Requests
            triggerOnNoteRequest: true,
            // 评论内容的正则表达式
            noteRegex: "build",
            // 构建指令过滤 "NONE":无 "CI_SKIP":[ci-skip] 指令跳过构建 "CI_BUILD":[ci-build] 指令触发构建
            buildInstructionFilterType: "NONE",
            // PR 不要求必须测试时过滤构建
            ciSkipFroTestNotRequired: false,
            // 过滤已经构建的 Commit 版本
            skipLastCommitHasBeenBuild: false,
            // 取消相同 Pull Requests 未完成构建
            cancelIncompleteBuildOnSamePullRequest: false,
            // 允许触发构建的分支 "All":允许所有分支触发构建 "NameBasedFilter":根据分支名过滤 "RegexBasedFilter":根据正则表达式过滤分支
            branchFilterType: "All",
            // "NameBasedFilter" - 包括
            includeBranchesSpec: "include",
            // "NameBasedFilter" - 排除
            excludeBranchesSpec: "exclude",
            // "RegexBasedFilter" - 目标分支的正则表达式
            targetBranchRegex: "regex",
            // Gitee WebHook 密码
            secretToken: "123456"
        )
    }
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
        stage('把jar包构建为docker镜像并运行') {
            steps {
                script {
                    def username = "Jenkins"
                    echo "Hello Mr. ${username}"
                     echo "Running branch: ${env.BRANCH_NAME} , changeid: ${env.CHANGE_ID}"
                    echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
                    echo "Running ${env.BUILD_URL} on ${env.JAVA_HOME}"
                    echo "${currentBuild.projectName}运行成功"
                   }
            }
        }

    }
}