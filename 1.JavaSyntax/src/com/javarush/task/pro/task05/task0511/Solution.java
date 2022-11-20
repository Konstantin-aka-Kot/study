package com.javarush.task.pro.task05.task0511;

import java.util.Scanner;
import java.util.stream.StreamSupport;

/* 
Создаем двумерный массив
*/

public class Solution {
    public static int[][] multiArray;

    public static void main(String[] args) {
        Scanner consol = new Scanner(System.in);
        int i = consol.nextInt();
        multiArray = new int[i][];
        for (int j = 0; j < i; j++) {
           multiArray[j] = new int[consol.nextInt()];
        }

        for (int j = 0; j < multiArray.length; j++) {
            for (int k = 0; k < multiArray[j].length; k++) {
                System.out.print(multiArray[j][k] + " ");
            }
            System.out.println();
        }
    }
}
