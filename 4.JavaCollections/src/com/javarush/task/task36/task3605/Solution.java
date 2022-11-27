package com.javarush.task.task36.task3605;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<Character> result = new TreeSet<>();
            for (byte bts : Files.readAllBytes(Paths.get(args[0]))){
                if (Character.isLetter((char) bts)){
                    char next = (char) Character.toLowerCase(bts);
                    result.add(next);
                }
            }
        result.stream().limit(5).forEach(System.out::print);
    }
}
