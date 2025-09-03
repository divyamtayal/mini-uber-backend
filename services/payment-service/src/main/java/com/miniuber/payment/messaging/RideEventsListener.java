package com.miniuber.payment.messaging;

import com.miniuber.common.events.RideCompletedEvent;
import com.miniuber.common.events.PaymentCreatedEvent;
import com.miniuber.payment.entity.Payment;
import com.miniuber.payment.repository.PaymentRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class RideEventsListener {

    private final PaymentRepository paymentRepository;
    private PaymentEventsProducer paymentEventsProducer;

    public RideEventsListener(PaymentRepository paymentRepository, PaymentEventsProducer paymentEventsProducer) {
        this.paymentRepository = paymentRepository;
        this.paymentEventsProducer = paymentEventsProducer;
    }

    @KafkaListener(topics = "ride-completed", groupId = "payment-service-group")
    public void consumeRideCompleted(RideCompletedEvent event) {
        System.out.println("💳 Payment Service received ride completion: " + event);

        // Create payment entry
        Payment payment = new Payment();
        payment.setRideId(event.getRideId());
        payment.setUserId(event.getUserId());
        payment.setAmount(event.getFare());
        payment.setStatus("PENDING");
        payment.setPaymentTime(LocalDateTime.now());

        paymentRepository.save(payment);

        System.out.println("✅ Payment record created for ride " + event.getRideId() +
                " amount $" + event.getFare());
        PaymentCreatedEvent evt = new PaymentCreatedEvent(
                payment.getId(),
                payment.getRideId(),
                payment.getUserId(),
                payment.getAmount(),
                payment.getStatus()
        );

        paymentEventsProducer.publish(evt);
    }
}
