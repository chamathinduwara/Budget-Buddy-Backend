# Start a new build stage to create a smaller image
FROM openjdk:17-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the previous build stage
ARG JAR_FILE=build/libs/*.jar
COPY $JAR_FILE application.jar

# Generate the RSA key pair
RUN mkdir -p /app/certs
RUN openssl genrsa -out /app/certs/keypair.pem 2048 \
    && openssl rsa -in /app/certs/keypair.pem -pubout -out /app/certs/public.pem \
    && openssl rsa -in /app/certs/keypair.pem -out /app/certs/private.pem

#ENV PRIVATE_KEY_PATH=/app/certs/private.pem
#ENV PUBLIC_KEY_PATH=/app/certs/public.pem

ENV DATASOURCE_URL=jdbc:postgresql://localhost:5432/budgetbuddy
ENV DATASOURCE_USERNAME=root
ENV DATASOURCE_PASSWORD=root

# Set the application's entry point
ENTRYPOINT ["java", "-jar", "application.jar"]


