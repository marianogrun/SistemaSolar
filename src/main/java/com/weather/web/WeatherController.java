package com.weather.web;

import com.weather.entities.Weather;
import com.weather.repositories.DroughtRepository;
import com.weather.repositories.WeatherRepository;
import com.weather.web.dto.DroughtPeriodsDTO;
import com.weather.web.dto.RainPeriodsDTO;
import com.weather.web.dto.WeatherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weather.services.WeatherService;

import java.util.List;

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
    public String start() {
        String response=weatherService.start();

        return response;
    }

    @GetMapping(path = "/clima", produces= MediaType.APPLICATION_JSON_VALUE)
    public WeatherDTO weather(@RequestParam (value="dia") Integer day) throws NotFoundException {

        Weather weather=weatherService.getBaseWeather(day);

        if(weather==null){
            throw new NotFoundException("No se encontró clima para el día específicado. Pruebe generar base de datos. '/build-DB'");
        }

        return new WeatherDTO(weather,day);
    }

    @GetMapping(path= "/periodos-sequia", produces= MediaType.APPLICATION_JSON_VALUE)
    public DroughtPeriodsDTO droghtPeriods() {
        long droughtPeriods=droughtRepository.count();

        return new DroughtPeriodsDTO(droughtPeriods,periodAnalyzed);
    }

    @GetMapping("/picos-intensidad")
    public String intensityPeaks() {
        int intensity_peaks=weatherService.intensityPeak();
        double maxPerimeter=weatherRepository.findFirstByOrderByPerimeterDesc().getPerimeter();
        List<Weather> intensityPeakDays=weatherRepository.findByPerimeter(maxPerimeter);
        String response="Períodos de tormenta en 10 años: "+intensity_peaks* periodAnalyzed+". Días de pico en cada año: ";
        for(int i=0; i<intensityPeakDays.size();i++){
            response+=""+intensityPeakDays.get(i).getDay()+" ";
        }
        return response;
    }


    @GetMapping("/periodos-lluvia")
    public RainPeriodsDTO rainPeriods() {
        List<Weather> rain_periods= (List<Weather>) weatherRepository.findAll();

        Long rainCounter=weatherService.getRainPeriods(rain_periods);

        return new RainPeriodsDTO(rainCounter,periodAnalyzed);
    }

    @GetMapping("/condiciones-optimas")
    public String optimalConditions() {
        List<Weather> optimal_conditions= (List<Weather>) weatherRepository.findAll();

        int optimalCounter=weatherService.getOptimalPeriods(optimal_conditions);

        return "Períodos de presión óptima en 10 años: "+optimalCounter* periodAnalyzed;
    }


    @GetMapping("/reboot")
    public String reboot() {
        try {
            weatherService.deleteAll();
            return "Fueron borrados todos los campos de la base";
        }catch (Exception e){
            throw new RuntimeException("Problema al intentar borrar la base. Chequear que las columna coincidan");
        }
    }

}
