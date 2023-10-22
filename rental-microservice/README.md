# Rental microservice setup instructions

This README provides basic instructions for building and running the application. Please follow these steps to successfully set up and run the project.

## 1. Run the Application with Docker

We use Docker and Docker Compose to simplify running the application along with its dependencies. Ensure that Docker is installed on your system.

To run the application and its related services, use the following command:

```bash
docker-compose up -d
```

This command will start the application in Docker containers.

## 2. Access the Application

Once the application is up and running, you can access it through your web browser using the following URL:

[http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)

This URL will open the Swagger UI, where you can interact with the application's API.