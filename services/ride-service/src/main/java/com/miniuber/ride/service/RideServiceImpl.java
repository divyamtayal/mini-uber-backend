package com.miniuber.ride.service;

import com.miniuber.ride.dto.RideRequestDTO;
import com.miniuber.ride.dto.RideResponseDTO;
import com.miniuber.ride.entity.Ride;
import com.miniuber.ride.repository.RideRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RideServiceImpl implements RideService {

    private final RideRepository rideRepository;

    public RideServiceImpl(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    @Override
    public RideResponseDTO createRide(RideRequestDTO dto) {
        Ride ride = new Ride();
        ride.setUserId(dto.getUserId());
        ride.setDriverId(dto.getDriverId());
        ride.setStartLocation(dto.getStartLocation());
        ride.setEndLocation(dto.getEndLocation());
        ride.setStartTime(dto.getStartTime());
        ride.setStatus("REQUESTED");
        ride = rideRepository.save(ride);
        return mapToResponse(ride);
    }

    @Override
    public List<RideResponseDTO> getAllRides() {
        return rideRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public RideResponseDTO getRideById(Long id) {
        return rideRepository.findById(id)
                .map(this::mapToResponse)
                .orElse(null);
    }

    @Override
    public List<RideResponseDTO> getRidesByUser(Long userId) {
        return rideRepository.findByUserId(userId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<RideResponseDTO> getRidesByDriver(Long driverId) {
        return rideRepository.findByDriverId(driverId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private RideResponseDTO mapToResponse(Ride ride) {
        RideResponseDTO dto = new RideResponseDTO();
        dto.setId(ride.getId());
        dto.setUserId(ride.getUserId());
        dto.setDriverId(ride.getDriverId());
        dto.setStartLocation(ride.getStartLocation());
        dto.setEndLocation(ride.getEndLocation());
        dto.setStartTime(ride.getStartTime());
        dto.setEndTime(ride.getEndTime());
        dto.setFare(ride.getFare());
        dto.setStatus(ride.getStatus());
        return dto;
    }
    @Override
    public RideResponseDTO updateRideStatus(Long rideId, String status) {
        Ride ride = rideRepository.findById(rideId).orElseThrow();
        ride.setStatus(status);
        rideRepository.save(ride);
        return mapToResponse(ride);
    }

    @Override
    public RideResponseDTO updateCurrentLocation(Long rideId, String currentLocation) {
        Ride ride = rideRepository.findById(rideId).orElseThrow();
        ride.setCurrentLocation(currentLocation);
        rideRepository.save(ride);
        return mapToResponse(ride);
    }

    @Override
    public RideResponseDTO completeRide(Long rideId) {
        Ride ride = rideRepository.findById(rideId).orElseThrow();
        ride.setStatus("COMPLETED");
        ride.setEndTime(LocalDateTime.now());
        // Simple fare calculation: base + distance * 10
        double fare = 50 + (ride.getDistanceKm() != null ? ride.getDistanceKm() * 10 : 0);
        ride.setFare(fare);
        rideRepository.save(ride);
        return mapToResponse(ride);
    }

}
