package com.miniuber.tracking.service;

import com.miniuber.tracking.dto.TrackingDTO;
import java.util.Map;

public interface TrackingService {

    void saveLocation(TrackingDTO dto);

    TrackingDTO getLocation(Long driverId);

    Map<Object, Object> getAllLocations();
}
