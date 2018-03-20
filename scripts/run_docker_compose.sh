#!/usr/bin/env bash

export CONTAINER_NAME=spring-boot-cassandra
echo -e "\nSet docker container name as ${CONTAINER_NAME}\n"

echo -e "\nStop running Docker containers with container name ${CONTAINER_NAME}...\n"
docker stop $(docker ps -a | grep ${CONTAINER_NAME} | awk '{print $1}')

echo -e "\nStop and delete Cassandra containers... \n"
docker stop $(docker ps -a | grep cassandra | awk '{print $1}')
docker rm $(docker ps -a | grep cassandra | awk '{print $1}')

echo -e "\nStart Docker Compose...\n"
docker-compose -f docker/docker-compose.yml up --build --force-recreate --abort-on-container-exit