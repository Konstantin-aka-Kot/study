package com.javarush.task.task18.task1809;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {
try (Scanner scanner = new Scanner(System.in);
FileInputStream fis = new FileInputStream(scanner.nextLine());
FileOutputStream fos = new FileOutputStream(scanner.nextLine())) {
    byte[] buffer = new byte[fis.available()];
    int i = 0;
    int j = fis.read(buffer) - 1;
    byte tmp;
    while (j > i) {
        tmp = buffer[j];
        buffer[j] = buffer[i];
        buffer[i] = tmp;
        j--;
        i++;
    }
    fos.write(buffer);
} catch (IOException e) {
    throw new RuntimeException(e);
}
    }
}
