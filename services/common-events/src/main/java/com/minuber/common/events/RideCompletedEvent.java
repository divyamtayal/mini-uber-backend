// RideCompletedEvent.java
package com.miniuber.common.events;
import java.time.LocalDateTime;

public class RideCompletedEvent {
    private Long rideId;
    private Long driverId;
    private double fare;
    private double distanceKm;
    private Long userId;
    private LocalDateTime endTime;

    public RideCompletedEvent() {}

    public RideCompletedEvent(Long rideId, Long userId, Long driverId, double fare, LocalDateTime endTime) {
        this.rideId = rideId;
        this.driverId = driverId;
        this.fare = fare;
        this.distanceKm = distanceKm;
        this.userId = userId;
        this.endTime = endTime;
    }

    public Long getRideId() { return rideId; }
    public Long getDriverId() { return driverId; }
    public double getFare() { return fare; }
    public double getDistanceKm() { return distanceKm; }
    public Long getUserId() { return userId; }
    public LocalDateTime getEndTime() { return endTime; }
}
