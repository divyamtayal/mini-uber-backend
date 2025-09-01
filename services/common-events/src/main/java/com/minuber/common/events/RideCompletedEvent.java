// RideCompletedEvent.java
package com.miniuber.common.events;

public class RideCompletedEvent {
    private Long rideId;
    private Long driverId;
    private double fare;
    private double distanceKm;

    public RideCompletedEvent() {}

    public RideCompletedEvent(Long rideId, Long driverId, double fare, double distanceKm) {
        this.rideId = rideId;
        this.driverId = driverId;
        this.fare = fare;
        this.distanceKm = distanceKm;
    }

    public Long getRideId() { return rideId; }
    public Long getDriverId() { return driverId; }
    public double getFare() { return fare; }
    public double getDistanceKm() { return distanceKm; }
}
