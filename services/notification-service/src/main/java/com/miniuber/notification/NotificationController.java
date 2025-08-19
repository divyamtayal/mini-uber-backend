package com.miniuber.notification;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @GetMapping("/ping")
    public String ping() {
        return "Notification Service is running!";
    }

    @PostMapping("/send")
    public String sendNotification(@RequestBody String message) {
        return "Notification sent: " + message;
    }
}
