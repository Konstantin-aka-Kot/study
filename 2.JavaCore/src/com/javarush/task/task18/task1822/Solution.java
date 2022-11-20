package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             BufferedReader reader = new BufferedReader(new FileReader(scanner.nextLine()))) {
         while (reader.ready()) {
             String s;
             if ((s = reader.readLine()).startsWith(args[0].toString() + " ")){
                 System.out.println(s);
             }
         }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
