package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Только по-очереди!
*/

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException, IOException {
        Read3Strings t1 = new Read3Strings();
        t1.start();
        t1.join();
        t1.printResult();
        Read3Strings t2 = new Read3Strings();
        t2.start();
        t2.join();
        t2.printResult();
        reader.close();
    }

    public static class Read3Strings extends Thread {
        private StringBuilder sb = new StringBuilder();
        public void printResult(){
            System.out.println(sb.toString());
        }
        @Override
        public void run() {
            try {
                sb.append(reader.readLine());
                sb.append(" ");
                sb.append(reader.readLine());
                sb.append(" ");
                sb.append(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
