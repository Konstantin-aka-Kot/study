package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.male.KidBoy;
import com.javarush.task.task37.task3702.male.TeenBoy;

public interface AbstractFactory {
    public default Human getPerson(int age) {
        if (age <= KidBoy.MAX_AGE);
        else if (age <= TeenBoy.MAX_AGE);
        else;
        return null;
    }
}
