pipeline{
    agent any
    tools { 
        maven 'maven' 
        jdk 'jdk' 
    }
    stages {
        stage('Checkout'){
            steps{
                 checkout([$class: 'GitSCM', branches: [[name: '*/jenkins_fix']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'git', url: 'https://github.com/ekazakova19/otus.hometasks.otusBDD.git']]])
            }
        }
        stage('Run test'){
            steps{
                echo 'Test passed'
                sh 'mvn clean test -Dcucumber.options="--tags @debug"'
            }
        }
        stage('Generate Allure report'){
            steps{
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }
    }
    post('Send email notification') { 
        always { 
                 emailext body: '''${SCRIPT, template="groovy-text1.template"} TEST RESULTS
                                    total  - ${TEST_COUNTS, var="total"}
                                    failed - ${TEST_COUNTS, var="fail"}
                                    passed - ${TEST_COUNTS, var="pass"}
                                    skipped - ${TEST_COUNTS, var="skip"}''', 
                        subject:"[JENKINS] "+"${currentBuild.currentResult}"+" $JOB_NAME #$BUILD_NUMBER",
                        to: 'al.kazakova93@gmail.com'
                archiveArtifacts artifacts: 'target/allure-report', followSymlinks: false
             }
     }
}
