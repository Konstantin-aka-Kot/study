package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable{
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        AtomicInteger i = new AtomicInteger(0);
            try {
                while (true) {
                    map.put(String.valueOf(i.incrementAndGet()), "Some text for " + i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " thread was terminated");
            }

    }
}
