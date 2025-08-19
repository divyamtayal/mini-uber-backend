package com.miniuber.payment;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @GetMapping("/ping")
    public String ping() {
        return "Payment Service is running!";
    }

    @PostMapping("/process")
    public String processPayment(@RequestBody String payment) {
        return "Payment processed: " + payment;
    }
}
