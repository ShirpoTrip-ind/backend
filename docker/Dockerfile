FROM openjdk:23-jdk-alpine
LABEL authors="sokomix"
ADD ../build/libs/ShirpoTripAPI-0.0.1-SNAPSHOT.jar api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api.jar"]