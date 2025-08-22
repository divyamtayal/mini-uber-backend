package com.miniuber.matching.controller;

import com.miniuber.matching.dto.MatchRequestDTO;
import com.miniuber.matching.service.MatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matching")
public class MatchingController {

    private final MatchingService matchingService;

    @Autowired
    public MatchingController(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    @PostMapping("/assign")
    public void assignDriver(@RequestBody MatchRequestDTO requestDTO) {
        matchingService.findAndAssignDriver(requestDTO);
    }
}
