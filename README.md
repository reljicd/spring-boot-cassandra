# Spring Boot + Apache Cassandra

##Configuration
### Configuration files

Folder **src/resources/** contains config files for **spring-boot-cassandra** Spring Boot application.

* **src/resources/application.properties** - main configuration file

### Configuration customization

If you are not using localhost Cassandra, it is necessary to configure it to use proper endpoints.

#### Environment variables

Configuration using environment variables is done using next variables:

* **SPRING_DATA_CASSANDRA_CONTACT_POINTS** - Cassandra cluster endpoints

* **SPRING_DATA_CASSANDRA_KEYSPACE_NAME** - Cassandra keyspace

Example:

```bash
$ export SPRING_DATA_CASSANDRA_CONTACT_POINTS=cassandra_contact_point1,cassandra_contact_point2
$ export SPRING_DATA_CASSANDRA_KEYSPACE_NAME=cassandra_keyspace_name
```

#### Command line arguments

It is also possible to pass these configuration settings using command line arguments. Example:

```bash
$ java -Djava.security.egd=file:/dev/./urandom -jar app.jar \
    --spring.data.cassandra.contact-points=assandra_contact_point1,cassandra_contact_point2 \
    --spring.data.cassandra.keyspace-name=keyspace-name
``` 

## Docker 

Folder **docker/spring-boot-cassandra** contains Dockerfile for:

* **docker/spring-boot-cassandra/Dockerfile** - Docker build file for executing spring-boot-cassandra Docker image. 
Instructions to copy build artifacts to docker image and then run microservice on proper port with proper configuration file.

If you are not using localhost Cassandra it is necessary to pass environment variables during `docker run`:

```bash
$ docker run --rm -i -p 9003:9003 \
    -e SPRING_DATA_CASSANDRA_CONTACT_POINTS=cassandra_contact_point1,cassandra_contact_point2 \
    spring-boot-cassandra
```

Folder **docker/cassandra** contains:

* **docker/cassandra/Dockerfile** - Docker build file for executing Cassandra Docker image. 

* **docker/cassandra/docker-entrypoint.sh** - Entrypoint shell script for running Cassandra, and executing CQL files. 

* **docker/cassandra/initial-seed.cql** - Schema definition and imports for Cassandra. 

## Util Scripts

* **scripts/run_docker.sh.sh** - util script for running spring-boot-cassandra Docker container using **docker/spring-boot-cassandra/Dockerfile**

* **scripts/run_docker_cassandra.sh** - util script for running Cassandra Docker container using **docker/cassandra/Dockerfile**

* **scripts/build_and_run_whole_stack.sh** - util script for running both Cassandra and spring-boot-cassandra
as Docker containers. 