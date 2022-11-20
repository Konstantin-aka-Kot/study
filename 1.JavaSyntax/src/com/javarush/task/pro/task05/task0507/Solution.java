package com.javarush.task.pro.task05.task0507;

import java.util.Scanner;

/* 
Максимальное из N чисел
*/

public class Solution {
    public static int[] array;

    public static void main(String[] args) throws Exception {
        Scanner asd = new Scanner(System.in);
        int n = asd.nextInt();
        array = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int s = asd.nextInt();
            array[i] = s;
            if (s > max) {
                max = s;
            }
        }
        System.out.println(max);
    }
}
