package com.miniuber.ride;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rides")
public class RideController {

    @GetMapping("/ping")
    public String ping() {
        return "Ride Service is running!";
    }

    @PostMapping("/request")
    public String requestRide(@RequestBody String request) {
        return "Ride requested: " + request;
    }
}
