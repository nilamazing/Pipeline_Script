pipeline{
    agent any
    stages{
        stage("Extract code from Git"){
            steps{
                echo "Extracting code from Git!!"
                git 'https://github.com/nilamazing/Pipeline_Script.git'
            }
        }
        stage("Compile Code"){
            steps{
                echo "Compile Code!!"
                bat label: '', script: 'Build.bat'
            }
        }
        stage("Test Code"){
            steps{
                echo "Test Code!!"
                bat label: '', script: 'Test.bat'
            }
        }
        stage("Analyze Code Quality"){
            steps{
                echo "Analyze Code Quality!!"
                bat label: '', script: 'Quality.bat'
            }
        }
        stage("Deploy Code"){
            steps{
                echo "Deploy Code!!"
                bat label: '', script: 'Deploy.bat'
            }
        }
    }
    post{
        always{
            echo "This will always run!!"
        }
        success{
            echo "This will run if there is success!!"
        }
        failure{
            echo "This will run if failed!!"
        }
        unstable{
            echo "This will appear if the run is marked unstable!!"
        }
    }
}