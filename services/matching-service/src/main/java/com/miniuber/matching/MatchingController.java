package com.miniuber.matching;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matching")
public class MatchingController {

    @GetMapping("/ping")
    public String ping() {
        return "Matching Service is running!";
    }

    @PostMapping("/find-driver")
    public String findDriver(@RequestBody String rideRequest) {
        return "Driver matched for: " + rideRequest;
    }
}
