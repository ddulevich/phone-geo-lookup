FROM maven:3-openjdk-17 as build
RUN mkdir /app
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
RUN mkdir /project
COPY --from=build /app/target/phone-0.0.1-SNAPSHOT.jar /project
WORKDIR /project
ENTRYPOINT ["java","-jar","phone-0.0.1-SNAPSHOT.jar"]