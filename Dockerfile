FROM eclipse-temurin:17-jdk-jammy

ARG JAR_FILE
COPY ./target/${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","./app.jar"]
