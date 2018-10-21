package com.mattaretaylor.carpark.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="driver_vehicle",
            joinColumns={@JoinColumn(name="driver_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="vehicle_id", referencedColumnName="id")})
    private List<Vehicle> vehicles;
}
