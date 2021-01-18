package com.weather.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("DROUGHT")
public class Drought extends Weather {

	public Drought(){

	}
	public Drought (int day, double perimeter) {
		this.day= day;
		this.perimeter=perimeter;
	}
}
