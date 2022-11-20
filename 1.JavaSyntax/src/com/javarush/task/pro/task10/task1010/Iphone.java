package com.javarush.task.pro.task10.task1010;

/*
Два айфона
*/

public class Iphone {
    private String model;
    private String color;
    private int price;

    public Iphone(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

    public boolean equals(Object iphone) {
        if (this == iphone) return true;
        if (iphone == null || getClass() != iphone.getClass()) return false;

        Iphone that = (Iphone) iphone;

        if (model != that.model) {
            return false;
        }
        if (color != that.color) {
            return false;
        }
        if (price != that.price) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Iphone iphone1 = new Iphone("X", "Black", 999);
        Iphone iphone2 = new Iphone("X", "Black", 999);

        System.out.println(iphone1.equals(iphone2));
    }

}
