package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        Queue<File> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();
File folder = new File(root);
if (folder.isDirectory()) queue.add(folder);
while (!queue.isEmpty()){
    for (File file : queue.poll().listFiles()){
        if (file.isDirectory()) queue.add(file);
        else result.add(file.getAbsolutePath());
    }

    }

        return result;
    }

    public static void main(String[] args) throws IOException {
getFileTree("C:\\Users\\KoT\\Desktop\\test");
    }
}
