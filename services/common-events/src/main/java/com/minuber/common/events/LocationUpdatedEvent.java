package com.miniuber.common.events;

import java.time.LocalDateTime;

public class LocationUpdatedEvent {
    private Long driverId;
    private String location;
    private LocalDateTime timestamp;

    public LocationUpdatedEvent() {}
    public LocationUpdatedEvent(Long driverId, String location, LocalDateTime timestamp) {
        this.driverId = driverId;
        this.location = location;
        this.timestamp = timestamp;
    }

    public Long getDriverId() { return driverId; }
    public void setDriverId(Long driverId) { this.driverId = driverId; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
