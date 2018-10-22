package com.mattaretaylor.carpark.service;

import com.mattaretaylor.carpark.model.Driver;
import com.mattaretaylor.carpark.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository repo;

    public Iterable<Driver> findAll() {
        return repo.findAll();
    }

    public Driver getById(Long id) {
        Optional<Driver> d = repo.findById(id);
        return (d.isPresent()) ? d.get() : null;
    }

    public void save(Driver d) {
        repo.save(d);
    }

    public void delete(Driver d) {
        repo.delete(d);
    }
}
