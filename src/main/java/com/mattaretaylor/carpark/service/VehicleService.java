package com.mattaretaylor.carpark.service;

import com.mattaretaylor.carpark.model.Vehicle;
import com.mattaretaylor.carpark.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repo;

    public Iterable<Vehicle> findAll() {
        return repo.findAll();
    }

    public Vehicle getById(Long id) {
        Optional<Vehicle> v = repo.findById(id);
        return (v.isPresent()) ? v.get() : null;
    }

    public void save(Vehicle v) {
        repo.save(v);
    }
}
