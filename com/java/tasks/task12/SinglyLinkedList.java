package com.java.tasks.task12;

import java.util.Iterator;
import java.util.NoSuchElementException;
public class SinglyLinkedList <T> {
    private Node<T> first = null;
    public void add(T element) {
        if (first == null) {
            first = new Node<T>(element);
        } else {
            Node<T> current = getLast();
            current.next = new Node<T>(element);
        }
    }
    public Iterator<T> iterator() {
        return new Itr();
    }
    private class Itr implements Iterator<T> {
        Node<T> current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public T next() {
            if (current == null) throw new IndexOutOfBoundsException();
            if (current.element == null) throw new NoSuchElementException();
            T element = current.element;
            current = current.next;
            return element;
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    private Node<T> getLast() {
        Node<T> last = first;
        while (last.next != null) {
            last = last.next;
        }
        return last;
    }
    private class Node<T> {
        T element;
        Node<T> next;
        Node(T element) {
            this.element = element;
            this.next = null;
        }
    }
}
class FinderElements {
    public static Integer findElement(SinglyLinkedList<Integer> singlyLinkedList, int k) {
        int index, count = 0;
        Iterator<Integer> iterator = singlyLinkedList.iterator();

        for(Iterator<Integer> i = iterator; i.hasNext();) {
            count++;
            iterator.next();
        }

        index = count - k;
        iterator = singlyLinkedList.iterator();

        for(int i = 0; i < index; i++) {
            if(i == (index - 1)) {
                return iterator.next();
            }
            iterator.next();
        }



        throw new IndexOutOfBoundsException();
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        Integer expectedElement = 7;
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(7);
        list.add(11);
        list.add(34);
        list.add(18);
        Integer actualElement = FinderElements.findElement(list, 3);
        if (actualElement == null)
            throw new AssertionError("result findElement()  is not null");
        if (expectedElement.compareTo(actualElement) != 0)
            throw new AssertionError("expected element equals " + expectedElement.toString() + " but found " + actualElement.toString());
        System.out.print("OK");
    }
}


