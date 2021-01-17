package com.weather.entities;

public class GeoFigure {

    private Coordinate firstCoordinate;
    private Coordinate secondCoordinate;
    private Coordinate thirdCoordinate;

    public GeoFigure(Coordinate firstCoordinate, Coordinate secondCoordinate, Coordinate thirdCoordinate) {
        this.firstCoordinate = firstCoordinate;
        this.secondCoordinate = secondCoordinate;
        this.thirdCoordinate = thirdCoordinate;
    }

    public Coordinate getFirstCoordinate() {
        return firstCoordinate;
    }

    public void setFirstCoordinate(Coordinate firstCoordinate) {
        this.firstCoordinate = firstCoordinate;
    }

    public Coordinate getSecondCoordinate() {
        return secondCoordinate;
    }

    public void setSecondCoordinate(Coordinate secondCoordinate) {
        this.secondCoordinate = secondCoordinate;
    }

    public Coordinate getThirdCoordinate() {
        return thirdCoordinate;
    }

    public void setThirdCoordinate(Coordinate thirdCoordinate) {
        this.thirdCoordinate = thirdCoordinate;
    }

    public float getArea(){
        return Math.abs((float)( firstCoordinate.getX() * (secondCoordinate.getY() - thirdCoordinate.getY()) + secondCoordinate.getX() * (thirdCoordinate.getY() - firstCoordinate.getY()) + thirdCoordinate.getX() * (firstCoordinate.getY() - secondCoordinate.getY()))/2);
    }

    public double perimeter(){
        double ab= Math.sqrt(Math.pow(secondCoordinate.getX()-this.firstCoordinate.getX(), 2) + Math.pow(secondCoordinate.getY()-this.firstCoordinate.getY(), 2));
        double bc= Math.sqrt(Math.pow(thirdCoordinate.getX()-this.secondCoordinate.getX(), 2) + Math.pow(thirdCoordinate.getY()-this.secondCoordinate.getY(), 2));
        double ca= Math.sqrt(Math.pow(firstCoordinate.getX()-this.thirdCoordinate.getX(), 2) + Math.pow(firstCoordinate.getY()-this.thirdCoordinate.getY(), 2));

        return ab+bc+ca;
    }
}
