FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/AdministracionDevs-0.0.1.jar
COPY ${JAR_FILE} app_devs.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_devs.jar", "--server.port=${PORT}"]