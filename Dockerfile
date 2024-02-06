FROM openjdk:17-jdk-alpine
ADD . /src
WORKDIR /src
RUN ./mvnw package -DskipTests
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "target/Gateway-0.0.1-SNAPSHOT.jar"]
