package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String param = url.substring(url.lastIndexOf("?") +1);
        String[] splits = param.split("&");
        String objValue = null;

        StringBuilder sb = new StringBuilder();
        for (String split : splits) {
            String[] splitAndValues = split.split("=");
            sb.append(splitAndValues[0]);
            sb.append(" ");

            if (splitAndValues[0].equals("obj")){
                objValue = splitAndValues[1];
            }
        }
        System.out.println(sb.toString().trim());

        if (objValue != null) {
            try {
                alert(Double.parseDouble(objValue));
            } catch (NumberFormatException e) {
                alert(objValue);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
