package com.java.tasks.task11;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedList<E> implements SimpleList<E> {
    private Node<E> first = null; // head
    private Node<E> last = null; // tail
    private int size = 0;

    private static class Node<T> {
        private Node<T> prev;
        private T item;
        private Node<T> next;

        private Node(Node<T> prev, T item, Node<T> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || size < index) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private Node<E> node(int index) {
        if (index < size / 2) {
            Node<E> tmp = first;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            return tmp;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    private E unlink(Node<E> x) { //todo:
        // assert x != null;
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.item = null;
        size--;
        return element;
    }

    @Override
    public boolean add(E newElement) {
        final Node<E> tmp = last;
        final Node<E> newNode = new Node<>(tmp, newElement, null);
        last = newNode;
        if (tmp == null) {
            first = newNode;
        } else {
            tmp.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return node(index).item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            //private int index = 0;

            @Override
            public boolean hasNext() {
                return first != null;
            }

            @Override
            public E next() {
                if ( first == null ) {
                    throw new NoSuchElementException();
                }
                if ( first.next == null ) {
                    E result = first.item;
                    first = first.next;

                    return result;
                }

                first = first.next;
                return first.prev.item;
            }

            @Override
            public void remove() {
                if( first.prev == null ) {
                    throw new IllegalStateException();
                }

                unlink(first);
            }
        };
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        if (size > 0) {
            for (Node node = first; node.next != null; node = node.next) {
                hash = hash + (node.item.hashCode());
            }
        }
        return hash;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        return unlink(node(index));
    }

    @Override
    public String toString() {
        int arrLength = size;
        Node arrCopy = first;
        StringBuilder result = new StringBuilder("[");

        if (size == 0) return "[" + "]";

        for (int i = 0; i < arrLength - 1; i++) {
            result.append(arrCopy.item.toString()).append(", ");
            arrCopy = arrCopy.next;
        }

        result.append(last.item).append("]");

        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof SimpleLinkedList) {
            SimpleLinkedList<E> other = (SimpleLinkedList<E>) o;

            if (size != other.size)
                return false;

            for (int i = 0; i < size; i++)
                if (!get(i).equals(other.get(i)))
                    return false;

            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //empty list
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        //call and check
        Iterator<Integer> iterator = null;
        try {
            iterator = simpleLinkedList.iterator();
        } catch (UnsupportedOperationException u) {
            throw new AssertionError("Iterator not implemented");
        }
        if (iterator == null)
            throw new AssertionError("Iterator must be no equals null");
        if (iterator.hasNext())
            throw new AssertionError("hasNext() must be returned false if no element");
        boolean isExceptionMethodNext = false;
        try {
            iterator.next();
        } catch (NoSuchElementException e) {
            isExceptionMethodNext = true;
        }
        if (!isExceptionMethodNext)
            throw new AssertionError("next() must be throw NoSuchElementException if no element");
        System.out.print("OK");
    }
}

interface SimpleList<T> {
    public boolean add(T newElement);

    public T get(int index);

    public Iterator<T> iterator();

    public int size();

    public boolean isEmpty();

    public T remove(int index);
}

