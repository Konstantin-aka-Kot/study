package com.javarush.task.task18.task1821;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
    int[] buffer = new int[256];
    while (reader.ready()) {
        buffer[reader.read()]++;
    }
    for (int i = 0; i < buffer.length; i++) {
        if (buffer[i] != 0){
            System.out.println((char) i + " " + buffer[i]);
        }
    }
} catch (IOException e) {
    throw new RuntimeException(e);
}
    }
}
