package com.mattaretaylor.carpark.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String registration;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="driver_vehicle",
            joinColumns={@JoinColumn(name="vehicle_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="driver_id", referencedColumnName="id")})
    private Set<Driver> drivers;

    @OneToOne(mappedBy = "vehicle")
    private Space space;

    public abstract String getType();
}
