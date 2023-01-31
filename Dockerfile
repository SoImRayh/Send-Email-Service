FROM maven as Builder
WORKDIR /


FROM openjdk

WORKDIR /app

ADD target/ms-email-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

