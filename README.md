# 🚖 Mini-Uber Backend

A microservices-based backend implementation for a simplified Uber-like ride-hailing system.

---

## Table of Contents

- [Overview](#overview)
- [Architecture](#architecture)
- [Services](#services)
- [Databases](#databases)
- [Ports](#ports)
- [Setup & Running](#setup--running)
- [Future Enhancements](#future-enhancements)

---

## Overview

This project implements a ride-hailing backend system with the following key functionalities:

- Ride management (request, start, end)
- Real-time driver tracking
- Notifications
- Matching riders with drivers
- User management

The system is built using **Spring Boot**, **Redis**, **PostgreSQL**, and other supporting technologies.

---

## Architecture

- Microservices architecture for scalability and maintainability.
- Each service has its own responsibilities and database where applicable.
- Inter-service communication can be extended using **REST APIs** or **messaging queues** in the future.
- Redis is used for real-time tracking and caching.

