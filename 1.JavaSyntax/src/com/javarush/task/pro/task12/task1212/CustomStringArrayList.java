package com.javarush.task.pro.task12.task1212;

/* 
Создаем свой список
*/

public class CustomStringArrayList {

    private int size;
    private int capacity;
    private String[] elements;

    public CustomStringArrayList() {
        capacity = 10;
        size = 0;
        elements = new String[capacity];
    }

    public void add(String element) {
        if (size == capacity) {
            grow();
        }
        elements[size] = element;
        size++;
    }

    private void grow() {
        String[] copy = elements.clone();
        elements = new String[(int) (capacity * 1.5)];
        capacity = (int) (capacity * 1.5);
        for (int i = 0; i < copy.length; i++) {
            elements[i] = copy[i];
        }
    }

}
