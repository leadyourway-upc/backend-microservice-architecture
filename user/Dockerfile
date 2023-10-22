# Use an official OpenJDK runtime as a parent image
FROM adoptopenjdk:17-jre-hotspot

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/*.war /app/app.war

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Define environment variables for your MySQL database connection
ENV SPRING_DATASOURCE_URL=jdbc:mysql://mysql-container:3306/your-database
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=1234

# Run the application when the container launches
CMD ["java", "-jar", "app.war"]

LABEL authors="olive"

ENTRYPOINT ["top", "-b"]