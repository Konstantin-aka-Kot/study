package com.javarush.task.task18.task1812;

import java.io.IOException;
import java.util.Scanner;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
private AmigoOutputStream aos;

    public QuestionFileOutputStream(AmigoOutputStream aos) {
        this.aos = aos;
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.nextLine().equals("Д")){
                aos.close();
            }
        }
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        aos.write(b, off, len);
    }

    @Override
    public void write(byte[] b) throws IOException {
        aos.write(b);
    }

    @Override
    public void write(int b) throws IOException {
        aos.write(b);
    }

    @Override
    public void flush() throws IOException {
        aos.flush();
    }
}

