package com.mattaretaylor.carpark.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("motorcycle")
public class VehicleMotorcycle extends Vehicle {

    @Override
    public String getType() {
        return "Motorcycle";
    }

}
