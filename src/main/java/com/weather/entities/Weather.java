package com.weather.entities;

import javax.persistence.*;


@Entity
@Table (name="weather")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Weather {
	

	protected Long id;
	protected Integer day;
	protected String type;
	protected double perimeter;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Column (insertable = false, updatable = false)
	public String getType(){
		return type;
	}

	public Integer getDay() {
		return day;
	}

	public double getPerimeter() {
		return perimeter;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPerimeter(double perimeter){this.perimeter=perimeter;}

	
	
	

}
