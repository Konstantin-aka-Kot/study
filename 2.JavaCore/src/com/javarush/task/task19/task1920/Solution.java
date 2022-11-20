package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
            Map<String, Double> map = new TreeMap<>();
            while (reader.ready()){
                String[] next = reader.readLine().split(" ");
                if (map.containsKey(next[0])){
                    double val = map.get(next[0]);
                    map.put(next[0], val + Double.parseDouble(next[1]));
                } else {
                    map.put(next[0], Double.parseDouble(next[1]));
                }
            }
           double max = Collections.max(map.values());
            for (Map.Entry<String, Double> entry : map.entrySet()){
                if (entry.getValue().equals(max)){
                    System.out.println(entry.getKey());
                }
            }
        }
    }
}
