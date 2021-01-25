package com.weather.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.weather.entities.Weather;
import java.util.List;

@Repository
public interface WeatherRepository extends PagingAndSortingRepository<Weather, Long> {

    public List<Weather> findByDay(Integer day);

    public List<Weather> findByType(String type);

    public List<Weather> findByPerimeter(double perimeter);

    public Weather findFirstByOrderByPerimeterDesc();
}
