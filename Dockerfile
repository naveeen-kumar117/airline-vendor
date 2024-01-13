FROM bellsoft/liberica-openjdk-alpine:17.0.9

#Install CURL and JQ

RUN apk add curl jq

#WORKSPACE

WORKDIR /home/selenium-docker

#Add required files to run the test

ADD target/docker-resources /home/selenium-docker
ADD runner.sh	runner.sh

#Entry Point

ENTRYPOINT sh runner.sh