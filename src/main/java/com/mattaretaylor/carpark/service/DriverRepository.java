package com.mattaretaylor.carpark.service;

import com.mattaretaylor.carpark.model.Driver;
import org.springframework.data.repository.CrudRepository;

public interface DriverRepository extends CrudRepository<Driver, Long> {
}
