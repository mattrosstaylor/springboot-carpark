package com.mattaretaylor.carpark.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("bus")
public class VehicleBus extends Vehicle {

    @Override
    public String getType() {
        return "Bus";
    }
}
