package com.miniuber.ride.messaging;

import com.miniuber.common.events.DriverAssignedEvent;
import com.miniuber.ride.entity.Ride;
import com.miniuber.ride.repository.RideRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverEventsListener {

    private final RideRepository rideRepository;

    public DriverEventsListener(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    @KafkaListener(topics = "driver-assigned", groupId = "ride-service-group")
    public void handleDriverAssigned(DriverAssignedEvent event) {
        System.out.println("📩 Ride-service received DriverAssignedEvent: " + event);

        Optional<Ride> rideOpt = rideRepository.findById(event.getRideId());
        if (rideOpt.isPresent()) {
            Ride ride = rideOpt.get();
            ride.setDriverId(event.getDriverId());
            ride.setStatus("ASSIGNED");
            rideRepository.save(ride);
            System.out.println("✅ Ride updated with driver assignment: " + ride.getId());
        } else {
            System.err.println("❌ Ride not found for ID: " + event.getRideId());
        }
    }
}
