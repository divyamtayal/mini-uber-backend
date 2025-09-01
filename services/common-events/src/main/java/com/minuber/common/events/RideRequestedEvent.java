package com.miniuber.common.events;

import java.io.Serializable;
import java.time.Instant;

public class RideRequestedEvent implements Serializable {
    private Long rideId;
    private Long userId;
    private String startLocation;
    private String endLocation;
    private Instant requestedAt = Instant.now();

    public RideRequestedEvent() {}

    public RideRequestedEvent(Long rideId, Long userId, String startLocation, String endLocation) {
        this.rideId = rideId;
        this.userId = userId;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
    }

    // getters + setters

    public Long getRideId() {
        return rideId;
    }

    public void setRideId(Long rideId) {
        this.rideId = rideId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public Instant getRequestedAt() {
        return requestedAt;
    }

    public void setRequestedAt(Instant requestedAt) {
        this.requestedAt = requestedAt;
    }
}
