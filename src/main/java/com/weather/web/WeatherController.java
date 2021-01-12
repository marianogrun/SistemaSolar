package com.weather.web;

import com.weather.entities.Weather;
import com.weather.repositories.WeatherRepository;
import com.weather.services.model.WeatherValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weather.services.WeatherService;

@RestController
public class WeatherController {
	
	@Autowired
    private WeatherService weatherService;
    @Autowired
    private WeatherRepository weatherRepository;
//    @PostMapping("/mutant")
//    public Boolean create(@RequestBody Weather proposedMutant) throws ForbiddenException {
//    	Boolean isMutant = weatherService.saveAsMutant(proposedMutant);
//
//        if (!isMutant){
//            throw new ForbiddenException("NOT A MUTANT");
//        }
//        return true;
//
//    	/*String[] dna = proposedMutant.getDna();
//        boolean isMutant = mutantsService.isMutant(dna);
//        if (isMutant){
//            return MutantsService.isMutant(dna);
//        }else{
//            throw new ForbiddenException();
//        }*/
//    }
    
//    @GetMapping("/stats")
//    public MutantStats stats() {
//        return weatherService.getMutantStats();
//    }

    @GetMapping("/start")
    public void start() {
        weatherService.start();
    }

    @GetMapping("/weather")
    public Weather weather(@RequestParam (value="dayNumber") Integer dayNumber) {
        return weatherService.weather(dayNumber);
    }



    @GetMapping("/reboot")
    public void reboot() {
        weatherService.deleteAll();
    }

}
