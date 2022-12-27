package com.javarush.task.task26.task2603;

/*
Убежденному убеждать других не трудно
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.util.Comparator.comparing;

public class Solution {

    public static void main(String[] args) {
        TestClass first = new TestClass("aaa", "bbb", "ccc");
        TestClass second = new TestClass("aaa", "ccc", "hrt");
        TestClass third = new TestClass("aaa", "ccc", "aaa");
        ArrayList<TestClass> list = new ArrayList<>();
        list.add(first);
        list.add(second);
        list.add(third);

        Collections.sort(list, new CustomizedComparator<>(comparing(o -> o.x), comparing(o -> o.y), comparing(o -> o.z)));

        for (TestClass test : list) {
            test.consoleout();
        }
    }

    public static class CustomizedComparator<T> implements Comparator<T> {
        private final Comparator<T>[] comparators;

        @SafeVarargs
        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T o1, T o2) {
            int res = 0;
            for (Comparator<T> comparator : comparators) {
                res = comparator.compare(o1, o2);
                if (res != 0) return res;
            }
            return 0;
        }
    }
}
