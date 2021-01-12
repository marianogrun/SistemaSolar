package com.weather.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("RAIN")
public class Rain extends Weather {

	private Rain(){

	}

	public Rain(Integer day) {
		this.day= day;
	}
}
