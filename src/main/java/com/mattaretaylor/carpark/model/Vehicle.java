package com.mattaretaylor.carpark.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String registration;
    private String model;
    private String colour;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="driver_vehicle",
            joinColumns={@JoinColumn(name="vehicle_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="driver_id", referencedColumnName="id")})
    private List<Driver> drivers;

    @OneToOne(mappedBy = "vehicle")
    private Space space;

    public abstract String getType();
}
