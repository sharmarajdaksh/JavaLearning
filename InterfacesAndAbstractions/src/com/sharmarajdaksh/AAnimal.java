package com.sharmarajdaksh;

public abstract class AAnimal {
    private final String name;

    public AAnimal(String name) {
        this.name = name;
    }

    public abstract void eat();
    public abstract void breathe();

    // Classes extending from AAnimal must implement the abstract methods.
    // Non-Abstract methods work like they would in normal classes.
    // Abstract classes cannot be instantiated.
}
