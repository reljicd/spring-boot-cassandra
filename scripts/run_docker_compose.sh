#!/usr/bin/env bash

echo -e "Create uber jar...\n"
mvn package

echo -e "\nStop running Docker containers with container name spring-boot-cassandra, and remove them...\n"
docker stop $(docker ps -a | grep spring-boot-cassandra | awk '{print $1}')
docker rm $(docker ps -a | grep spring-boot-cassandra | awk '{print $1}')

echo -e "\nStop running Docker containers with container name cassandra, and remove them...\n"
docker stop $(docker ps -a | grep cassandra | awk '{print $1}')
docker rm $(docker ps -a | grep cassandra | awk '{print $1}')

echo -e "\nStart Docker Compose...\n"
docker-compose -f docker/docker-compose.yml up --build --force-recreate --abort-on-container-exit