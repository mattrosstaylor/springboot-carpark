package com.mattaretaylor.carpark.repository;

import com.mattaretaylor.carpark.model.VehicleType;
import org.springframework.data.repository.CrudRepository;

public interface VehicleTypeRepository extends CrudRepository<VehicleType, Long> {
}
