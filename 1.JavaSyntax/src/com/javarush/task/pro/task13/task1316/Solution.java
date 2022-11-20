package com.javarush.task.pro.task13.task1316;

public class Solution {

    public static void main(String[] args) {
        JavarushQuest[] quest = JavarushQuest.values();
        for (JavarushQuest java: quest) {
            System.out.println(java.ordinal());
        }
    }
}
