package com.javarush.task.pro.task15.task1516;

/*
Файл или директория
*/

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Solution {
    private static final String THIS_IS_FILE = " - это файл";
    private static final String THIS_IS_DIR = " - это директория";

    public static void main(String[] args) {
            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    Path path = Path.of(scanner.nextLine());
                    if (Files.isRegularFile(path)) {
                        System.out.println(path + THIS_IS_FILE);
                        continue;
                    } else if (Files.isDirectory(path)) {
                        System.out.println(path + THIS_IS_DIR);
                        continue;
                    } else {
                        break;
                    }
                }
            }

    }
}

