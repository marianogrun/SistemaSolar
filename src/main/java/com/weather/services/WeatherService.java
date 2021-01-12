package com.weather.services;

import com.weather.entities.*;
import com.weather.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void start(){

        int numFerengiRel= 360;
        int numBetasoideRel= 360;
        int numVulcanosAntiRel= 0;

        String [] anio= new String[360];

        int periodosSequia=0;
        int periodoObtenido=10;


        for (int j = 0; j < anio.length; j++) {
//                System.out.println(numFerengiRel + " " + numVulcanosAntiRel + " " + numBetasoideRel);


            if (numFerengiRel == 0) {
                numFerengiRel = 360;
            }
            if (numBetasoideRel == 0) {
                numBetasoideRel = 360;
            }
            if (numVulcanosAntiRel == 360) {
                numVulcanosAntiRel = 0;
            }

            if (numFerengiRel == numBetasoideRel && numBetasoideRel == numVulcanosAntiRel) {
                Drought drought= new Drought(j);
                droughtRepository.save(drought);
                periodosSequia++;
            }
            if (numBetasoideRel == numVulcanosAntiRel
                    &&(numVulcanosAntiRel == (numFerengiRel + 180)
                    || numVulcanosAntiRel == (numFerengiRel - 180))) {
                Drought drought= new Drought(j);
                droughtRepository.save(drought);
                periodosSequia++;
            }
            if (numFerengiRel == numBetasoideRel && numBetasoideRel == (numVulcanosAntiRel + 360)) {
                Drought drought= new Drought(j);
                droughtRepository.save(drought);
                periodosSequia++;
            }
            numFerengiRel--;
            numBetasoideRel -= 3;
            numVulcanosAntiRel += 5;

            if (j>15 && j<19 || j>45 && j<49 || j>62 && j<66 || j>115 && j<119 || j>131 && j<135 || j>162 && j<166
                    || j>195 && j<199 || j>225 && j<229 || j>242 && j<246 || j>295 && j<299 || j>311 && j<315 || j>342 && j<346){
                OptimalConditions optimalConditions=new OptimalConditions(j);
                optimalConditionsRepository.save(optimalConditions);
            }
            if (j>22 && j<31 || j>67 && j<90 || j>90 && j<113 || j>149 && j<158 || j>202 && j<211 || j>247 && j<270
                    || j>270 && j<293 || j>329 && j<338){
                Rain rain=new Rain(j);
                rainRepository.save(rain);
            }
//            if (anio[j]==null){
//                Undetermined undetermined=new Undetermined(j);
//                undeterminedRepository.save(undetermined);
//            }

            if (j==105 || j==285) {
                IntensityPeak intensityPeak=new IntensityPeak(j);
                intensityPeakRepository.save(intensityPeak);
            }



        }

//        for(int i =0; i<(365); i++) {
//            System.out.println("" + anio[i] + " " + i);
//        }
        System.out.println("Los periodos de sequia en 10 años fueron:"+periodosSequia);
    }

    public Weather getBaseWeather(Integer day){
        List<Weather> weatherCandidates=weatherRepository.findByDay(day%360);

        return weatherCandidates.isEmpty()?null : weatherCandidates.get(0);
    }

    public void deleteAll() {
        weatherRepository.deleteAll();
    }

}

