package com.weather.web.dto;

public class RainPeriodsDTO {

    private int anios;
    private String periodosLluvia;
    private int periodAnalyzed;

    public RainPeriodsDTO(Long anios, int periodAnalyzed) {
        this.anios = periodAnalyzed;
        this.periodosLluvia = ""+anios*periodAnalyzed;
    }

    public int getAnios() {
        return anios;
    }

    public void setAnios(int anios) {
        this.anios = anios;
    }

    public String getPeriodosLluvia() {
        return periodosLluvia;
    }

    public void setPeriodosLluvia(String periodosLluvia) {
        this.periodosLluvia = periodosLluvia;
    }
}
