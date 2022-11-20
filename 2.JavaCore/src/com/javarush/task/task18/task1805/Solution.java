package com.javarush.task.task18.task1805;

import java.io.FileInputStream;
import java.util.Scanner;/*
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in);
             FileInputStream fis = new FileInputStream(scanner.nextLine())) {
            long[] arr = new long[256];
            while (fis.available() > 0) arr[fis.read()]++;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) sb.append(i).append(" ");
            }
            System.out.print(sb.toString());
        }
    }
}
