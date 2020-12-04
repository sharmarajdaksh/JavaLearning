package com.sharmarajdaksh;

public class Car {
    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String color;

    // Class composition: "Has-A" relationship
    private Manufacturer manufacturer;

    public Car(int doors, int wheels, String model, String engine, String color) {
        this.doors = doors;
        this.wheels = wheels;
        this.model = model;
        this.engine = engine;
        this.color = color;
    }

    public Car() {
        this(4, 4, "Maruti", "V5", "navy");
    }

    public int getDoors() {
        return this.doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
