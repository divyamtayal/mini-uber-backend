package com.miniuber.ride.dto;

import java.time.LocalDateTime;

public class RideRequestDTO {
    private Long userId;
    private Long driverId;
    private String startLocation;
    private String endLocation;
    private LocalDateTime startTime;
    private String status; // Optional: for status updates

    // Getters & Setters
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Long getDriverId() { return driverId; }
    public void setDriverId(Long driverId) { this.driverId = driverId; }
    public String getStartLocation() { return startLocation; }
    public void setStartLocation(String startLocation) { this.startLocation = startLocation; }
    public String getEndLocation() { return endLocation; }
    public void setEndLocation(String endLocation) { this.endLocation = endLocation; }
    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
