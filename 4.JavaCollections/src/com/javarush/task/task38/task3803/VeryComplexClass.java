package com.javarush.task.task38.task3803;

/*
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object test = (int) new Object();
    }

    public void methodThrowsNullPointerException() {
        Object nu = null;
        nu.toString();
    }

    public static void main(String[] args) {

    }
}
