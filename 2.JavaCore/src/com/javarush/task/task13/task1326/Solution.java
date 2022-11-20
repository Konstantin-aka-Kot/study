package com.javarush.task.task13.task1326;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in);
             FileInputStream fis = new FileInputStream(scanner.nextLine());
             Scanner scanner2 = new Scanner(fis);) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            while (scanner2.hasNextInt()) {
                int tmp = scanner2.nextInt();
                if (tmp%2 ==0) {
                    list.add(tmp);
                }
            }
            Collections.sort(list);
            for (int a : list) {
                System.out.println(a);
            }
        }

    }
}
