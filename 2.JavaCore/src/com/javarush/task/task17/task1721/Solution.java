package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {

    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             BufferedReader path1 = new BufferedReader(new FileReader(scanner.nextLine()));
             BufferedReader path2 = new BufferedReader(new FileReader(scanner.nextLine()));) {
            while (path1.ready()) {
                allLines.add(path1.readLine());
            }
            while (path2.ready()){
                forRemoveLines.add(path2.readLine());
            }
            Solution sol = new Solution();
            sol.joinData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void joinData() throws CorruptedDataException {
        boolean contain = true;
        for (String s : forRemoveLines) {
            if (!allLines.contains(s)) {
                contain = false;
                break;
            }
        }
        if (contain)  {
            for (String s : forRemoveLines) {
            allLines.remove(s);
            }
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}
