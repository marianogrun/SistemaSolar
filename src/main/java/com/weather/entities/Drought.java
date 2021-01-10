package com.weather.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("DROUGHT")
public class Drought extends Weather {
	
	public Drought () {
		
	}
	
	public Drought (Integer dayNumber) {
		this.dayNumber= dayNumber;
	}
}
