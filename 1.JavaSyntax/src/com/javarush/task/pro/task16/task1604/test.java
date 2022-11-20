package com.javarush.task.pro.task16.task1604;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class test {
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(1995, 02,26);
        System.out.println(calendar.getTime());
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));

    }
}
