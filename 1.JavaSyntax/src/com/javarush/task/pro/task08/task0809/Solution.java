package com.javarush.task.pro.task08.task0809;

/* 
Counter

*/
public class Solution {

    public static void main(String[] args) throws InterruptedException {
        printNumbers();
    }

    public static void printNumbers() throws InterruptedException {
        int[] num = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < num.length - 1; i++) {
            System.out.println(num[i]);
            Thread.sleep(1, 300000);
        }
        System.out.println(num[num.length - 1]);
    }
}
