package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable{
    public static void main(String[] args) throws IOException {
        System.out.println(new Solution(4));

        try (FileOutputStream fos = new FileOutputStream("test.dat");
             ObjectOutputStream outputStream = new ObjectOutputStream(fos);
             FileInputStream fis = new FileInputStream("test.dat");
             ObjectInputStream inputStream = new ObjectInputStream(fis)){

            Solution savedObject = new Solution(2);
            System.out.println(savedObject);
            outputStream.writeObject(savedObject);
            Solution someObject = new Solution(77);
            Solution loadedObject = (Solution) inputStream.readObject();
            System.out.println(loadedObject);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
