package com.weather.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.weather.entities.Rain;

@Repository
public interface RainRepository extends CrudRepository<Rain,Long> {

}
