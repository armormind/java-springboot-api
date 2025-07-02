FROM openjdk:25-ea-21-slim-bullseye

WORKDIR /opt/app

COPY target/customer-api-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "customer-api-0.0.1-SNAPSHOT.jar"]