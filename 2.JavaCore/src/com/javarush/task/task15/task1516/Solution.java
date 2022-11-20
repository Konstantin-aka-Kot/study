package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

public class Solution {
    public int intVar;
    public double doubleVar;
    public Double DoubleVar;
    public boolean booleanVar;
    public Object ObjectVar;
    public Exception ExceptionVar;
    public String StringVar;
    public static void main(String[] args) {
        Solution m = new Solution();
        System.out.println(m.intVar);
        System.out.println(m.doubleVar);
        System.out.println(m.DoubleVar);
        System.out.println(m.booleanVar);
        System.out.println(m.ObjectVar);
        System.out.println(m.ExceptionVar);
        System.out.println(m.StringVar);
    }
}
