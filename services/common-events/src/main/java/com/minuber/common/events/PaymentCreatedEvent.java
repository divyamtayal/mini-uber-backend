package com.miniuber.common.events;

public class PaymentCreatedEvent {
    private Long paymentId;
    private Long rideId;
    private Long userId;
    private Double amount;
    private String status;

    public PaymentCreatedEvent() {}

    public PaymentCreatedEvent(Long paymentId, Long rideId, Long userId, Double amount, String status) {
        this.paymentId = paymentId;
        this.rideId = rideId;
        this.userId = userId;
        this.amount = amount;
        this.status = status;
    }

    public Long getPaymentId() { return paymentId; }
    public void setPaymentId(Long paymentId) { this.paymentId = paymentId; }

    public Long getRideId() { return rideId; }
    public void setRideId(Long rideId) { this.rideId = rideId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
