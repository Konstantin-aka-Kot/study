package com.javarush.task.pro.task13.task1320;

public class Solution {

    public static void main(String[] args) {
        System.out.println(getMonthByIndex(4));
        System.out.println(getMonthByIndex(8));
        System.out.println(getMonthByIndex(12));
    }

    public static String getMonthByIndex(int monthIndex) {
        String monthString;
        switch (monthIndex) {
            case 1 :
                monthString = "Январь";
                return monthString;
            case 2 :
                monthString = "Февраль";
                return monthString;
            case 3 :
                monthString = "Март";
                return monthString;
            case 4 :
                monthString = "Апрель";
                return monthString;
            case 5 :
                monthString = "Май";
                return monthString;
            case 6 :
                monthString = "Июнь";
                return monthString;
            case 7 :
                monthString = "Июль";
                return monthString;
            case 8 :
                monthString = "Август";
                return monthString;
            case 9 :
                monthString = "Сентябрь";
                return monthString;
            case 10 :
                monthString = "Октябрь";
                return monthString;
            case 11 :
                monthString = "Ноябрь";
                return monthString;
            case 12 :
                monthString = "Декабрь";
                return monthString;
            default:
                monthString = "Недействительный месяц";
                return monthString;

        }
    }
}
