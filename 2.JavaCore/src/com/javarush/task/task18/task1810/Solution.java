package com.javarush.task.task18.task1810;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            FileInputStream fis;
            boolean s = true;
            while (s) {
                fis = new FileInputStream(scanner.nextLine());
                if (fis.getChannel().size() < 1000) {
                    s = false;
                    fis.close();
                    throw new DownloadException();
                }

            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
