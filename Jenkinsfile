@Library('forge-shared-library') _

pipeline {
    agent {
        docker { image 'openjdk:8-jdk' }
    }
    environment {
        DISCORD_PREFIX = "Magma: ${BRANCH_NAME} #${BUILD_NUMBER}"
        CHANGES = getChanges(currentBuild)
        ARTIFACT = " https://ci.hexeption.dev/job/Magma%20Foundation/job/Magma/job/${BRANCH_NAME}/${currentBuild.id}/artifact/projects/build/distributions/Magma-${GIT_COMMIT[0..6]}-server.jar"
    }
    stages {
        stage('Setup') {
            steps {
                withCredentials([string(credentialsId: 'DISCORD_WEBHOOK', variable: 'discordWebhook')]) {
                    discordSend(
                            title: "${DISCORD_PREFIX} Started",
                            successful: true,
                            link: env.BUILD_URL,
                            result: 'ABORTED', //White border
                            thumbnail: "https://i.imgur.com/NqnOifl.png",
                            webhookURL: "${discordWebhook}"
                    )
                }
                sh 'git submodule update --init --recursive'
                sh 'chmod +x gradlew'
            }
        }

        stage('Build') {
            steps {
                sh './gradlew launch4j --console=plain'
            }
        }

        //stage('Release') {
        //    when {
        //        not {
        //            changeRequest()
        //        }
        //    }
        //    steps {
        //        withCredentials([string(credentialsId: 'GITHUB_TOKEN', variable: 'GITHUB_TOKEN')]) {
        //            sh 'chmod +x gradlew && ./gradlew githubRelease --console=plain'
        //        }
        //    }
        //}
    }
    post {
        always {
            script {
                archiveArtifacts artifacts: 'build/distributions/*server.*', fingerprint: true, onlyIfSuccessful: true, allowEmptyArchive: true
                withCredentials([string(credentialsId: 'DISCORD_WEBHOOK', variable: 'discordWebhook')]) {
                    discordSend(
                           title: "Finished ${DISCORD_PREFIX} ${currentBuild.currentResult}",
                           description: "**Build:** [${currentBuild.id}](${env.BUILD_URL})\n**Status:** [${currentBuild.currentResult}](${env.BUILD_URL})\n\n**Changes:**\n```$CHANGES```\n**Artifacts:**\n - $ARTIFACT",
                            successful: currentBuild.resultIsBetterOrEqualTo("SUCCESS"),
                            result: currentBuild.currentResult,
                           link: env.BUILD_URL,
                           thumbnail: "https://i.imgur.com/NqnOifl.png",
                            webhookURL: "${discordWebhook}"
                    )
                }
                cleanWs()
            }
        }
    }
}
