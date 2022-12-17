package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Hippodrome {
    static Hippodrome game;
    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
    public void run(){
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void move(){
    horses.forEach(Horse::move);
    }
    public void print(){
        horses.forEach(Horse::print);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
    public Horse getWinner(){
        return horses.stream().max(Comparator.comparing(Horse::getDistance)).get();
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
    public static void main(String[] args) {
        Horse horse1 = new Horse("1", 3, 0);
        Horse horse2 = new Horse("2", 3, 0);
        Horse horse3 = new Horse("3", 3, 0);
        game = new Hippodrome(new ArrayList<>());
        game.horses.add(horse1);
        game.horses.add(horse2);
        game.horses.add(horse3);
        game.run();
        game.printWinner();
    }
}
