package com.javarush.task.task35.task3512;

public class Generator<T> {
    Class<T> cls;

    public Generator(Class<T> cls) {
        this.cls = cls;
    }

    T newInstance() {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
