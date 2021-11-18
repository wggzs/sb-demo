package com.wgg.sb2.controller;

import javafx.concurrent.Worker;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Schedule {
    SynchronousQueue<Runnable> tasks = new SynchronousQueue<>();
    AtomicInteger idCount = new AtomicInteger();
    int maxWorkers;

    public Schedule(int maxWorkers) {
        this.maxWorkers = maxWorkers;
        for (int i = 0; i < maxWorkers; i++) {
            new Thread(new Worker()).start();
        }
    }

    class Worker implements Runnable {
        int id;

        public Worker() {
            this.id = idCount.getAndIncrement();
        }

        @Override
        public void run() {
            while (true) {
                Runnable runnable = null;
                try {
                    runnable = tasks.take();
                    runnable.run();
                    System.out.format("work done by id=%d\n", id);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void submit(Runnable r) throws InterruptedException {
        while (!tasks.offer(r)) {
            Thread.sleep(0);
            new Thread(new Worker()).start();
        }
    }


    public static void main(String[] argv) throws InterruptedException {
        Schedule scheduler = new Schedule(10);

        for(int i = 0; i < 1000; i++) {
            int localI = i;
            Thread.sleep(1);
            scheduler.submit(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
