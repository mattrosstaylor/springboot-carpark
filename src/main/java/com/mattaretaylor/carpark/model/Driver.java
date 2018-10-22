package com.mattaretaylor.carpark.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;
    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="driver_vehicle",
            joinColumns={@JoinColumn(name="driver_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="vehicle_id", referencedColumnName="id")})
    private List<Vehicle> vehicles;
}
