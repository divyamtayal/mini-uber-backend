# 🚖 Mini-Uber Backend

This project is a **Spring Boot microservices system** simulating Uber-like functionality.  
Each service is independent and communicates via REST (later: Kafka/AWS SQS).

## Services
- **User Service** → Register/login users
- **Ride Service** → Request rides
- **Matching Service** → Match riders with drivers
- **Tracking Service** → Track driver locations
- **Payment Service** → Handle payments
- **Notification Service** → Send notifications

## How to Run
```bash
mvn clean install
mvn -pl services/user-service spring-boot:run
