package com.sharmarajdaksh;

public class Porsche extends Car {
    private String madeIn;

    public Porsche(int doors, int wheels, String model, String engine, String color, String madeIn) {
        super(doors, wheels, model, engine, color);
        this.madeIn = madeIn;
    }

    @Override
    public int getDoors() {
        // Overridde base class method
        return 2;
    }
}
