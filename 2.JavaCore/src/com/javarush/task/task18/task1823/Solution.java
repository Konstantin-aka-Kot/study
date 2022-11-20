package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(System.in)) {
            String name;
            while (!(name = scanner.nextLine()).equals("exit")){
                ReadThread read = new ReadThread(name);
                read.start();
            }
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) throws FileNotFoundException {
            this.fileName = fileName;
        }
        public void run(){

            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
                int[] buffer = new int[256];
                while (reader.ready()) {
                    buffer[reader.read()]++;
                }
                int max = Arrays.stream(buffer).max().orElse(0);
                int maxBite = buffer[Arrays.stream(buffer).max().orElse(0)];
                resultMap.put(fileName, maxBite);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
