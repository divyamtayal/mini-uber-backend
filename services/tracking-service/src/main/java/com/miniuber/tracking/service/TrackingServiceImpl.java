package com.miniuber.tracking.service;

import com.miniuber.tracking.dto.TrackingDTO;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TrackingServiceImpl implements TrackingService {

    private final RedisTemplate<String, TrackingDTO> redisTemplate;
    private static final String KEY = "tracking";

    public TrackingServiceImpl(RedisTemplate<String, TrackingDTO> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void saveLocation(TrackingDTO dto) {
        redisTemplate.opsForHash().put(KEY, dto.getDriverId(), dto);
    }

    @Override
    public TrackingDTO getLocation(Long driverId) {
        return (TrackingDTO) redisTemplate.opsForHash().get(KEY, driverId);
    }

    @Override
    public Map<Object, Object> getAllLocations() {
        return redisTemplate.opsForHash().entries(KEY);
    }
}
