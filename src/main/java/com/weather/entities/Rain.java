package com.weather.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RAIN")
public class Rain extends Weather {
	
	public Rain() {
		
	}
	
	public Rain(Integer dayNumber) {
		this.dayNumber= dayNumber;
	}
}
