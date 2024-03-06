FROM openjdk:21-jdk-slim
VOLUME /tmp
ARG JAR_FILE
COPY target/docker-from-zero-to-mastery-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]