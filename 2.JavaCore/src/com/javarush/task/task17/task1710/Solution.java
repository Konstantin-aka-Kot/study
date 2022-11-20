package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]) {
            case "-c" :
                create(args[1], args[2], args[3]);
            break;
            case "-r" :
                read(Integer.parseInt(args[1]));
                break;
            case "-u" :
                update(Integer.parseInt(args[1]), args[2], args[3], args[4]);
                break;
            case "-d" :
                delete(Integer.parseInt(args[1]));
                break;
        }
    }

    private static void delete(int id){
        allPeople.get(id).setSex(null);
        allPeople.get(id).setName(null);
        allPeople.get(id).setBirthDate(null);
    }
    private static void create(String name, String sex, String bd) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = formatter.parse(bd);
        if (sex.equals("м")) {
            allPeople.add(Person.createMale(name, date));
            System.out.println(allPeople.size() - 1); // мб без - 1
        } else if (sex.equals("ж")) {
            allPeople.add(Person.createFemale(name, date));
            System.out.println(allPeople.size() - 1); // мб без - 1
        }
    }

    private static void read(int id){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        if (allPeople.get(id).getSex() == Sex.MALE) {
            System.out.println(allPeople.get(id).getName() + " м " + formatter.format(allPeople.get(id).getBirthDate()));
        } else if (allPeople.get(id).getSex() == Sex.FEMALE) {
            System.out.println(allPeople.get(id).getName() + " ж " + formatter.format(allPeople.get(id).getBirthDate()));
        }
    }

    private static void update(int id, String name, String sex, String bd) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = formatter.parse(bd);
        if (sex.equals("м")){
            allPeople.get(id).setName(name);
            allPeople.get(id).setSex(Sex.MALE);
            allPeople.get(id).setBirthDate(date);
        } else if (sex.equals("ж")) {
            allPeople.get(id).setName(name);
            allPeople.get(id).setSex(Sex.FEMALE);
            allPeople.get(id).setBirthDate(date);
        }
    }
}
