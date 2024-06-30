# Dockerfile
FROM maven:3.8.1-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-oracle
COPY target/*.jar testapp.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","testapp.jar"]