FROM amazoncorretto:17-alpine
ARG JAR_FILE=./build/libs/char-counter-1.0.0.jar
WORKDIR /opt/app
COPY $JAR_FILE app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]