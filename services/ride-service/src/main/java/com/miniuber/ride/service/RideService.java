package com.miniuber.ride.service;

import com.miniuber.ride.dto.RideRequestDTO;
import com.miniuber.ride.dto.RideResponseDTO;

import java.util.List;

public interface RideService {
    RideResponseDTO createRide(RideRequestDTO rideRequestDTO);
    List<RideResponseDTO> getAllRides();
    RideResponseDTO getRideById(Long id);
    List<RideResponseDTO> getRidesByUser(Long userId);
    List<RideResponseDTO> getRidesByDriver(Long driverId);
    RideResponseDTO updateRideStatus(Long rideId, String status);
    RideResponseDTO updateCurrentLocation(Long rideId, String currentLocation);
    RideResponseDTO completeRide(Long rideId); // Automatically calculate fare

}
