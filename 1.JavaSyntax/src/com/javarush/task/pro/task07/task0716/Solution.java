package com.javarush.task.pro.task07.task0716;

/* 
Запуск систем корабля
*/

import java.util.Arrays;

public class Solution {
    public static char[] chars = {1076, 1086, 1088, 1084, 1080, 1053};

    public static void main(String[] args) {
    /*    for (int i = 0; i < chars.length / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = tmp;
        }
        System.out.println(Arrays.to
*/
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[chars.length - i - 1]);
        }
    }
}
