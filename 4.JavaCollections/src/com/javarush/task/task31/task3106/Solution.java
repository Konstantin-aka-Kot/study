package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Solution {
    public static void main(String[] args) throws IOException {
        Set<String> allSet = new TreeSet<>();
        List<InputStream> streamList = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            allSet.add(args[i]);
        }
        for (String s : allSet){
            streamList.add(new FileInputStream(s));
        }
        try (ZipInputStream zis = new ZipInputStream(new SequenceInputStream(Collections.enumeration(streamList)));
        OutputStream fos = new BufferedOutputStream(new FileOutputStream(args[0]))){
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null){
                final int bufferSize = 1024;
                byte[] buffer = new byte[bufferSize];
                for (int readBytes; (readBytes = zis.read(buffer, 0, bufferSize)) > -1; ){
                    fos.write(buffer, 0, readBytes);
                }
                fos.flush();
            }
        }

    }
}