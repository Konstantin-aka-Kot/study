package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{

    private FileOutputStream fos;

    public AmigoOutputStream(FileOutputStream fos) throws FileNotFoundException {
        super("fos");
        this.fos = fos;
    }

    @Override
    public void close() throws IOException {
        fos.flush();
        fos.write("JavaRush © All rights reserved.".getBytes());
        fos.close();
    }

    @Override
    public void flush() throws IOException {
        fos.flush();
    }

    @Override
    public void write(byte[] b) throws IOException {
        fos.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        fos.write(b, off, len);
    }

    @Override
    public void write(int b) throws IOException {
        fos.write(b);
    }

    public static String fileName = "C:/tmp/result.txt";

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
