package com.mattaretaylor.carpark.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("car")
public class VehicleCar extends Vehicle {

    @Override
    public String getType() {
        return "Car";
    }
}
