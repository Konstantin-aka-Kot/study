package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;
    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int size = 0;
        for (List<V> value : map.values()){
            size += value.size();
        }
        return size;
    }

    @Override
    public V put(K key, V value) {
        if (!map.containsKey(key)){
            List<V> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
            return null;
        } else {
            List<V> list = map.get(key);
            V last = list.get(list.size() - 1);
            if (list.size() < repeatCount) list.add(value);
            else if (list.size() == repeatCount) {
                list.remove(0);
                list.add(value);
            }
            map.put(key, list);
            return last;
        }
    }

    @Override
    public V remove(Object key) {
        if (map.containsKey(key)) {
            List<V> list = map.get(key);
            V first = list.get(0);
            list.remove(0);
            if (list.isEmpty()){
                map.remove(key);
            } else {
                map.put((K)key, list);
            }
            return first;
        }
        return null;
    }

    @Override
    public Set<K> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        List<V> list = new ArrayList<>();
        for (List<V> val : map.values()){
            list.addAll(val);
        }
        return list;
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        for (List<V> val : map.values()){
            if (val.contains((V) value)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}