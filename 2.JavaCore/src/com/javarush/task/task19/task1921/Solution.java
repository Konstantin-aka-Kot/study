package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))){
    while (reader.ready()){
        String[] data = reader.readLine().split("(?<=\\D) (?=\\d)");
        Date date = new SimpleDateFormat("dd MM yyyy").parse(data[1]);
        PEOPLE.add(new Person(data[0], date));
    }
}
    }
}
