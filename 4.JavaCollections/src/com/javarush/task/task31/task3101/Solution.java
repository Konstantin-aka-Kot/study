package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) throws IOException {

        Queue<File> dir = new LinkedList<>();
File path = new File(args[0]);
File resultFileAbsolutePath = new File(args[1]);
File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
if (path.isDirectory()) dir.add(path);
try (BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(resultFileAbsolutePath))){
    while (!dir.isEmpty()){
        for (File file : dir.poll().listFiles()){
            if (file.isDirectory()) dir.add(file);
            else if (file.length() < 50) {
            try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file))){
                int data = reader.read();
                while (data != -1){

                }
            }
            }
        }
    }
}

    }
}
