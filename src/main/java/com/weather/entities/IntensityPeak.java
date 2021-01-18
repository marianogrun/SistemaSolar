package com.weather.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("INTENSITY_PEAK")
public class IntensityPeak extends Weather{


    private IntensityPeak(){

    }
    public IntensityPeak (Integer day, double perimeter) {
        this.day= day;
        this.perimeter=perimeter;
    }
}
