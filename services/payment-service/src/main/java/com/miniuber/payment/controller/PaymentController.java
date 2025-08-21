package com.miniuber.payment.controller;

import com.miniuber.payment.dto.PaymentRequestDTO;
import com.miniuber.payment.dto.PaymentResponseDTO;
import com.miniuber.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public PaymentResponseDTO createPayment(@RequestBody PaymentRequestDTO request) {
        return paymentService.createPayment(request);
    }

    @GetMapping("/{paymentId}")
    public PaymentResponseDTO getPayment(@PathVariable Long paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    @GetMapping("/user/{userId}")
    public List<PaymentResponseDTO> getPaymentsByUser(@PathVariable Long userId) {
        return paymentService.getPaymentsByUser(userId);
    }

    @GetMapping("/ride/{rideId}")
    public List<PaymentResponseDTO> getPaymentsByRide(@PathVariable Long rideId) {
        return paymentService.getPaymentsByRide(rideId);
    }
}
