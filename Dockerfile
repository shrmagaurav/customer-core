# Use a lightweight JDK base image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy the JAR file into the container
COPY build/libs/*.jar app.jar

# Expose the application's port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
