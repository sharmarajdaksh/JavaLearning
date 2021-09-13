package com.sharmarajdaksh;

public class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from another thread!");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("I, another thread, stand interrupted");
            return;
        }

        System.out.println("Three seconds passed and now I am awake");
    }
}
