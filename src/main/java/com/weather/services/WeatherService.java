package com.weather.services;

import com.weather.entities.*;
import com.weather.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class WeatherService {
	
	@Autowired
    WeatherRepository weatherRepository;
    @Autowired
    DroughtRepository droughtRepository;
    @Autowired
    RainRepository rainRepository;
    @Autowired
    OptimalConditionsRepository optimalConditionsRepository;
    @Autowired
    IntensityPeakRepository intensityPeakRepository;
    @Autowired
    UndeterminedRepository undeterminedRepository;

    Planet ferengi = new Planet ("Ferengi", 1, 500, 1);
    Planet betasoide = new Planet ("Betasoide", 3, 2000, 1);
    Planet vulcano = new Planet ("Vulcano", 5, 1000, -1);
    private final int year=360;


    public String start(){
        try {
            for (int i = 0; i < year; i++) {
                weatherRepository.save(getWeatherToSave(i));
            }
            return "La base fue cargada correctamente";
        }catch (Exception e){
            throw new RuntimeException("Hubo un problema al intentar cargar la base");
        }
    }

    public Weather getBaseWeather(Integer day){
        List<Weather> weatherCandidates=weatherRepository.findByDay(day%360);

        return weatherCandidates.isEmpty()?null : weatherCandidates.get(0);
    }

    public void deleteAll() {
        weatherRepository.deleteAll();
    }

    public Weather getWeatherToSave(int day){

        GeoFigure geoFigure= new GeoFigure(ferengi.getCoordinate(day),betasoide.getCoordinate(day), vulcano.getCoordinate(day));
        Coordinate sunCoordinate= new Coordinate(0,0);
        GeoFigure geoFigureWithSun= new GeoFigure(ferengi.getCoordinate(day),betasoide.getCoordinate(day),sunCoordinate);
        double [] perimeters;
        double maxPerimeter=0;

        if(isLine(vulcano.getCoordinate(day),geoFigure)){

            if(isLine(sunCoordinate,geoFigureWithSun) || containsCoordinate(vulcano.getCoordinate(day), geoFigure)){
                return new Drought(day, geoFigure.perimeter());
            }
            return new OptimalConditions(day, geoFigure.perimeter());
        }else if(containsCoordinate(sunCoordinate,geoFigure)){
            return new Rain(day, geoFigure.perimeter());

        } else {
            return new Sunny(day, geoFigure.perimeter());
            }

    }

    public boolean containsCoordinate(Coordinate coordinate, GeoFigure geoFigure){
        GeoFigure geoFigure1=new GeoFigure(coordinate,geoFigure.getSecondCoordinate(),geoFigure.getThirdCoordinate());
        GeoFigure geoFigure2=new GeoFigure(geoFigure.getFirstCoordinate(),coordinate,geoFigure.getThirdCoordinate());
        GeoFigure geoFigure3=new GeoFigure(geoFigure.getFirstCoordinate(),geoFigure.getSecondCoordinate(),coordinate);


        return geoFigure1.getArea()+geoFigure2.getArea()+geoFigure3.getArea()==geoFigure.getArea();
    }

    public boolean isLine(Coordinate coordinate, GeoFigure geoFigure){
        GeoFigure geoFigure1=new GeoFigure(coordinate,geoFigure.getSecondCoordinate(),geoFigure.getThirdCoordinate());
        GeoFigure geoFigure2=new GeoFigure(geoFigure.getFirstCoordinate(),coordinate,geoFigure.getThirdCoordinate());
        GeoFigure geoFigure3=new GeoFigure(geoFigure.getFirstCoordinate(),geoFigure.getSecondCoordinate(),coordinate);


        return geoFigure1.perimeter()+geoFigure2.perimeter()==geoFigure3.perimeter();
    }

//    public boolean isLineWithSunInIt(Coordinate coordinate, GeoFigure geoFigure){
//
//    }

    public int intensityPeak(){
            double maxPerimeter=weatherRepository.findFirstByOrderByPerimeterDesc().getPerimeter();
            System.out.println(""+maxPerimeter);
            List<Weather> maxPerimeterWeathers= weatherRepository.findByPerimeter(maxPerimeter);
            System.out.println(""+maxPerimeterWeathers.get(0).getPerimeter()+""+maxPerimeterWeathers.size());
            for(int i=0; i<maxPerimeterWeathers.size();i++){
                Weather weather=maxPerimeterWeathers.get(i);
//                IntensityPeak intensityPeak= new IntensityPeak(weather.getDay(),weather.getPerimeter());
//                weatherRepository.save(intensityPeak);
                weather.setType("INTENSITY_PEAK");
                System.out.println(""+weather.getType());

                weatherRepository.save(weather);
            }

            return maxPerimeterWeathers.size();

    }

    public Long getRainPeriods(List<Weather> weathers){
        Long rainWeatherCounter=0L;
        boolean distinctRain=true;

        for(int i=0;i<weathers.size();i++){
            if(weathers.get(i).getType().equals("RAIN")&&distinctRain==true){
                rainWeatherCounter++;
                distinctRain=false;
            }

            if(!weathers.get(i).getType().equals("RAIN")){
                distinctRain=true;
            }
        }

        return rainWeatherCounter;
    }

    public int getOptimalPeriods(List<Weather> weathers){
        int optimalWeatherCounter=0;
        boolean distinctOptimal=true;

        for(int i=0;i<weathers.size();i++){
            if(weathers.get(i).getType().equals("OPTIMAL_CONDITIONS")&&distinctOptimal==true){
                optimalWeatherCounter++;
                distinctOptimal=false;
            }

            if(!weathers.get(i).getType().equals("OPTIMAL_CONDITIONS")){
                distinctOptimal=true;
            }
        }

        return optimalWeatherCounter;
    }

}

