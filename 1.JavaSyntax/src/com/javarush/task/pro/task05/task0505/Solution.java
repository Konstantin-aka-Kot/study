package com.javarush.task.pro.task05.task0505;

import java.util.Scanner;

/* 
Reverse
*/

public class Solution {
    public static void main(String[] args) {
        Scanner asd = new Scanner(System.in);
        int n = asd.nextInt();
        if (n>0) {
            int[] mas = new int[n];
            for (int i = 0; i < n; i++) {
                int s = asd.nextInt();
                mas[i] = s;
            }
            if (n % 2 == 0) {
                for (int i = n -1; i >= 0; i--) {
                    System.out.println(mas[i]);
                }
            } else {
                for (int i = 0; i <= n; i++) {
                    System.out.println(mas[i]);
                }
            }
        }
    }
}
