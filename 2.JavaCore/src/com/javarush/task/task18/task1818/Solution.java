package com.javarush.task.task18.task1818;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
String path1;
String path2;
String path3;
try (Scanner scanner = new Scanner(System.in);
     BufferedWriter writer1 = new BufferedWriter(new FileWriter(path1 = scanner.nextLine(), true));
     BufferedReader reader2 = new BufferedReader(new FileReader(path2 = scanner.nextLine()));
     BufferedReader reader3 = new BufferedReader(new FileReader(path3 = scanner.nextLine()));) {
    while (reader2.ready()) {
        writer1.write(reader2.readLine());
    }
    while (reader3.ready()) {
        writer1.write(reader3.readLine());
    }
} catch (IOException e) {
    throw new RuntimeException(e);
}
    }
}
