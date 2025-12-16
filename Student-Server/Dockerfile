FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN mvn clean package

EXPOSE 8080

CMD ["java", "-jar", "target/student-server-1.0.0.jar"]
