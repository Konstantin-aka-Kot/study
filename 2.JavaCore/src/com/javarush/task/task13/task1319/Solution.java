package com.javarush.task.task13.task1319;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()))) {

            while (true) {
                String line = reader.readLine();
                writer.write(line + "\n");
                if (line.equals("exit")) {break;}
            }
        }
    }
}
