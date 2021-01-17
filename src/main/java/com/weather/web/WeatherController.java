package com.weather.web;

import com.weather.entities.Weather;
import com.weather.repositories.DroughtRepository;
import com.weather.repositories.WeatherRepository;
import com.weather.web.dto.WeatherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weather.services.WeatherService;

@RestController
public class WeatherController {
	
	@Autowired
    private WeatherService weatherService;
    @Autowired
    private WeatherRepository weatherRepository;
    @Autowired
    private DroughtRepository droughtRepository;

    private final int periodAnalyzed=10;

    @GetMapping("/build-DB")
    public void start() {
        weatherService.start();
    }

    @GetMapping(path = "/clima", produces= MediaType.APPLICATION_JSON_VALUE)
    public WeatherDTO weather(@RequestParam (value="dia") Integer day) throws NotFoundException {

        Weather weather=weatherService.getBaseWeather(day);

        if(weather==null){
            throw new NotFoundException("No se encontró clima para el día específicado. Pruebe generar base de datos. '/build-DB'");
        }

        return new WeatherDTO(weather,day);
    }

    @GetMapping("/drought-periods")
    public String droghtPeriods() {
        long droughtPeriods= droughtRepository.count();

        return "Períodos de sequía en 10 años: "+droughtPeriods* periodAnalyzed;
    }

    @GetMapping("/intensity-peaks")
    public String intensityPeaks() {
        int intensity_peaks=weatherService.intensityPeak() ;

        return "Períodos de intensidad en 10 años: "+intensity_peaks* periodAnalyzed;
    }



    @GetMapping("/reboot")
    public void reboot() {
        weatherService.deleteAll();
    }

}
