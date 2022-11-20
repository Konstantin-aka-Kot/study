package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("C:\\Users\\KoT\\Desktop\\JavaTest"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL ulr = new URL(urlString);
        InputStream inputStream = ulr.openStream();
        Path tempFile = Files.createTempFile("temp", ".tmp");
        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);
        Path download = Paths.get(downloadDirectory.toString() + urlString.substring(urlString.lastIndexOf("/")));
        Files.move(tempFile, download, StandardCopyOption.REPLACE_EXISTING);

        return download;
    }
}
