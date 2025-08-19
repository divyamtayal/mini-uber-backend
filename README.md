# 🚖 Mini-Uber Backend System

A distributed ride-hailing backend system inspired by Uber, built with **Java Spring Boot** and deployed on **AWS**.  
Designed to demonstrate **scalable microservices, event-driven architecture, cloud deployment, and system design best practices**.

---

## 🏗️ Architecture

**Core Microservices**
- **User Service** – Manages riders & drivers (Spring Boot + PostgreSQL RDS)
- **Ride Service** – Ride lifecycle (Spring Boot + PostgreSQL + Kafka/SQS)
- **Matching Service** – Finds nearest drivers (Spring Boot + Redis + OpenSearch)
- **Tracking Service** – Real-time driver updates (Spring WebFlux + Redis Pub/Sub)
- **Payment Service** – Ride payments & receipts (Spring Boot + Stripe sandbox + S3)
- **Notification Service** – SMS/Email notifications (AWS SNS + SES)

**Cloud Infrastructure**
- **Compute**: AWS ECS/EKS + Docker
- **Messaging**: Kafka (MSK) / SQS
- **Data Stores**: PostgreSQL (RDS), Redis (ElastiCache), OpenSearch
- **Storage**: AWS S3
- **Monitoring**: Prometheus + Grafana + CloudWatch
- **Auth**: AWS Cognito or Spring Security (JWT)
- **IaC**: Terraform

---

## 🚀 Features
✅ User & Driver registration/login with JWT/Cognito  
✅ Rider requests rides, matched to nearest available driver  
✅ Real-time driver tracking (WebSockets)  
✅ Payments via Stripe sandbox + receipts stored in S3  
✅ Notifications (SMS/Email via SNS + SES)  
✅ Deployed with CI/CD (GitHub Actions → ECS/EKS)  
✅ Load-tested with 10k concurrent requests  
✅ Monitoring dashboards with Prometheus & Grafana

---

## ⚙️ Setup Instructions

### 1️⃣ Prerequisites
- Java 17+
- Maven/Gradle
- Docker & Docker Compose
- AWS account (for cloud deployment)
- Terraform (if using IaC)

### 2️⃣ Local Development
```bash
# Start local dependencies
docker-compose up -d

# Run User Service
cd services/user-service
mvn spring-boot:run
