package com.miniuber.matching.messaging;

import com.miniuber.common.events.RideRequestedEvent;
import com.miniuber.common.events.DriverAssignedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RideEventsListener {
    private final DriverEventsProducer driverEventsProducer;

    // ✅ Constructor injection
    public RideEventsListener(DriverEventsProducer driverEventsProducer) {
        this.driverEventsProducer = driverEventsProducer;
    }

    @KafkaListener(topics = "ride-requested", groupId = "matching-service-group")
    public void consumeRideRequested(RideRequestedEvent event) {
        System.out.println("🚕 Matching Service received ride request:");
        System.out.println("RideId: " + event.getRideId() +
                ", UserId: " + event.getUserId() +
                ", Start: " + event.getStartLocation() +
                ", End: " + event.getEndLocation());

        // 👉 here later we’ll implement actual driver matching logic

        // fake driver assignment
        Long driverId = 42L;
        System.out.println("DriverId: " + driverId);
        DriverAssignedEvent assigned = new DriverAssignedEvent(event.getRideId(), driverId);
        System.out.println("DriverAssignedEvent: " + assigned);
        driverEventsProducer.publish(assigned);
    }
}
