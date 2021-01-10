package com.weather.repositories;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.weather.entities.Weather;

import java.util.List;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, Long> {
		
//	boolean existsByDay (Integer dayNumber);
    List<Weather> findByDayNumber(Integer dayNumber);
}
