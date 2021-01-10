package com.weather.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("INTENSITYPEAK")
public class IntensityPeak extends Weather{

    public IntensityPeak () {

    }

    public IntensityPeak (Integer dayNumber) {
        this.dayNumber= dayNumber;
    }
}
