FROM eclipse-temurin:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY src/main/resources/data.sql data.sql
EXPOSE 8082
ENTRYPOINT ["java","-jar","/app.jar"]
CMD ["java", "-Dspring.datasource.initialization-mode=always", "-jar", "app.jar"]
