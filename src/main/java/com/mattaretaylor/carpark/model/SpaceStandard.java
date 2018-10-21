package com.mattaretaylor.carpark.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("standard")
public class SpaceStandard extends Space {
}
