package com.javarush.task.pro.task13.task1309;

import java.util.HashMap;

/* 
Успеваемость студентов
*/

public class Solution {
    public static HashMap<String, Double> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("Ivanov", 4.2);
        grades.put("Petrov", 3.0);
        grades.put("Sidorov", 2.3);
        grades.put("Kuznetsov", 5.0);
        grades.put("Kekov", 2.2);
    }
}
