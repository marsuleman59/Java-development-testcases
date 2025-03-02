package com.example.demo.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreaded {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();


        executorService.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 1: " + i);
            }
        });

    }


    static class MyThread implements Runnable{

        @Override
        public void run() {

            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 1: " + i);
            }

        }
    }
}
