package com.javarush.task.task18.task1808;

import java.io.*;
import java.util.Scanner;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             FileInputStream fis1 = new FileInputStream(scanner.nextLine());
             FileOutputStream fos2 = new FileOutputStream(scanner.nextLine());
             FileOutputStream fos3 = new FileOutputStream(scanner.nextLine());) {
    byte[] buffer = new byte[fis1.available()];
    int count = fis1.read(buffer);
    if (count%2 == 0) {
        fos2.write(buffer, 0, count/2);
        fos3.write(buffer, count/2, count/2);
    } else {
        fos2.write(buffer, 0, count/2 + 1);
        fos3.write(buffer, count/2 + 1, count/2);
    }

} catch (IOException e) {
    throw new RuntimeException(e);
}
    }
}
