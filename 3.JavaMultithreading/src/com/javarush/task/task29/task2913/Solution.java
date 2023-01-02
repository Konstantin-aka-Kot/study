package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder sb = new StringBuilder();
        if (a < b) { // 50 < 100
            while (a <= b) {
                sb.append(a).append(" ");
                a++;
            }
        } else if (a > b) {
            while (a >= b) {
                sb.append(a).append(" ");
                a--;
            }
        } else sb.append(a);
        return sb.toString().trim();
//        if (a > b) {
//            return a + " " + recursion(a - 1, b);
//        } else {
//            if (a == b) {
//                return Integer.toString(a);
//            }
//            return a + " " + recursion(a + 1, b);
//        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}