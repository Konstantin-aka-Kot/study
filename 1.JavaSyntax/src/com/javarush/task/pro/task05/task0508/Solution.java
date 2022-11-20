package com.javarush.task.pro.task05.task0508;

import java.util.Scanner;

/* 
Удаляем одинаковые строки
*/

public class Solution {
    public static String[] strings;

    public static void main(String[] args) {
        Scanner asd = new Scanner(System.in); // сканнер
        strings = new String[6]; // массив на 6 строк
        String currentString; // новая строка каррентстринг
        for (int i = 0; i < strings.length; i++) { // цикл для ввода всего массива стрингс
            strings[i] = asd.nextLine(); // собственно считываем каждую строку и вносим в массив
        }
        for (int i = 0; i < strings.length; i++) { // массив для перебора строк на совпадения
            if (strings[i] == null) { // если строка равно null - пропускаем
                continue;
            }
            currentString = new String(strings[i]); // вносим в переменную каррентстринг значение из i значения массива стринг
            for (int j= (i+1); j < strings.length; j++){ //  цикл в котором мы перебираем все переменные по массиву
                if (currentString.equals(strings[j])) { // если одинаковы
                    strings[i]= null;
                    strings[j]=null;
                }
            }
        }
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i]+", ");
        }
    }
}
