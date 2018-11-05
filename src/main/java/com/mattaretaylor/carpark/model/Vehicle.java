package com.mattaretaylor.carpark.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String registration;
    private String model;
    private String colour;

    @OneToOne
    private VehicleType type;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="driver_vehicle",
            joinColumns={@JoinColumn(name="vehicle_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="driver_id", referencedColumnName="id")})
    private List<Driver> drivers;

    @OneToOne(mappedBy = "vehicle")
    private Space space;
}
