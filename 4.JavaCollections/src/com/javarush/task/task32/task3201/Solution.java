package com.javarush.task.task32.task3201;

/*
Запись в существующий файл
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(args[0], "rw")){
            if (raf.length() > Long.parseLong(args[1])) {
                raf.seek(Long.parseLong(args[1]));
            } else {
                raf.seek(raf.length());
            }
            raf.write(args[2].getBytes());

        }
    }
}
