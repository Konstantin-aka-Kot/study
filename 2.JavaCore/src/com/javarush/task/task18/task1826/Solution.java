package com.javarush.task.task18.task1826;

/*
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(args[1]);
             FileOutputStream fos = new FileOutputStream(args[2])){
            if (args[0].equals("-e")) {
                while (fis.available() > 0) {
                    fos.write(fis.read() + 1);
                }
            } else if (args[0].equals("-d")) {
                while (fis.available() > 0){
                    fos.write(fis.read() - 1);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
