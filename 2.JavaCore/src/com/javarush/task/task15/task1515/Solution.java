package com.javarush.task.task15.task1515;

import java.util.Scanner;

public class Solution {
    public static int A;
    public static int B;
static {
    try (Scanner scanner = new Scanner(System.in)) {
        A = scanner.nextInt();
        B = scanner.nextInt();
    }
}
    public static final int MIN = min(A, B);

    public static void main(String[] args) {
        System.out.println(MIN);
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }
}
