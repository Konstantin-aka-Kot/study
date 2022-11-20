package com.javarush.task.pro.task06.task0609;

/* 
Кубический калькулятор в кубе
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long x = s.nextLong();
        long y = ninthDegree(x);
        System.out.println(y);
    }

    public static long cube(long a){
        return a*a*a;
    }

    public static long ninthDegree(long a) {
        long x = cube(a);
        return cube(x);
    }
}
