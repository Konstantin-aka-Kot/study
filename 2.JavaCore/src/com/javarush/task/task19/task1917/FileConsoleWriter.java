package com.javarush.task.task19.task1917;

/*
Свой FileWriter
*/

import java.io.*;

public class FileConsoleWriter {
    private FileWriter fileWriter;
    private BufferedWriter consoleWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public FileConsoleWriter(String filename) throws IOException {
        fileWriter = new FileWriter(filename);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        fileWriter = new FileWriter(fd);
    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        consoleWriter.write(c);
        consoleWriter.flush();
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        consoleWriter.write(new String(cbuf).substring(off, off + len));
        consoleWriter.flush();
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        consoleWriter.write(str.substring(off, off + len));
        consoleWriter.flush();
    }

    public void close() throws IOException {
        fileWriter.close();
        consoleWriter.close();
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        consoleWriter.write(new String(cbuf));
        consoleWriter.flush();
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        consoleWriter.write(str);
        consoleWriter.flush();
    }

    public static void main(String[] args) {

    }

}
