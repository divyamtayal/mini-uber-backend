package com.miniuber.payment.service;

import com.miniuber.payment.dto.PaymentRequestDTO;
import com.miniuber.payment.dto.PaymentResponseDTO;

import java.util.List;

public interface PaymentService {

    PaymentResponseDTO createPayment(PaymentRequestDTO paymentRequest);

    PaymentResponseDTO getPaymentById(Long paymentId);

    List<PaymentResponseDTO> getPaymentsByUser(Long userId);

    List<PaymentResponseDTO> getPaymentsByRide(Long rideId);
}
