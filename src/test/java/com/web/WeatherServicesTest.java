package com.web;


import com.weather.config.WeatherApplication;
import com.weather.entities.Drought;
import com.weather.repositories.DroughtRepository;
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
    public void testCreateWeatherFindByDay(){
        Drought drought=new Drought(0);

        drought.setType("Drought");
        weatherRepository.save(drought);

        assertEquals("Drought",weatherRepository.findByDay(0).get(0).getType());
    }

//    @Test
//    public void testCreateWeatherFindByType(){
//        Drought drought=new Drought(0);
//
//        drought.setType("Drought");
//        weatherRepository.save(drought);
//        int num=0;
//
//        assertEquals(Long.valueOf(num),weatherRepository("Drought").get(0).getDay());
//    }
}
