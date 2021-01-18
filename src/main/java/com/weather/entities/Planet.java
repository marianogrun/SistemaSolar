package com.weather.entities;

public class Planet {

    private String name;
    private int speed;
    private float radius;
    private int direction;

    public Planet(String name, int speed, float radius, int direction) {
        this.name = name;
        this.speed = speed;
        this.radius= radius;
        this.direction=direction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Coordinate getCoordinate(int day){
        double gradesPosition = Math.toRadians((day*this.speed*this.direction)%360);

        double x= Math.cos(gradesPosition)*this.radius;
        double y= Math.sin(gradesPosition)*this.radius;

        return new Coordinate (x,y);
    }
}
