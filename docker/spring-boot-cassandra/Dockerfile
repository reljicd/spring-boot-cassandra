FROM openjdk:8-jdk-alpine

EXPOSE 9003

ENV APP_HOME /usr/src/app

COPY target/spring-boot-cassandra-0.0.1-SNAPSHOT.jar $APP_HOME/app.jar

WORKDIR $APP_HOME

ENV JAVA_OPTS=""

ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar app.jar