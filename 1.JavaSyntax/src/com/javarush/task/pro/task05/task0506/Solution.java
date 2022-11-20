package com.javarush.task.pro.task05.task0506;

import java.util.Scanner;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static int[] array;

    public static void main(String[] args) throws Exception {
        Scanner asd = new Scanner(System.in);
        int n = asd.nextInt();
        array = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int s = asd.nextInt();
            array[i] = s;
            if (s < min) {
            min = s;
            }
        }
        System.out.println(min);

    }
}
