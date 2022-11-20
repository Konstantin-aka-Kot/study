package com.javarush.task.task18.task1804;

/*
Самые редкие байты
*/

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in);
             FileInputStream fis = new FileInputStream(scanner.nextLine())){
            long[] arr = new long[256];
            while (fis.available() > 0) arr[fis.read()]++;
            long min = Long.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < min && arr[i] != 0) min = arr[i];
            }
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] == min) System.out.print(i + " ");
            }
        }
    }
}
