package com.javarush.task.task19.task1907;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            try (BufferedReader reader = new BufferedReader(new FileReader(br.readLine()))){
                Pattern pattern = Pattern.compile("\\bworld\\b");
                while (reader.ready()){
                String s = reader.readLine();
                Matcher matcher = pattern.matcher(s);
                System.out.println(matcher.results().count());
                }
            }
        }
    }
}
