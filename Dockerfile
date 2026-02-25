# Use a Temurin OpenJDK image as a base
FROM eclipse-temurin:17-jdk-jammy

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/*.jar app.jar

# Expose the port your application listens on (default is 8080)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

# Next steps
# 1. Build docker image: docker build -t gmbd-backend-spring-image .
# 2. Run docker container: docker run -d --name gmbd-backend-spring-app -p 8080:8080 gmbd-backend-spring-image
# Note: Make sure to build the JAR file using Maven before building the Docker image:
# mvn clean package -DskipTests
# docker stop gmbd-backend-spring-app, or
# docker kill gmbd-backend-spring-app, to kill running docker process

# docker rm gmbd-backend-spring-app, to remove it from Docker