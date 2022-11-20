package com.javarush.task.pro.task05.task0516;

import java.util.Arrays;

/* 
Заполняем массив
*/

public class Solution {

    public static int[] array = new int[20];
    public static int valueStart = 10;
    public static int valueEnd = 13;

    public static void main(String[] args) {
        int w = array.length;
        if (w % 2 == 0) {
            Arrays.fill(array, 0, w/2, valueStart);
            Arrays.fill(array,w/2, w, valueEnd);
        } else {
            Arrays.fill(array, 0, w/2 + 1, valueStart);
            Arrays.fill(array, w/2 + 1, w, valueEnd);
        }
        System.out.println(Arrays.toString(array));
    }
}
