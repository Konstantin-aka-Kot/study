package com.javarush.task.task15.task1529;

import java.util.Scanner;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        reset();
    }

    public static CanFly result;

    public static void reset() {
        try (Scanner scanner = new Scanner(System.in)){
            String in = scanner.nextLine();
            if (in.equals("helicopter")) {
                result = new Helicopter();
            } else if (in.equals("plane")) {
                result = new Plane(scanner.nextInt());
            }
        }
    }
}
