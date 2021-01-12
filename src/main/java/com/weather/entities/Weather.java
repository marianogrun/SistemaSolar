package com.weather.entities;

import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.*;


@Entity
@Table (name="weather")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Weather {
	

	protected Long id;
	protected Integer day;

	protected String type;
	
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

	public void setDay(Integer day) {
		this.day = day;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
	

}
