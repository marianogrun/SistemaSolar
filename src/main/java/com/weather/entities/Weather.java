package com.weather.entities;

import javax.persistence.*;


@Entity
@Table (name="weather")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Weather {
	

	protected Long id; 
	protected Integer dayNumber;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column
	public Integer getDayNumber() {
		return dayNumber;
	}
	public void setDayNumber(Integer dayNumber) {
		this.dayNumber = dayNumber;
	}
	
	
	

}
