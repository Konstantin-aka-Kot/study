package com.javarush.task.task19.task1910;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try(BufferedReader consol = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader(consol.readLine()));
        BufferedWriter bw = new BufferedWriter(new FileWriter(consol.readLine()))){
            while (br.ready()){
                String line = br.readLine().replaceAll("\\p{Punct}", "");
                bw.write(line);
            }
        }
    }
}
