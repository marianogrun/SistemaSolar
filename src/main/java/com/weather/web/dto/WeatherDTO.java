package com.weather.web.dto;

import com.weather.entities.Weather;

public class WeatherDTO {

    private int dia;
    private String clima;

    public WeatherDTO(Weather weather, int day) {
        this.dia = day;
        switch (weather.getType()){
            case "DROUGHT": clima="sequía";
            break;
            case "OPTIMAL_CONDITIONS": clima="condiciones óptimas";
            break;
            case "RAIN": clima="lluvia";
            break;
            case "INTENSITY_PEAK": clima= "pico de intensidad";
            break;
            default: clima="indeterminado";

        }
    }

    public int getDia() {
        return dia;
    }

    private void setDia(int dia) {
        this.dia = dia;
    }

    public String getClima() {
        return clima;
    }

    private void setClima(String clima) {
        this.clima = clima;
    }
}
