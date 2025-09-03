package com.miniuber.payment.messaging;

import com.miniuber.common.events.PaymentCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentEventsProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public PaymentEventsProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(PaymentCreatedEvent event) {
        kafkaTemplate.send("payment-created", event);
        System.out.println("📤 Payment Service published PaymentCreatedEvent: " + event);
    }
}

