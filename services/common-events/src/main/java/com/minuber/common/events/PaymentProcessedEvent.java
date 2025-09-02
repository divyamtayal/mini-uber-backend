package com.miniuber.common.events;

public class PaymentProcessedEvent {
    private Long rideId;
    private Double amount;
    private String status; // SUCCESS or FAILED

    public PaymentProcessedEvent() {}
    public PaymentProcessedEvent(Long rideId, Double amount, String status) {
        this.rideId = rideId;
        this.amount = amount;
        this.status = status;
    }

    public Long getRideId() { return rideId; }
    public void setRideId(Long rideId) { this.rideId = rideId; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
