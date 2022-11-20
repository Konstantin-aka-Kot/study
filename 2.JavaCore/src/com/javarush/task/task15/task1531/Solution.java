package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();
        long start = System.currentTimeMillis();
        System.out.println(factorial(input));
        long finish = System.currentTimeMillis();
        long time = finish - start;
        System.out.println(time);

    }

    public static String factorial(int n) {
        BigInteger x;
        if (n < 0) {x = new BigInteger("0") ;}
        else if (n == 0) {x = new BigInteger("1");}
        else {
            x = new BigInteger("1");
            for (long i = 2; i <= n; i++) {
                x = x.multiply(BigInteger.valueOf(i));
            }
        }
        return x.toString();
    }
}
