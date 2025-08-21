package com.miniuber.driver.service;

import com.miniuber.driver.entity.Driver;
import com.miniuber.driver.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public Optional<Driver> getDriverById(Long id) {
        return driverRepository.findById(id);
    }

    @Override
    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public Optional<Driver> updateDriver(Long id, Driver driver) {
        return driverRepository.findById(id).map(existing -> {
            existing.setName(driver.getName());
            existing.setEmail(driver.getEmail());
            existing.setVehicleNumber(driver.getVehicleNumber());
            return driverRepository.save(existing);
        });
    }

    @Override
    public boolean deleteDriver(Long id) {
        return driverRepository.findById(id).map(driver -> {
            driverRepository.delete(driver);
            return true;
        }).orElse(false);
    }
}
