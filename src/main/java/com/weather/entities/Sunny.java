package com.weather.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("SUNNY")
public class Sunny extends Weather {

    private Sunny(){

    }

    public Sunny(int day, double perimeter) {
        this.day= day;
        this.perimeter=perimeter;
    }
}
