package IgorTasks.task1.TestDoc;

import IgorTasks.task1.Person;

import java.util.Date;
import java.util.Random;

public class Randomizer {
    public static int createID(){
        int count = 1000000;
        return ++count;
    }

    public static String createRandomString(){
        Random random = new Random();
        return String.format("%s%s", System.currentTimeMillis(), random.nextInt(1000000));
    }

    public static Date createDate(){
        return new Date(-946771200000L + (Math.abs(new Random().nextLong()) % (80L * 365 * 24 * 60 * 60 * 1000)));
    }

    public static Person createPerson(){
        return new Person(createRandomString(), createRandomString(), createRandomString(),
                createRandomString(), createDate(), createRandomString());
    }
}
