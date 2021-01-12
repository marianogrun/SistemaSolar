package com.weather.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("UNDETERMINED")
public class Undetermined extends Weather {

    private Undetermined(){

    }

    public Undetermined (int day) {
        this.day= day;
    }
}
