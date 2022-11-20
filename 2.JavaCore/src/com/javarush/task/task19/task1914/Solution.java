package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;/*
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String[] result = outputStream.toString().split(" ");
        int first = Integer.parseInt(result[0]);
        int second = Integer.parseInt(result[2]);
        int sum = 0;
        switch (result[1]){
            case "+" :
                sum = first + second;
                break;
            case "-" :
                sum = first - second;
                break;
            case "*" :
                sum = first * second;
                break;
        }
        System.setOut(consoleStream);
        System.out.print(first + " " + result[1] + " " + second + " = " + sum);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

