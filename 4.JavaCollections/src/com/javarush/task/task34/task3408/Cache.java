package com.javarush.task.task34.task3408;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>(); // Map<SomeKey, SomeValue.class>

    public V getByKey(K key, Class<V> clazz) throws Exception {
        V result = cache.get(key);
        if (result == null) {
            Object o  = Class.forName(clazz.getName()).getConstructor(key.getClass()).newInstance(key);
            result = cache.put(key, (V) o);
        }
        return result;
    }

    public boolean put(V obj) {
        Class cls = obj.getClass();
        try {
            Method method = cls.getDeclaredMethod("getKey");
            method.setAccessible(true);
            Object key = method.invoke(obj);
            cache.put((K)key, obj);
            return true;
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
       return false;
        }
    }

    public int size() {
        return cache.size();
    }
}
