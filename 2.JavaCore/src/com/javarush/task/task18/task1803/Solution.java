package com.javarush.task.task18.task1803;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in);
             FileInputStream reader = new FileInputStream(scanner.nextLine())) {
            long[] arr = new long[256];
            while (reader.available() > 0) {
                arr[reader.read()]++;
            }
            long max = 0;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] > max) max = arr[i];
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == max) System.out.print(i + " ");
            }

        }
    }
}
