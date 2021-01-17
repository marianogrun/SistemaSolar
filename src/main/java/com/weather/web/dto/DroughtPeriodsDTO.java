package com.weather.web.dto;

public class DroughtPeriodsDTO {

    private int anios;
    private String periodosSequia;
    private int periodAnalyzed;

    public DroughtPeriodsDTO(Long anios, int periodAnalyzed) {
        this.anios = periodAnalyzed;
        this.periodosSequia = ""+anios*periodAnalyzed;
    }

    public int getAnios() {
        return anios;
    }

    public void setAnios(int anios) {
        this.anios = anios;
    }

    public String getPeriodosSequia() {
        return periodosSequia;
    }

    public void setPeriodosSequia(String periodosSequia) {
        this.periodosSequia = periodosSequia;
    }
}
