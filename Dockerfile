FROM openjdk:8-jdk-alpine

EXPOSE 8080

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} spring-redis-api.jar

ENTRYPOINT ["java","-jar","/spring-redis-api.jar"]