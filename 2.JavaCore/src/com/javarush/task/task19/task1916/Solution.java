package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        try (BufferedReader consol = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader readerFile1 = new BufferedReader(new FileReader(consol.readLine()));
        BufferedReader readerFile2 = new BufferedReader(new FileReader(consol.readLine()))){
        List<String> file1 = new ArrayList<>();
        List<String> file2 = new ArrayList<>();
        while (readerFile1.ready()){
            file1.add(readerFile1.readLine());
        }
        while (readerFile2.ready()){
            file2.add(readerFile2.readLine());
        }
        while (file1.size() > 0 && file2.size() > 0){
            if (file1.get(0).equals(file2.get(0))){
                lines.add(new LineItem(Type.SAME, file1.get(0)));
                file2.remove(0);
                file1.remove(0);
            } else if (file1.get(1).equals(file2.get(0))){
                lines.add(new LineItem(Type.REMOVED, file1.get(0)));
                file1.remove(0);
            } else if (file1.get(0).equals(file2.get(1))){
                lines.add(new LineItem(Type.ADDED, file2.get(0)));
                file2.remove(0);
            }
        }
            if (!file1.isEmpty()){
                lines.add(new LineItem(Type.REMOVED, file1.get(0)));
                file1.remove(0);
            }
            if (!file2.isEmpty()){
                lines.add(new LineItem(Type.ADDED, file2.get(0)));
                file2.remove(0);
            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
