package com.javarush.task.task19.task1925;

import java.io.*;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))){
            StringBuilder sb = new StringBuilder();
            StringBuilder res = new StringBuilder();
    while (reader.ready()){
                sb.append(reader.readLine() + " ");
            }
            String[] result = sb.toString().split(" ");
    for (String s : result){
        if (s.length() > 6){
            res.append(s + ",");
        }
    }
    writer.write(res.toString().replaceAll(",$", ""));
        }
    }
}
