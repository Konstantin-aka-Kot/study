package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String path;
        BufferedReader reader = new BufferedReader(new FileReader(path = scanner.nextLine()));
        ArrayList<String> list = new ArrayList<>();
        while (reader.ready()){
            list.add(reader.readLine());
        }
        reader.close();
        BufferedReader reader1 = new BufferedReader(new FileReader(scanner.nextLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        scanner.close();
        while (reader1.ready()){
            writer.write(reader1.readLine() + "\n");
        }
        reader1.close();
        for (int i = 0; i < list.size(); i++) {
            writer.write(list.get(i));
            if (i != list.size() - 1) writer.write("\n");
        }
        writer.close();
    }
}
