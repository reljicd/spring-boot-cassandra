# Spring Boot + Apache Cassandra

This is an example **Spring Boot + Apache Cassandra** app.

It was made using **Spring Boot**, **Apache Cassandra**, **Spring Security**, **Spring Data Cassandra**, **Docker** and **Docker Compose**.

##Configuration

If you are not using localhost Cassandra, it is necessary to configure it to use proper endpoints.

### Configuration files

Folder **src/resources/** contains config files for **spring-boot-cassandra** Spring Boot application.

* **src/resources/application.properties** - main configuration file

### Environment variables

Configuration using environment variables is done using next variables:

* **SPRING_DATA_CASSANDRA_CONTACT_POINTS** - Cassandra cluster endpoints

* **SPRING_DATA_CASSANDRA_KEYSPACE_NAME** - Cassandra keyspace

Example:

```bash
$ export SPRING_DATA_CASSANDRA_CONTACT_POINTS=cassandra_contact_point1,cassandra_contact_point2
$ export SPRING_DATA_CASSANDRA_KEYSPACE_NAME=cassandra_keyspace_name
```

### Command line arguments

It is also possible to pass these configuration settings using command line arguments. Example:

```bash
$ java -Djava.security.egd=file:/dev/./urandom -jar app.jar \
    --spring.data.cassandra.contact-points=assandra_contact_point1,cassandra_contact_point2 \
    --spring.data.cassandra.keyspace-name=keyspace-name
``` 

## How to run

### Maven

open a terminal and run the following commands to ensure that you have valid versions of Java and Maven installed:

```bash
$ java -version
java version "1.8.0_102"
Java(TM) SE Runtime Environment (build 1.8.0_102-b14)
Java HotSpot(TM) 64-Bit Server VM (build 25.102-b14, mixed mode)
```

```bash
$ mvn -v
Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-10T16:41:47+00:00)
Maven home: /usr/local/Cellar/maven/3.3.9/libexec
Java version: 1.8.0_102, vendor: Oracle Corporation
```

#### Using the Maven Plugin

The Spring Boot Maven plugin includes a run goal that can be used to quickly compile and run your application. 
Applications run in an exploded form, as they do in your IDE. 
The following example shows a typical Maven command to run a Spring Boot application:
 
```bash
$ mvn spring-boot:run
``` 

#### Using Executable Jar

To create an executable jar run:

```bash
$ mvn package
``` 

To run that application, use the java -jar command, as follows:

```bash
$ java -jar target/spring-boot-cassandra-0.0.1-SNAPSHOT.jar
```

To exit the application, press **ctrl-c**.

### Docker

It is possible to run **spring-boot-cassandra** and **Cassandra** using Docker:

#### spring-boot-cassandra

Build Docker image:
```bash
$ mvn package
$ docker build -t spring-boot-cassandra:dev -f docker/spring-boot-cassandra/Dockerfile .
```

Run Docker container:
```bash
$ docker run --rm -i -p 9003:9003 \
      -e SPRING_DATA_CASSANDRA_CONTACT_POINTS=$SPRING_DATA_CASSANDRA_CONTACT_POINTS \
      -e SPRING_DATA_CASSANDRA_KEYSPACE_NAME=$SPRING_DATA_CASSANDRA_KEYSPACE_NAME \
      --name spring-boot-cassandra \
      spring-boot-cassandra:dev
```

##### Helper script

It is possible to run all of the above with helper script:

```bash
$ chmod +x scripts/run_docker.sh
$ scripts/run_docker.sh
```

#### Cassandra

Build Docker image:
```bash
$ docker build -t cassandra:dev -f docker/cassandra/Dockerfile .
```

Run Docker container:
```bash
$ docker run --rm -i \
      -p 9042:9042 \
      --name cassandra \
      cassandra:dev
```

##### Helper script

It is possible to run all of the above with helper script:

```bash
$ chmod +x scripts/run_docker_cassandra.sh
$ scripts/run_docker_cassandra.sh
```

### Docker Compose

Docker Compose file **docker/docker-compose.yml** is written to facilitate running of both properly initialized Cassandra, 
as well of the spring-boot-cassandra containers.

Run Docker Compose:
```bash
$ mvn package
$ docker-compose -f docker/docker-compose.yml up --build --force-recreate --abort-on-container-exit
```

#### Helper script

It is possible to run all of the above with helper script:

```bash
$ chmod +x scripts/run_docker_compose.sh
$ scripts/run_docker_compose.sh
```

## Docker 

Folder **docker/spring-boot-cassandra** contains Dockerfile for:

* **docker/spring-boot-cassandra/Dockerfile** - Docker build file for executing spring-boot-cassandra Docker image. 
Instructions to build artifacts, copy build artifacts to docker image and then run microservice on proper port with proper configuration file.

* **docker/spring-boot-cassandra/wait-for-it.sh** - is a pure bash script that will wait on the availability of a host and TCP port. It is useful for synchronizing the spin-up of interdependent services, such as linked docker containers. Since it is a pure bash script, it does not have any external dependencies. https://github.com/vishnubob/wait-for-it 

Folder **docker/cassandra** contains:

* **docker/cassandra/Dockerfile** - Docker build file for Cassandra Docker image. 

* **docker/cassandra/docker-entrypoint.sh** - Entrypoint shell script for running Cassandra and executing CQL files after Cassandra is initialized. https://github.com/dschroe/cassandra-docker

* **docker/cassandra/initial-seed.cql** - Schema definition and imports for Cassandra. 

## Util Scripts

* **scripts/run_docker.sh.sh** - util script for running spring-boot-cassandra Docker container using **docker/spring-boot-cassandra/Dockerfile**

* **scripts/run_docker_cassandra.sh** - util script for running Cassandra Docker container using **docker/cassandra/Dockerfile**

* **scripts/run_docker_compose.sh** - util script for running Docker Compose.

## Tests

Tests can be run by executing following command from the root of the project:

```bash
$ mvn test
```