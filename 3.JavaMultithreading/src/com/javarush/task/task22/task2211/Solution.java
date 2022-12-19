package com.javarush.task.task22.task2211;

import java.io.*;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (FileInputStream win1251 = new FileInputStream(args[0]);
             FileOutputStream utf8 = new FileOutputStream(args[1])) {

                byte[] buffer = new byte[win1251.available()];
                win1251.read(buffer);
                String s = new String(buffer, "Windows-1251");
                buffer = s.getBytes("UTF-8");
                utf8.write(buffer);
        }
    }
}
