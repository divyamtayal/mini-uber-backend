package com.miniuber.ride.messaging;

import com.miniuber.common.events.RideRequestedEvent;
import com.miniuber.common.events.RideCompletedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class RideEventsProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public RideEventsProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishRideRequested(RideRequestedEvent event) {
        System.out.println("✅ Published RideRequestedEvent to Kafka");
        kafkaTemplate.send("ride-requested", event);
    }

    public void publishRideCompleted(RideCompletedEvent event) {
        kafkaTemplate.send("ride-completed", event);
    }
}
