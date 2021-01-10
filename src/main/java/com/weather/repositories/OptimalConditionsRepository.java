package com.weather.repositories;

import com.weather.entities.OptimalConditions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptimalConditionsRepository extends CrudRepository<OptimalConditions, Long> {

}
