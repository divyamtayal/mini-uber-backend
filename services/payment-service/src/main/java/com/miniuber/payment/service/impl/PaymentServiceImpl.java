package com.miniuber.payment.service.impl;

import com.miniuber.payment.dto.PaymentRequestDTO;
import com.miniuber.payment.dto.PaymentResponseDTO;
import com.miniuber.payment.entity.Payment;
import com.miniuber.payment.repository.PaymentRepository;
import com.miniuber.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public PaymentResponseDTO createPayment(PaymentRequestDTO request) {
        Payment payment = new Payment();
        payment.setRideId(request.getRideId());
        payment.setUserId(request.getUserId());
        payment.setAmount(request.getAmount());
        payment.setPaymentMode(request.getPaymentMode());
        payment.setStatus("SUCCESS"); // mock success
        payment.setPaymentTime(LocalDateTime.now());

        Payment saved = paymentRepository.save(payment);
        return mapToDTO(saved);
    }

    @Override
    public PaymentResponseDTO getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId)
                .map(this::mapToDTO)
                .orElse(null);
    }

    @Override
    public List<PaymentResponseDTO> getPaymentsByUser(Long userId) {
        return paymentRepository.findByUserId(userId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PaymentResponseDTO> getPaymentsByRide(Long rideId) {
        return paymentRepository.findByRideId(rideId).stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private PaymentResponseDTO mapToDTO(Payment payment) {
        PaymentResponseDTO dto = new PaymentResponseDTO();
        dto.setPaymentId(payment.getId());
        dto.setAmount(payment.getAmount());
        dto.setStatus(payment.getStatus());
        dto.setPaymentTime(payment.getPaymentTime());
        return dto;
    }
}
