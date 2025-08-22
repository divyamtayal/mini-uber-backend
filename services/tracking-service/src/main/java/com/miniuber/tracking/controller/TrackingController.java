package com.miniuber.tracking.controller;

import com.miniuber.tracking.dto.TrackingDTO;
import com.miniuber.tracking.service.TrackingService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/tracking")
public class TrackingController {

    private final TrackingService trackingService;

    public TrackingController(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @PostMapping("/update")
    public void updateLocation(@RequestBody TrackingDTO dto) {
        trackingService.saveLocation(dto);
    }

    @GetMapping("/driver/{driverId}")
    public TrackingDTO getDriverLocation(@PathVariable Long driverId) {
        return trackingService.getLocation(driverId);
    }

    @GetMapping("/all")
    public Map<Object, Object> getAllLocations() {
        return trackingService.getAllLocations();
    }
}
