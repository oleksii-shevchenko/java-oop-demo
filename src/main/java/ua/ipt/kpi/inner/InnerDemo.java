package ua.ipt.kpi.inner;

import java.util.Arrays;
import java.util.Iterator;

public class InnerDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(11);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

interface List<T> extends Iterable<T> {
    void add(T element);

    T get(int index);

    T delete(int index);

    T update(int index, T newElement);

    int size();
}

class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 4;

    private static final int DEFAULT_EXPANSION = 2;

    private Object[] container;

    private int size;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        this.size = 0;
        this.container = new Object[capacity];
    }

    @Override
    public void add(T element) {
        checkCapacityOrExpand();
        container[size++] = element;
    }

    @Override
    public T get(int index) {
        checkRangeOrException(index);
        return (T) container[index];
    }

    @Override
    public T delete(int index) {
        checkRangeOrException(index);
        T oldElement = (T) container[index];
        System.arraycopy(container, index + 1, container, index, size - index + 1);
        container[size] = null;
        size--;
        return oldElement;
    }

    @Override
    public T update(int index, T newElement) {
        checkRangeOrException(index);
        T oldElement = (T) container[index];
        container[index] = newElement;
        return oldElement;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator<>();
    }

    private void checkRangeOrException(int index) {
        if (size <= 0) {
            throw new RuntimeException("List is empty");
        }
        if (index < 0 || index >= size) {
            throw new RuntimeException("Index out of range");
        }
    }

    private void checkCapacityOrExpand() {
        if (size == container.length) {
            Object[] newContainer = new Object[DEFAULT_EXPANSION * container.length];
            System.arraycopy(container, 0, newContainer, 0, container.length);
            Arrays.fill(container, null);
            container = newContainer;
        }
    }

    public class ArrayListIterator<T> implements Iterator<T> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if (hasNext()) {
                return (T) container[index++];
            } else {
                throw new RuntimeException("Index out of range");
            }
        }
    }
}