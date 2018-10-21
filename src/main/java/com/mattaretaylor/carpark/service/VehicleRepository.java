package com.mattaretaylor.carpark.service;

import com.mattaretaylor.carpark.model.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
}
