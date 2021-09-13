package com.sharmarajdaksh;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Countdown countdown = new Countdown();
        CountdownThread t1 = new CountdownThread(countdown);
        CountdownThread t2 = new CountdownThread(countdown);

        t1.start();
        t2.start();
    }
}

class Countdown {
    private int i;

    //
    // When synchronizing, remember to synchronize only the necessary code
    //

    // Using the synchronized keyword avoids race conditions
    // This is one way of synchronizing data access
    // public synchronized void doCountdown() {
    //    for (i = 10; i > 0; i--) {
    //        System.out.println("i = " + i);
    //    }
    //}

    // Another way is to use a shared object, and acquiring/releasing locks
    // Remember to always use SHARED variables rather than local variables to lock
    // Object references can be locked
    public void doCountdown() {
        synchronized (this) {
            // Synchronized block
            for (i = 10; i > 0; i--) {
                System.out.println("i = " + i);
            }
        }
    }
}

class CountdownThread extends Thread {
    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown) {
        threadCountdown = countdown;
    }

    @Override
    public void run() {
        threadCountdown.doCountdown();
    }
}