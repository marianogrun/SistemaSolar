package com.web;


import com.weather.config.WeatherApplication;
import com.weather.entities.Drought;
import com.weather.entities.OptimalConditions;
import com.weather.entities.Rain;
import com.weather.entities.Weather;
import com.weather.repositories.WeatherRepository;
import com.weather.services.WeatherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {WeatherApplication.class})
public class WeatherServicesTest {

    @Autowired
    private WeatherRepository weatherRepository;
    @Autowired
    private WeatherService weatherService;

    @Test
    public void createWeatherFindByDayTest(){
        Drought drought=new Drought(0,1.0);

        drought.setType("Drought");
        weatherRepository.save(drought);

        assertEquals("Drought",weatherRepository.findByDay(0).get(0).getType());
    }

    @Test
    public void createWeatherFindByTypeTest(){
        OptimalConditions optimalConditions=new OptimalConditions(17,1.0);
        Rain rain=new Rain(25, 1.0);

        optimalConditions.setType("OPTIMAL_CONDITIONS");
        weatherRepository.save(optimalConditions);
        Long num1=17L, num2=25L;
        rain.setType("RAIN");
        weatherRepository.save(rain);
        Weather weatherOp=weatherRepository.findByType("OPTIMAL_CONDITIONS").get(0);
        Weather weatherRain=weatherRepository.findByType("RAIN").get(0);


        assertEquals(Long.valueOf(num1),Long.valueOf(weatherOp.getDay()));
        assertEquals("OPTIMAL_CONDITIONS",weatherOp.getType());
        assertEquals(Long.valueOf(num2),Long.valueOf(weatherRain.getDay()));
        assertEquals("RAIN",weatherRain.getType());
    }

}
