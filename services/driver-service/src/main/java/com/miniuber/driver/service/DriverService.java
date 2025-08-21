package com.miniuber.driver.service;

import com.miniuber.driver.entity.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    List<Driver> getAllDrivers();
    Optional<Driver> getDriverById(Long id);
    Driver createDriver(Driver driver);
    Optional<Driver> updateDriver(Long id, Driver driver);
    boolean deleteDriver(Long id);
}
