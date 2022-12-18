package com.javarush.task.task22.test;

public class ttt {
    public static void main(String[] args) {
//        String s = "Киев";
//        System.out.println(s.charAt(s.length() - 1));
        StringBuilder sb = new StringBuilder();
        sb.append("Мельбурн Нью-Йорк ");
        String sss = "амс";
        sb.insert(0, sss + " ");
        //sb.reverse().append(new StringBuilder("Амстердам").append(" ").reverse()).reverse();
        System.out.println(sb);
    }
}
