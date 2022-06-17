#Start with a base image containing Java runtime
FROM openjdk:17 as build

#Information around who maintains the image
MAINTAINER samuel.me

ARG JAR_FILE=target/*.jar
# Add the application's jar to the container
COPY ${JAR_FILE} notification-service-0.0.1-SNAPSHOT.jar
#execute the application
ENTRYPOINT ["java","-jar","/notification-service-0.0.1-SNAPSHOT.jar"]