package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    /**
     * Стартовый корень для дерева;
     */
    Entry<String> root;
    private int size = 0;
    private List<Entry<String>> list = new ArrayList<>();
    public CustomTree() {
        this.root = new Entry<>("0");
        root.parent = root;
        list.add(root.parent);
    }
public String getParent(String s){
        String result = null;
for (Entry<String> entry : list){
    if (entry.elementName.equals(s)) {
        result = entry.parent.elementName;
        break;
    }
}
return result;
}

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof String)) throw  new UnsupportedOperationException();
        String s = (String) o;
        for (Entry<String> entry : list){
            if (entry.elementName.equals(s)){
                if (entry.leftChild != null) remove(entry.leftChild.elementName);
                if (entry.rightChild != null) remove(entry.rightChild.elementName);
                if (entry.parent.leftChild != null && entry.parent.leftChild.elementName.equals(s))
                    entry.parent.leftChild = null;
                else entry.parent.rightChild = null;
                list.remove(entry);
                size--;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean add(String elementName) {
       Entry<String> entry = new Entry<>(elementName);
       Entry<String> p;
        for (int i = 0; i < list.size(); i++) {
            p = list.get(i);
            if (p.isAvailableToAddChildren()){
                if (p.availableToAddLeftChildren) {
                    p.leftChild = entry;
                    p.availableToAddLeftChildren = false;
                } else {
                    p.rightChild = entry;
                    p.availableToAddRightChildren = false;
                }
                entry.parent = p;
                list.add(entry);
                size++;
                return true;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            p = list.get(i);
            if (!p.isAvailableToAddChildren() && p.leftChild == null && p.rightChild == null){
                p.availableToAddLeftChildren = true;
                p.availableToAddRightChildren = true;
                add(elementName);
                return true;
            }
        }

        return false;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }
}
