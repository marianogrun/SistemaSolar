package com.weather.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.weather.entities.Drought;

@Repository
public interface DroughtRepository extends CrudRepository<Drought, Long> {

}
