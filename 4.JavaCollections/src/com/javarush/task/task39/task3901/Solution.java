package com.javarush.task.task39.task3901;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 
Уникальные подстроки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null) return 0;
        Set<Character> result = new HashSet<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (result.contains(s.charAt(i)) && result.size() > max){
                max = result.size();
                result.clear();
            } else if (result.contains(s.charAt(i)) && result.size() < max) {
                result.clear();
            }
            result.add(s.charAt(i));
        }
        return Math.max(max, result.size());
    }
}
