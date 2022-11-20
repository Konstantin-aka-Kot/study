package com.javarush.task.task19.task1906;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            try (FileReader fileReader = new FileReader(reader.readLine())){
                try (FileWriter fileWriter = new FileWriter(reader.readLine())){
                    for (int i = 1; fileReader.ready(); i++) {
                        int data = fileReader.read();
                        if (i%2 == 0){
                        fileWriter.write(data);
                        }
                    }
                }
            }
        }
    }
}
