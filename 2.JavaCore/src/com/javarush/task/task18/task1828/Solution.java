package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        String path;
try (Scanner scanner = new Scanner(System.in);
     BufferedReader reader = new BufferedReader(new FileReader(path = scanner.nextLine()));
     BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
    if (args.length == 0) {return;}
            ArrayList<String> list = new ArrayList<>();
            while (reader.ready()) {
                String next = reader.readLine();
                String it = next.substring(0, 8).trim();
                if (it.equals(args[1])) {
                    if (args[0].equals("-u")){
                        list.add(String.format("%-8s%-30s%-8s%-4s", args[1], args[2], args[3], args[4]));
                        continue;
                    }
                    if (args[0].equals("-d")) continue;
                }
                list.add(next);
            }
            PrintWriter clear = new PrintWriter(path);
            clear.print("");
            clear.close();
            for (String s : list){
                writer.write(s + "\n");
            }
     } catch (IOException e) {
    throw new RuntimeException(e);
}
    }
}
