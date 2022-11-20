package com.javarush.task.task18.task1817;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
    float spaceCount = 0;
    float count = 0;
    while (reader.ready()) {
        String next = String.valueOf((char) reader.read());
        count++;
        if (next.equals(" ")) spaceCount++;
    }
    float result = spaceCount / count * 100;
    System.out.format("%.2f",result);
} catch (IOException e) {
    throw new RuntimeException(e);
}
    }
}
