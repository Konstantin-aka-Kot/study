package com.javarush.task.pro.task08.task0816;

/* 
Приоритеты
*/

public class Solution {

    public static void main(String[] args) {
        int number = 2;
        System.out.println(number + number * (number + ++number));
        // 2 + 2 * 2 + 3
        // 2 + 4 + 3
        // 9
    }

}
