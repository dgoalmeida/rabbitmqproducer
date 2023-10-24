FROM eclipse-temurin:17-jdk-focal


COPY /opentelemetry-javaagent.jar opentelemetry-javaagent.jar
COPY /build/libs/rabbitmqproducer.jar app.jar
COPY /build/libs/rabbitmqproducer-0.0.1-SNAPSHOT.jar app.jar


ENV OTEL_EXPORTER_OTLP_ENDPOINT=http://otel-collector-cluster-opentelemetry-collector:4317

EXPOSE 8080
ENTRYPOINT ["java", "-javaagent:./opentelemetry-javaagent.jar", "-jar", "/app.jar"]
