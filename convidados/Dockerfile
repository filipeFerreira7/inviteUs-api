FROM maven:3.9.4-eclipse-temurin-21 as build
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21
WORKDIR /app
COPY --from=build /build/target/convidados-0.0.1-SNAPSHOT.jar /app/convidados.jar
ENTRYPOINT ["java", "-jar", "/app/convidados.jar"]
 