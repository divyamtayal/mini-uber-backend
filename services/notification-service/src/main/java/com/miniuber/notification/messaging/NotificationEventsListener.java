package com.miniuber.notification.messaging;

import com.miniuber.common.events.*;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationEventsListener {

    @KafkaListener(topics = "ride-requested", groupId = "notification-service-group")
    public void handleRideRequested(RideRequestedEvent event) {
        System.out.println("📩 Notification: New ride requested by User " + event.getUserId());
    }

    @KafkaListener(topics = "driver-assigned", groupId = "notification-service-group")
    public void handleDriverAssigned(DriverAssignedEvent event) {
        System.out.println("📩 Notification: Driver " + event.getDriverId() + " assigned to Ride " + event.getRideId());
    }

    @KafkaListener(topics = "ride-completed", groupId = "notification-service-group")
    public void handleRideCompleted(RideCompletedEvent event) {
        System.out.println("📩 Notification: Ride " + event.getRideId() + " completed!");
    }

    @KafkaListener(topics = "payment-created", groupId = "notification-service-group")
    public void handlePaymentCreated(PaymentCreatedEvent event) {
        System.out.println("📩 Notification: Payment of $" + event.getAmount() + " processed for Ride " + event.getRideId());
    }
}
