package com.weather.services.model;

import com.weather.entities.Weather;

import java.util.List;

public class WeatherValue {

    private Weather weather;
    public WeatherValue (List<Weather> list){
        this.weather=list.get(0);
    }

}
