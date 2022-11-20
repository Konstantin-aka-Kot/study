package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))){
            while (reader.ready()){
                String next = reader.readLine();
                Matcher matcher = Pattern.compile("\\b\\S*\\d+\\S*\\b").matcher(next);
                while (matcher.find()){
                    writer.write(matcher.group() + " ");
                }
            }
        }
    }
}
