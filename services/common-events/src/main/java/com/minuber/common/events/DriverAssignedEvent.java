package com.miniuber.common.events;

public class DriverAssignedEvent {
    private Long rideId;
    private Long driverId;

    public DriverAssignedEvent() {}
    public DriverAssignedEvent(Long rideId, Long driverId) {
        this.rideId = rideId;
        this.driverId = driverId;
    }

    public Long getRideId() { return rideId; }
    public void setRideId(Long rideId) { this.rideId = rideId; }

    public Long getDriverId() { return driverId; }
    public void setDriverId(Long driverId) { this.driverId = driverId; }
}
