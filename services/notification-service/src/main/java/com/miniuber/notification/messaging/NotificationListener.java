package com.miniuber.notification.messaging;

import com.miniuber.common.events.DriverAssignedEvent;
import com.miniuber.common.events.PaymentCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @KafkaListener(topics = "driver-assigned", groupId = "notification-service-group")
    public void handleDriverAssigned(DriverAssignedEvent event) {
        System.out.println("📩 Notification: Driver assigned! " +
                "Ride " + event.getRideId() + " assigned to Driver " + event.getDriverId());
        // Later: push email/SMS
    }

    @KafkaListener(topics = "payment-created", groupId = "notification-service-group")
    public void handlePaymentCreated(PaymentCreatedEvent event) {
        System.out.println("📩 Notification: Payment created! " +
                "Ride " + event.getRideId() + ", Amount $" + event.getAmount());
        // Later: push email/SMS
    }
}
