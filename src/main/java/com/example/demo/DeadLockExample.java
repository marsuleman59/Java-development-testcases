package com.example.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DeadLockExample {

    private  DeadLockExample lock;

    public void setLock(DeadLockExample lock){
        this.lock = lock;
    }

    public synchronized void  moveBack(){
        try {
        System.out.println("You move back"+ Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock){
            System.out.println("inside lock" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        DeadLockExample lock1 = new DeadLockExample();
        DeadLockExample lock2 = new DeadLockExample();

        lock1.setLock(lock2);
        lock2.setLock(lock1);

        executorService.submit(lock1::moveBack);
        executorService.submit(lock2::moveBack);
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
