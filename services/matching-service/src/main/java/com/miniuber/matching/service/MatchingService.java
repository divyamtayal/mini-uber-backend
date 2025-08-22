package com.miniuber.matching.service;

import com.miniuber.matching.dto.MatchRequestDTO;

public interface MatchingService {
    void findAndAssignDriver(MatchRequestDTO requestDTO);
}
