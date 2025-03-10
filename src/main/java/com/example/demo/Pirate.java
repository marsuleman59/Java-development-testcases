package com.example.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Pirate {
    private Pirate enemy;
    private void setEnemy(Pirate enemy) {
        this.enemy = enemy;
    }

    private synchronized void moveBack() {
        try {
            System.out.println(Thread.currentThread().getName() + ": I am watching you, you move first!");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized(enemy) {
            System.out.println(Thread.currentThread().getName() + ": I step back");
        }
    }

    public static void main(String... args) throws InterruptedException {
        Pirate pirateA = new Pirate();
        Pirate pirateB = new Pirate();

        pirateA.setEnemy(pirateB);
        pirateB.setEnemy(pirateA);

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.submit(() -> pirateA.moveBack());
        exec.submit(() -> pirateB.moveBack());

        exec.shutdown();
        exec.awaitTermination(10, TimeUnit.DAYS);
    }
}
