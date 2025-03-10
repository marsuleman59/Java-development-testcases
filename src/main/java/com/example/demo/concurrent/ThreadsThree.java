package com.example.demo.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsThree {


    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(() -> {
            for (int i = 0; i < 100000; i++) {
                System.out.println(i);
            }
        });

        threadsTwo();
    }












    private static void threadsTwo() {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                System.out.println(i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                System.out.println(i);
            }
        });

        thread1.start();
        thread2.start();

    }
}
