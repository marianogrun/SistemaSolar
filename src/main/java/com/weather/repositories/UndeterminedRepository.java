package com.weather.repositories;

import com.weather.entities.Undetermined;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UndeterminedRepository extends CrudRepository<Undetermined, Long> {

}
