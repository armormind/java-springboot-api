# stage 1
FROM maven:3.9.10-eclipse-temurin-21 AS builder

WORKDIR /opt/app

COPY . .

RUN mvn clean package

# stage 2

FROM openjdk:25-ea-21-slim-bullseye

WORKDIR /opt/app

COPY --from=builder /opt/app/target/customer-api-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "customer-api-0.0.1-SNAPSHOT.jar"]