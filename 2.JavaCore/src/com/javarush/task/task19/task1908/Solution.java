package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader consol = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader br = new BufferedReader(new FileReader(consol.readLine()));
        BufferedWriter bw = new BufferedWriter(new FileWriter(consol.readLine()))){
            Pattern pattern = Pattern.compile("^\\d+$");
            while (br.ready()){
                String[] line = br.readLine().split(" ");
                for (String s : line){
                    Matcher matcher = pattern.matcher(s);
                    while (matcher.find()){
                        bw.write(matcher.group() + " ");
                    }
                }
            }
        }
    }
}
