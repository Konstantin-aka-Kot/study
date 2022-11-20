package com.javarush.task.task18.task1816;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                String next = String.valueOf((char) reader.read());
                if (next.matches("[a-zA-Z]")) count++;
            }
            System.out.println(count);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
