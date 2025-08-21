package com.miniuber.tracking.dto;

import java.io.Serializable;

public class TrackingDTO implements Serializable {

    private Long driverId;
    private String currentLocation;
    private Long timestamp;

    public TrackingDTO() {}

    public TrackingDTO(Long driverId, String currentLocation, Long timestamp) {
        this.driverId = driverId;
        this.currentLocation = currentLocation;
        this.timestamp = timestamp;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
