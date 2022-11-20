package com.javarush.task.task18.task1827;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;/*
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) return;
            switch (args[0]) {
                case "-c" :
                    String path;
                    try (Scanner scanner = new Scanner(System.in);
                         FileReader fileReader = new FileReader(path = scanner.nextLine());
                         BufferedReader reader = new BufferedReader(fileReader);
                         BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
                        int max = 0;
                        while (reader.ready()) {
                            String s = reader.readLine().substring(0, 8).trim();
                            int i = Integer.parseInt(s);
                            if (i > max) max = i;
                        }
                        max++;
                        String maxId = String.format("\n%-8s", String.valueOf(max));
                        String name = String.format("%-30s", args[1]);
                        String price = String.format("%-8s", args[2]);
                        String quantity = String.format("%-4s", args[3]);
                        writer.write(maxId+name+price+quantity);
                        break;
                    }
            }

    }
}
