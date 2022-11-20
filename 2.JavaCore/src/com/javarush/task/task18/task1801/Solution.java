package com.javarush.task.task18.task1801;

import java.io.FileInputStream;
import java.util.Scanner;/*
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in);
             FileInputStream reader = new FileInputStream(scanner.nextLine())) {
            int big = Integer.MIN_VALUE;
            while (reader.available() > 0) {
                int data;
                if ((data = reader.read()) > big) {
                big = data;
                }
            }
            System.out.println(big);
        }
    }
}
