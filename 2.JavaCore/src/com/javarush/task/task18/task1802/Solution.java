package com.javarush.task.task18.task1802;

import java.io.FileInputStream;
import java.util.Scanner;/*
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in);
             FileInputStream reader = new FileInputStream(scanner.nextLine())) {
            int min = Integer.MAX_VALUE;
            while (reader.available() > 0) {
                int data = reader.read();
                if (data < min) min = data;
            }
            System.out.println(min);
        }
    }
}
