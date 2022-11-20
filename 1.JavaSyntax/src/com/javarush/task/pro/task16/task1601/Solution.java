package com.javarush.task.pro.task16.task1601;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* 
Лишь бы не в понедельник :)
*/

public class Solution {

    static Date birthDate = new Date(95, Calendar.FEBRUARY, 26);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        Locale rus = new Locale("ru", "RU");
        SimpleDateFormat formater = new SimpleDateFormat("EEEE", rus);
        String result = formater.format(date);

        return result;
    }
}
