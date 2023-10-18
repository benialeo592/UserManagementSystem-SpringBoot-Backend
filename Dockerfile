FROM openjdk:17
LABEL authors="benia"
VOLUME /tmp
EXPOSE 8080
ADD target/ums-0.0.1-SNAPSHOT.jar dockerums.jar
ENTRYPOINT ["java","-jar","/dockerums.jar"]