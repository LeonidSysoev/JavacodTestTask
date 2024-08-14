FROM amazoncorretto:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} wallettesttask.jar
CMD ["java", "-jar", "/wallettesttask.jar"]