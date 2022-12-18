package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null) throw new TooShortStringException();
        Pattern pattern = Pattern.compile("\\S+\\s(\\S+\\s\\S+\\s\\S+\\s\\S+)");
        Matcher matcher = pattern.matcher(string);
        try {
            if (matcher.find()) {
                return matcher.group(1);
            } else {
                throw new TooShortStringException();
            }
        } catch (Exception e) {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
