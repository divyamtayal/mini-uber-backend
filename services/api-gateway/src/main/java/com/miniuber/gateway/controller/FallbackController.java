package com.miniuber.gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @RequestMapping("/fallback/users")
    public ResponseEntity<String> userServiceFallback() {
        return ResponseEntity.ok("User Service is currently unavailable. Please try again later.");
    }

    @RequestMapping("/fallback/drivers")
    public ResponseEntity<String> driverServiceFallback() {
        return ResponseEntity.ok("Driver Service is currently unavailable. Please try again later.");
    }

    @RequestMapping("/fallback/rides")
    public ResponseEntity<String> rideServiceFallback() {
        return ResponseEntity.ok("Ride Service is currently unavailable. Please try again later.");
    }

    @RequestMapping("/fallback/tracking")
    public ResponseEntity<String> trackingServiceFallback() {
        return ResponseEntity.ok("Tracking Service is currently unavailable. Please try again later.");
    }

    @RequestMapping("/fallback/matching")
    public ResponseEntity<String> matchingServiceFallback() {
        return ResponseEntity.ok("Matching Service is currently unavailable. Please try again later.");
    }

    @RequestMapping("/fallback/payments")
    public ResponseEntity<String> paymentServiceFallback() {
        return ResponseEntity.ok("Payment Service is currently unavailable. Please try again later.");
    }

    @RequestMapping("/fallback/notifications")
    public ResponseEntity<String> notificationServiceFallback() {
        return ResponseEntity.ok("Noitification Service is currently unavailable. Please try again later.");
    }


    // add other service fallbacks as needed
}
