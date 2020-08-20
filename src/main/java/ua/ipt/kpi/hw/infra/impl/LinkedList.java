package ua.ipt.kpi.hw.infra.impl;

import java.util.Iterator;
import java.util.function.Function;
import ua.ipt.kpi.hw.infra.List;

public class LinkedList<T> implements List<T> {
    @Override
    public void add(T value) {
        // TODO implement
    }

    @Override
    public boolean contains(T value) {
        // TODO implement
        return false;
    }

    @Override
    public T get(int index) {
        // TODO implement
        return null;
    }

    @Override
    public T delete(T value) {
        // TODO implement
        return null;
    }

    @Override
    public T delete(int index) {
        // TODO implement
        return null;
    }

    @Override
    public T update(int index, T value) {
        // TODO implement
        return null;
    }

    @Override
    public int size() {
        // TODO implement
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO implement
        return null;
    }

    @Override
    public <V> List<V> process(Function<T, V> processor) {
        // TODO implement
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO implement
        return super.equals(obj);
    }
}
