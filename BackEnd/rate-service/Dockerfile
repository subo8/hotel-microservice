#Start with a base image containing Java runtime
FROM openjdk:17 as build

#Information around who maintains the image
MAINTAINER bysophearyrin.me

# Add the application's jar to the container
COPY target/rate-service-0.0.1-SNAPSHOT.jar rate-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java","-jar","/rate-0.0.1-SNAPSHOT.jar"]