package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;

import java.util.Arrays;

public class Controller {
    private Provider[] providers;
    public Controller(Provider... varargs) {
        if (varargs.length == 0) throw new IllegalArgumentException();
        this.providers = varargs;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }
}
