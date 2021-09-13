package com.sharmarajdaksh;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {

    public static final String EOF = "EOF";

    public static void main(String[] args) {
        // write your code here
        List<String> buffer = new ArrayList<>();

        // Thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(3);


        MyProducer producer = new MyProducer(buffer, "producer ");
        MyConsumer consumer1 = new MyConsumer(buffer, "consumer1 ");
        MyConsumer consumer2 = new MyConsumer(buffer, "consumer2 ");

        //        new Thread(producer).start();
        //        new Thread(consumer1).start();
        //        new Thread(consumer2).start();
        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Running callable");
                return "This is a callable result";
            }
        });

        try {
            System.out.println(future.get());
        } catch(ExecutionException e) {
            System.out.println("Something went wrong");
        } catch(InterruptedException e) {
            System.out.printf("Thread was interrupted");
        }

        // Waits for threads to terminate before shutting down
        executorService.shutdown();
        // executorService.shutdownNow(); will not wait, and try to shut down asap
    }
}

class MyProducer implements Runnable {
    private final List<String> buffer;
    private final String color;

    public MyProducer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);
                synchronized (buffer) {
                    buffer.add(num);
                }
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println("Adding EOF to buffer and exiting");

        synchronized (buffer) {
            buffer.add("EOF");
        }
    }
}

class MyConsumer implements Runnable {
    private final List<String> buffer;
    private final String color;

    public MyConsumer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        while (true) {

            // Synchronized blocks are okay
            // But the better, recommended method is to use Lock classes
            // Such as the ReentrantLock
            synchronized (buffer) {
                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.get(0).equals(Main.EOF)) {
                    System.out.println("Exiting");
                    break;
                } else {
                    System.out.println(color + "Removed..." + buffer.remove(0));
                }
            }
        }
    }
}