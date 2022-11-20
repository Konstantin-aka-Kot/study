package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(this.fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\r\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        stream = new FileOutputStream(fileName, true);
        in.defaultReadObject();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
Solution sol = new Solution("test");
sol.writeObject("Пишем");
sol.writeObject("Дозаписываем");

String filePath = "test2";
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
oos.writeObject(sol);
sol.close();
oos.close();

ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
Solution sol2 = (Solution) ois.readObject();
sol2.close();
ois.close();
    }
}
