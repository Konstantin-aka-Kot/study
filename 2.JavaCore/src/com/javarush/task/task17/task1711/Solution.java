package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
       //  args= new String[]{"-c", "Иванов", "м", "04/01/1990", "Иванова", "ж", "18/05/1999"};
//  args= new String[]{"-u", "0","Петров", "м", "04/01/1991", "1","Петрова", "ж", "18/05/1995"};
//args= new String[]{"-d", "0","1"};
        //args= new String[]{"-i", "0","1"};
        SimpleDateFormat formatterIn = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat formatterOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Date date;
             switch (args[0]) {
                case "-c" :
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i += 3) {
                            date = formatterIn.parse(args[i + 2]);
                            String name = args[i];
                            String sex = args[i + 1];
                            Person person = sex.equals("м") ? Person.createMale(name, date) : Person.createFemale(name, date);
                            allPeople.add(person);
                            System.out.println(allPeople.indexOf(person));
                        }
                        break;
                    }
                case "-u" :
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i += 4) {
                            int id = Integer.parseInt(args[i]);
                            String name = args[i + 1];
                            date = formatterIn.parse(args[i + 3]);
                            String sex = args[i + 2];
                                allPeople.get(id).setName(name);
                                allPeople.get(id).setBirthDate(date);
                                allPeople.get(id).setSex("м".equals(sex) ? Sex.MALE : Sex.FEMALE);
                        }
                        break;
                    }
                case "-d" :
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            allPeople.get(Integer.parseInt(args[i])).setName(null);
                            allPeople.get(Integer.parseInt(args[i])).setSex(null);
                            allPeople.get(Integer.parseInt(args[i])).setBirthDate(null);
                        }
                        break;
                    }
                case "-i" :
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            int id = Integer.parseInt(args[i]);
                            Person person = allPeople.get(id);
                            System.out.print(person.getName() + " ");
                            System.out.print(person.getSex().equals(Sex.MALE) ? "м " : "ж ");
                            System.out.println(formatterOut.format(person.getBirthDate()));
                        }
                    }
            }

    }
}
