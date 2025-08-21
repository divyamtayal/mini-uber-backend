package com.miniuber.ride.controller;

import com.miniuber.ride.dto.RideRequestDTO;
import com.miniuber.ride.dto.RideResponseDTO;
import com.miniuber.ride.service.RideService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rides")
public class RideController {

    private final RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    @PostMapping
    public RideResponseDTO createRide(@RequestBody RideRequestDTO rideRequestDTO) {
        return rideService.createRide(rideRequestDTO);
    }

    @GetMapping
    public List<RideResponseDTO> getAllRides() {
        return rideService.getAllRides();
    }

    @GetMapping("/{id}")
    public RideResponseDTO getRideById(@PathVariable Long id) {
        return rideService.getRideById(id);
    }

    @GetMapping("/user/{userId}")
    public List<RideResponseDTO> getRidesByUser(@PathVariable Long userId) {
        return rideService.getRidesByUser(userId);
    }

    @GetMapping("/driver/{driverId}")
    public List<RideResponseDTO> getRidesByDriver(@PathVariable Long driverId) {
        return rideService.getRidesByDriver(driverId);
    }
    @PatchMapping("/{rideId}/status")
    public RideResponseDTO updateRideStatus(@PathVariable Long rideId, @RequestParam String status) {
        return rideService.updateRideStatus(rideId, status);
    }

    @PatchMapping("/{rideId}/location")
    public RideResponseDTO updateCurrentLocation(@PathVariable Long rideId, @RequestParam String location) {
        return rideService.updateCurrentLocation(rideId, location);
    }

    @PostMapping("/{rideId}/complete")
    public RideResponseDTO completeRide(@PathVariable Long rideId) {
        return rideService.completeRide(rideId);
    }

}
