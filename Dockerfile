FROM eclipse-temurin:17-jdk-focal


COPY /opentelemetry-javaagent.jar opentelemetry-javaagent.jar
COPY /build/libs/rabbitmqproducer.jar app.jar
COPY /build/libs/rabbitmqproducer-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-javaagent:./opentelemetry-javaagent.jar", "-jar", "/app.jar"]
