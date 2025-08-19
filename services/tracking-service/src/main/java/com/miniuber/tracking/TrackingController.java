package com.miniuber.tracking;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tracking")
public class TrackingController {

    @GetMapping("/ping")
    public String ping() {
        return "Tracking Service is running!";
    }

    @PostMapping("/update-location")
    public String updateLocation(@RequestBody String location) {
        return "Driver location updated: " + location;
    }
}
