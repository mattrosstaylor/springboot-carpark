package com.mattaretaylor.carpark.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("small")
public class SpaceSmall extends Space {
}
