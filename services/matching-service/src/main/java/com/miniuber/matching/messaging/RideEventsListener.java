package com.miniuber.matching.messaging;

import com.miniuber.common.events.RideRequestedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RideEventsListener {

    @KafkaListener(topics = "ride-requested-topic", groupId = "matching-group")
    public void consumeRideRequested(RideRequestedEvent event) {
        System.out.println("🚕 Matching Service received ride request:");
        System.out.println("RideId: " + event.getRideId() +
                ", UserId: " + event.getUserId() +
                ", Start: " + event.getStartLocation() +
                ", End: " + event.getEndLocation());

        // 👉 here later we’ll implement actual driver matching logic
    }
}
