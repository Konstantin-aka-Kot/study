package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.Scanner;/*
Округление чисел
*/

public class Solution {
    public static void main(String[] args) {
try (Scanner scanner = new Scanner(System.in);
     BufferedReader reader = new BufferedReader(new FileReader(scanner.nextLine()));
     BufferedWriter writer = new BufferedWriter(new FileWriter(scanner.nextLine()))){
        String[] numbers;
        StringBuilder sb = new StringBuilder();
        while (reader.ready()) {
            numbers = reader.readLine().split(" ");
            for (String s : numbers) {
                try {
                    sb.append(Math.round(Double.parseDouble(s)) + " ");
                } catch (NumberFormatException e) {
                    sb.append(s).append(" ");
                }
            }
        }
        writer.write(sb.toString());
     } catch (IOException e) {
    throw new RuntimeException(e);
}
    }
}
