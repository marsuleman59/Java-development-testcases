package com.example.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreading {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for(int i=0; i < 5; i++)
            try {
                System.out.println("Executors.newCachedThreadPool() Runnable Thread started:: "+i+ "::" + Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        ExecutorService executorService = Executors.newCachedThreadPool();

        // Three ways to initiate a runnable
        executorService.submit(runnable);
        CompletableFuture.runAsync(runnable);
        Thread thread1 = new Thread(runnable);

        for(int i=0; i < 5; i++)
            try {
                System.out.println("Main Thread started:: "+i + ":" + Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//        executorService.shutdown();

            Thread thread = new Thread();


        executorService.submit(() -> System.out.println("Callable Executor service"));
        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> " CompletableFuture.supplyAsync service");
        try {
            System.out.println(supplyAsync.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

