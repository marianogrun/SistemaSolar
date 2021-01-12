package com.weather.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("DROUGHT")
public class Drought extends Weather {

	private Drought(){

	}
	public Drought (int day) {
		this.day= day;
	}
}
