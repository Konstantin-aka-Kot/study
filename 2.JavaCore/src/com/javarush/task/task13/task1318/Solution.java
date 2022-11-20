package com.javarush.task.task13.task1318;

import java.io.BufferedReader;/*
Чтение файла
*/
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String path = br.readLine();
        FileInputStream fis = new FileInputStream(path);

        Scanner sc = new Scanner(fis);
        StringBuilder sb = new StringBuilder();

        while (sc.hasNextLine()) {
            sb.append(sc.nextLine()).append("\n");
        }
        System.out.print(sb.toString());

        sc.close();
        br.close();
    }
}