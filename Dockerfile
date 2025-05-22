FROM eclipse-temurin:24-jdk

# Set working directory
WORKDIR /app

# Install tools
RUN apt-get update && apt-get install -y curl unzip git && rm -rf /var/lib/apt/lists/*

# Maven wrapper + dependencies
COPY .mvn/ .mvn/
COPY mvnw mvnw
RUN chmod +x mvnw
COPY mvnw.cmd mvnw.cmd
COPY pom.xml .
COPY docker-entrypoint.sh /app/docker-entrypoint.sh
RUN chmod +x /app/docker-entrypoint.sh

# Pre-fetch dependencies
RUN ./mvnw dependency:go-offline

# Copy the source code last (for live bind)
COPY . .

# Expose Spring Boot default port
EXPOSE 3000
