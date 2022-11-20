package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/

public class Solution extends SimpleFileVisitor<Path> {
    private static int dirCount = -1;
    private static int filesCount;
    private static long sizeCount;

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        if (Files.isDirectory(dir)) dirCount++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        sizeCount += Files.size(file);

        if (Files.isRegularFile(file)) filesCount++;
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            Path path = Paths.get(reader.readLine());
            if (!Files.isDirectory(path)){
                System.out.println(path.toAbsolutePath() + " - не папка");
            } else {
                Files.walkFileTree(path, new Solution());
                System.out.println("Всего папок - " + dirCount);
                System.out.println("Всего файлов - " + filesCount);
                System.out.println("Общий размер - " + sizeCount);
            }
        }
    }
}
