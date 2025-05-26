# syntax=docker/dockerfile:1-labs
FROM maven:3.8.7-openjdk-18 AS build
LABEL authors="ll06p"

ARG REDIS_HOST
ARG REDIS_PORT
ARG REDIS_PASSWORD
ARG MYSQL_URL
ARG MYSQL_USERNAME
ARG MYSQL_PASSWORD

WORKDIR /app

COPY pom.xml .
COPY --exclude=**/target/ --parents ./Safewind-*/ .

RUN ["mvn", "install"]
RUN ["mvn", "-pl", "Safewind-starter", "package", "spring-boot:repackage"]

FROM openjdk:17 AS run
LABEL authors="ll06p"
WORKDIR /app
COPY --from=build /app/Safewind-starter/target/Safewind-starter-*.jar Safewind-starter.jar
ENTRYPOINT ["java", "-jar", "Safewind-starter.jar"]