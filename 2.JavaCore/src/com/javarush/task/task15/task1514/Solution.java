package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(1.2, "da");
        labels.put(1.3, "qa");
        labels.put(1.4, "wa");
        labels.put(1.5, "ea");
        labels.put(1.6, "ra");
    }
    public static void main(String[] args) {
        System.out.println(labels);
    }
}
