package com.weather.repositories;

import com.weather.entities.IntensityPeak;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntensityPeakRepository extends CrudRepository<IntensityPeak, Long> {

}
