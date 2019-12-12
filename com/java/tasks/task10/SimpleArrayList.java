package com.java.tasks.task10;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayList<E> implements SimpleList<E> {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private E[] data;
    private int arrSize = 0;

    public SimpleArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public SimpleArrayList(int initialCapacity) {
        this.data = (E[]) new Object[initialCapacity];
    }

    @Override
    public boolean add(E newElement) {
        ensureCapacity(arrSize + 1);
        data[arrSize] = newElement;
        arrSize++;
        return true;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return data[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index != arrSize;
            }

            @Override
            public E next() {
                if (index == arrSize)
                    throw new NoSuchElementException();

                index++;
                return data[index - 1];
            }

            @Override
            public void remove() {
                if (index <= 0)
                    throw new IllegalStateException();

                for (int i = index; i < arrSize; i++) {
                    data[i - 1] = data[i];
                }

                arrSize--;
                data[arrSize] = null;
            }
        };
    }

    @Override
    public int size() {
        return arrSize;
    }

    @Override
    public boolean isEmpty() {
        return arrSize == 0;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E oldValue = data[index];
        int numMoved = arrSize - index - 1;
        System.arraycopy(data, index + 1, data, index, numMoved);
        data[--arrSize] = null;
        return oldValue;
    }

    private void rangeCheck(int index) {
        if (index < 0 || arrSize < index) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = Math.max(minCapacity, data.length + (data.length >> 1));
            E[] newData = (E[]) new Object[newCapacity];
            System.arraycopy(data, 0, newData, 0, data.length);
            this.data = newData;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        if (arrSize == 0) return "[" + "]";

        for (int i = 0; i < arrSize - 1; i++)
            result.append(data[i].toString()).append(", ");

        result.append(data[arrSize - 1]).append("]");
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof SimpleArrayList) {
            SimpleArrayList anotherArr = (SimpleArrayList) o;
            if (arrSize != anotherArr.size()) {
                return false;
            }

            for (int i = 0; i < arrSize; i++) {
                if (!data[i].equals(anotherArr.data[i])) {
                    return false;
                }
            }

            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }
}

interface SimpleList<E> {
    public boolean add(E newElement);

    public E get(int index);

    public Iterator<E> iterator();

    public int size();

    public boolean isEmpty();

    public E remove(int index);
}