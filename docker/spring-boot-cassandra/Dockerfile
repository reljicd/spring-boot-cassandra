FROM openjdk:8

EXPOSE 9003

ENV APP_HOME /usr/src/app

COPY target/spring-boot-cassandra-0.0.1-SNAPSHOT.jar $APP_HOME/app.jar

COPY docker/spring-boot-cassandra/wait-for-it.sh /wait-for-it.sh
RUN chmod a+x /wait-for-it.sh

WORKDIR $APP_HOME

ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -jar app.jar