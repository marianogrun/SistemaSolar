package com.weather.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("UNDETERMINED")
public class Undetermined extends Weather {

    public Undetermined () {

    }

    public Undetermined (Integer dayNumber) {
        this.dayNumber= dayNumber;
    }
}
