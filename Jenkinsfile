pipeline {
    agent any
    environment{
        VERSION = "${env.BUILD_NUMBER}"
    }
    tools{
        maven 'maven'
    }
    
    stages{
        stage('Build with Maven'){
            steps{
                script{
                    sh 'mvn clean install'
                }
            }
        }

        stage('Build Docker Image'){
            steps{
                script{
                    sh 'docker build -t fitoni/gitops:${VERSION} .'                    
                }
            }
        }

        stage('Push Docker Image onto Hub'){
            steps{
                script{
                     withCredentials([string(credentialsId: 'dockerhubpassword', variable: 'dockerhubpassword')]) {
                        sh '''
                            echo $dockerhubpassword | docker login -u fitoni --password-stdin https://index.docker.io/v1/
                            docker push fitoni/gitops:${VERSION}
                            docker rmi fitoni/gitops:${VERSION}
                        '''                        
                    } 
                }
            }
        }

        // stage('Build downstream job - (CD Part)'){
        //     steps{
        //         script{                      
        //             build(job: 'mrdevops-cd', parameters: [string(name: 'BUILDNUMBER', value: "${VERSION}")])                               
        //         }
        //     }
        // }
    }
}
