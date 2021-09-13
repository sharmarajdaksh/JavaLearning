package com.sharmarajdaksh;

//
// One way of running a Thread is a class extending Thread
// Another way is to make a class implement the Runnable interface
// In general, implementing the Runnable interface is the more popular and versatile approach,
// especially when working with Lambda expressions
//
// Remember that start() should be called to start new threads.
// Calling run() directly will make the code run in the same thread.
//

public class Main {

    public static void main(String[] args) {
        System.out.println("Hi, I'm from the main thread!");

        // AnotherThread extends Thread
        Thread thread = new AnotherThread();
        thread.start();

        new Thread() {
            public void run() {
                System.out.println("Hello from anonymous class");
            }
        }.start();

        Thread myRunnable = new Thread(new MyRunnable());
        myRunnable.start();

       Thread myAnonymousRunnable = new Thread(new MyRunnable() {
           @Override
           public void run() {
               System.out.println("I am the anonymous runnable!");
               try {
                   thread.join(); // Wait until "thread" has terminated
                   // thread.join(2000); // Wait until thread terminates OR the timeout passes, whichever happens first
               } catch(InterruptedException e) {
                   System.out.println("I was interrupted aooo!");
               }
               System.out.println("Phew, I'm done");
           }
       });

       myAnonymousRunnable.start();
       thread.interrupt(); // Interrupt the thread
        // wakes up a sleeping thread
        // Caught and handled as a InterruptedException

        System.out.println("Hello again from the main thread");

        // Joining threads:
        // Threads, when joined, wait for the other threads to terminate before continuing
    }
}
