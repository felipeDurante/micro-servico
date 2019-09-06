FROM openjdk:8-jdk-slim
VOLUME /tmp
ADD eureka-server/target/app-eureka-server-0.0.1-SNAPSHOT.jar app-eureka-server.jar
EXPOSE 9091
RUN bash -c 'touch /app-eureka-server.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app-eureka-server.jar"]