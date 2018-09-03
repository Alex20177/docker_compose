FROM openjdk:8-jdk-alpine
#FROM java:8
VOLUME /tmp
COPY target/mysql-thymeleaf-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
