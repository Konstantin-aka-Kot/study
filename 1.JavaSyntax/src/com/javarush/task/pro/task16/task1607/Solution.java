package com.javarush.task.pro.task16.task1607;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

/* 
Освоение нового API
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(nowExample());
        System.out.println(ofExample());
        System.out.println(ofYearDayExample());
        System.out.println(ofEpochDayExample());
    }

    static LocalDate nowExample() {
        LocalDate now = LocalDate.now();

        return now;
    }

    static LocalDate ofExample() {
        LocalDate example = LocalDate.of(2020, 9, 12);

        return example;
    }

    static LocalDate ofYearDayExample() {
        LocalDate ofYearDayExample = LocalDate.ofYearDay(2020, 256);
        return ofYearDayExample;
    }

    static LocalDate ofEpochDayExample() {
        LocalDate start = LocalDate.of(1970, 1, 1);
        LocalDate finish = LocalDate.of(2020, 9, 12);
        long daysBetween = DAYS.between(start, finish);
        LocalDate ofEpochDayExample = LocalDate.ofEpochDay((int) daysBetween);

        return ofEpochDayExample;
    }
}
