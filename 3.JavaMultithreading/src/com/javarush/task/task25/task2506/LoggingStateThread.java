package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        super.run();
        Thread.State state = thread.getState();
        System.out.println(state);
        while (true) {
            Thread.State state1 = thread.getState();
            if (state1 != state) {
                System.out.println(state1);
                state = state1;
            }
            if (state1 == State.TERMINATED) break;
        }
        this.interrupt();
    }
}
