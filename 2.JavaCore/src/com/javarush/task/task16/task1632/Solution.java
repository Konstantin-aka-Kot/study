package com.javarush.task.task16.task1632;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    
    static {
        threads.add(new example1());
        threads.add(new example2());
        threads.add(new example3());
        threads.add(new example4());
        threads.add(new example5());
    }

    public static void main(String[] args) {
    }

    public static class example1 extends Thread{
        @Override
        public void run() {
            while (true){}
        }
    }
    public static class example2 extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }
    public static class example3 extends Thread{
        @Override
        public void run() {
            while (true) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static class example4 extends Thread implements Message {
        @Override
        public void run() {
            while (!isInterrupted()) {
            }
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }
    public static class example5 extends Thread{
        @Override
        public void run() {
            int sum = 0;
            Scanner scanner = new Scanner(System.in);
            while (true) {
                try {
                    String s = scanner.nextLine();
                    if (s.equals("N")){
                        break;
                    }
                    sum += Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(sum);
            }
        }
    }
}