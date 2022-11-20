package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader consol = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(consol.readLine()))){
            while (reader.ready()){
                String next = reader.readLine();
                System.out.println(new StringBuilder(next).reverse().toString());
            }
        }
    }
}
