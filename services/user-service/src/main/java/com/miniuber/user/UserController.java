package com.miniuber.user;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/ping")
    public String ping() {
        return "User Service is running!";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody String user) {
        return "User registered: " + user;
    }
}
