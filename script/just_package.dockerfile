FROM maven:3.8.7-openjdk-18 AS build
LABEL authors="ll06p"

WORKDIR /app
COPY ./Safewind-starter/target/Safewind-starter-*.jar ./Safewind-starter.jar

EXPOSE 9300/tcp

ENTRYPOINT ["java", "-jar", "Safewind-starter.jar"]
