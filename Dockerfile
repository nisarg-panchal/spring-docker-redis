# Stage 1: Build Stage
#FROM jdk-23-with-ubuntu-nisarg AS builder
FROM bellsoft/liberica-openjdk-debian:21 AS builder
# Update and install Maven
RUN apt update && apt upgrade -y && apt install -y maven

# Set the working directory
WORKDIR /app

# Copy the Maven configuration and dependencies first (to leverage caching)
COPY ./pom.xml .
COPY ./aws_settings.xml .
COPY ./src ./src

# Download dependencies (offline mode)
RUN #mvn dependency:go-offline -B -s aws_settings.xml

# Build the application
RUN mvn clean package -DskipTests -B -e -X -s aws_settings.xml

# Stage 2: Runtime Stage
FROM bellsoft/liberica-openjdk-debian:21

# Set the working directory
WORKDIR /app

# Copy the jar file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
