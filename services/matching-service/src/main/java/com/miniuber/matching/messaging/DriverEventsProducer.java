package com.miniuber.matching.messaging;

import com.miniuber.common.events.DriverAssignedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class DriverEventsProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public DriverEventsProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(DriverAssignedEvent event) {
        kafkaTemplate.send("driver-assigned", event);
        System.out.println("✅ Published DriverAssignedEvent: " + event);
    }
}
