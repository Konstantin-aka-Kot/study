package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        if (c.getAnnotation(PrepareMyTest.class) != null){
            PrepareMyTest prepareMyTest = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            System.out.println(Arrays.toString(prepareMyTest.fullyQualifiedNames()));
            return true;
        }
        return false;
    }

    public static boolean printValues(Class c) {
        if (c.getAnnotation(PrepareMyTest.class) != null){
            PrepareMyTest prepareMyTest = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            for (Class<?> clazz : prepareMyTest.value()){
                System.out.println(clazz.getSimpleName());
            }
            return true;
        }
        return false;
    }
}
