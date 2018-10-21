package com.mattaretaylor.carpark.repository;

import com.mattaretaylor.carpark.model.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
}
