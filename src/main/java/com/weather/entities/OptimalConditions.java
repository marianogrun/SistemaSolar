package com.weather.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("OPTIMALCONDITIONS")
public class OptimalConditions extends Weather {

    public OptimalConditions () {

    }

    public OptimalConditions (Integer dayNumber) {
        this.dayNumber= dayNumber;
    }
}
