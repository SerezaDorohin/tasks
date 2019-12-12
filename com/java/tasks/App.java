package com.java.tasks;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

public class App {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<String> results = new ArrayList<>();

        int size = 400000;

        for(int i = 0; i < size; i++) {
            linkedList.add(100);
            arrayList.add(100);
        }

        int center = size / 2;
        int l_length = linkedList.size();
        int a_length = arrayList.size();

        double start, finish, resultLinkedList, resultArrayList;

        System.out.println(" ---- ");

        // DELETE CENTER
        start = System.nanoTime();
        linkedList.remove(center);
        finish = System.nanoTime();
        resultLinkedList = finish - start;
        System.out.println("Delete CENTER [LinkedList]: " + resultLinkedList + " nanoseconds");

        start = System.nanoTime();
        arrayList.remove(center);
        finish = System.nanoTime();
        resultArrayList = finish - start;
        System.out.println("Delete CENTER [ArrayList]: " + resultArrayList + " nanoseconds");
        if(resultArrayList < resultLinkedList) System.out.println("Array list is better");else System.out.println("Linked list is better");
        if(resultArrayList < resultLinkedList) results.add("delete center: " + "Array list is better");else results.add("delete center: " + "Linked list is better");
        // --------

        System.out.println(" ---- ");

        // ADD CENTER
        start = System.nanoTime();
        linkedList.add(center, 100);
        finish = System.nanoTime();
        resultLinkedList = finish - start;
        System.out.println("Add CENTER [LinkedList]: " + resultLinkedList + " nanoseconds");

        start = System.nanoTime();
        arrayList.add(center, 100);
        finish = System.nanoTime();
        resultArrayList = finish - start;
        System.out.println("Add CENTER [ArrayList]: " + resultArrayList + " nanoseconds");
        if(resultArrayList < resultLinkedList) System.out.println("Array list is better");else System.out.println("Linked list is better");
        if(resultArrayList < resultLinkedList) results.add("add center: " + "Array list is better");else results.add("add center: " + "Linked list is better");
        // --------

        System.out.println(" ---- ");

        // ADD START
        start = System.nanoTime();
        linkedList.add(0, 100);
        finish = System.nanoTime();
        resultLinkedList = finish - start;
        System.out.println("Add START [LinkedList]: " + resultLinkedList + " nanoseconds");

        start = System.nanoTime();
        arrayList.add(0, 100);
        finish = System.nanoTime();
        resultArrayList = finish - start;
        System.out.println("Add START [ArrayList]: " + resultArrayList + " nanoseconds");
        if(resultArrayList < resultLinkedList) System.out.println("Array list is better");else System.out.println("Linked list is better");
        if(resultArrayList < resultLinkedList) results.add("add start: " + "Array list is better");else results.add("add start: " + "Linked list is better");
        // --------

        System.out.println(" ---- ");

        // ADD END
        start = System.nanoTime();
        linkedList.add(l_length, 100);
        finish = System.nanoTime();
        resultLinkedList = finish - start;
        System.out.println("Add END [LinkedList]: " + resultLinkedList + " nanoseconds");

        start = System.nanoTime();
        arrayList.add(a_length, 100);
        finish = System.nanoTime();
        resultArrayList = finish - start;
        System.out.println("Add END [ArrayList]: " + resultArrayList + " nanoseconds");
        if(resultArrayList < resultLinkedList) System.out.println("Array list is better");else System.out.println("Linked list is better");
        if(resultArrayList < resultLinkedList) results.add("add end: " + "Array list is better");else results.add("add end: " + "Linked list is better");
        // --------

        System.out.println(" ---- ");

        // DELETE START
        start = System.nanoTime();
        linkedList.remove(0);
        finish = System.nanoTime();
        resultLinkedList = finish - start;
        System.out.println("Delete START [LinkedList]: " + resultLinkedList + " nanoseconds");

        start = System.nanoTime();
        arrayList.remove(0);
        finish = System.nanoTime();
        resultArrayList = finish - start;
        System.out.println("Delete START [ArrayList]: " + resultArrayList + " nanoseconds");
        if(resultArrayList < resultLinkedList) System.out.println("Array list is better");else System.out.println("Linked list is better");
        if(resultArrayList < resultLinkedList) results.add("delete start: " + "Array list is better");else results.add("delete start: " + "Linked list is better");
        // --------

        System.out.println(" ---- ");

        // SET START
        start = System.nanoTime();
        linkedList.set(0, 0);
        finish = System.nanoTime();
        resultLinkedList = finish - start;
        System.out.println("Set START [LinkedList]: " + resultLinkedList + " nanoseconds");

        start = System.nanoTime();
        arrayList.set(0, 0);
        finish = System.nanoTime();
        resultArrayList = finish - start;
        System.out.println("Set START [ArrayList]: " + resultArrayList + " nanoseconds");
        if(resultArrayList < resultLinkedList) System.out.println("Array list is better");else System.out.println("Linked list is better");
        if(resultArrayList < resultLinkedList) results.add("Set start: " + "Array list is better");else results.add("Set start: " + "Linked list is better");
        // --------

        System.out.println(" ---- ");

        // SET CENTER
        start = System.nanoTime();
        linkedList.set(center, 0);
        finish = System.nanoTime();
        resultLinkedList = finish - start;
        System.out.println("Set CENTER [LinkedList]: " + resultLinkedList + " nanoseconds");

        start = System.nanoTime();
        arrayList.set(center, 0);
        finish = System.nanoTime();
        resultArrayList = finish - start;
        System.out.println("Set CENTER [ArrayList]: " + resultArrayList + " nanoseconds");
        if(resultArrayList < resultLinkedList) System.out.println("Array list is better");else System.out.println("Linked list is better");
        if(resultArrayList < resultLinkedList) results.add("Set center: " + "Array list is better");else results.add("Set center: " + "Linked list is better");
        // --------

        System.out.println(" ---- ");

        // SET END
        int end = linkedList.size() - 1;
        start = System.nanoTime();
        linkedList.set(end, 0);
        finish = System.nanoTime();
        resultLinkedList = finish - start;
        System.out.println("Set END [LinkedList]: " + resultLinkedList + " nanoseconds");

        start = System.nanoTime();
        arrayList.set(end, 0);
        finish = System.nanoTime();
        resultArrayList = finish - start;
        System.out.println("Set END [ArrayList]: " + resultArrayList + " nanoseconds");
        if(resultArrayList < resultLinkedList) System.out.println("Array list is better");else System.out.println("Linked list is better");
        if(resultArrayList < resultLinkedList) results.add("Set END: " + "Array list is better");else results.add("Set END: " + "Linked list is better");
        // --------

        System.out.println(" ---- ");

        // DELETE END
        start = System.nanoTime();
        linkedList.remove(l_length);
        finish = System.nanoTime();
        resultLinkedList = finish - start;
        System.out.println("Delete END [LinkedList]: " + resultLinkedList + " nanoseconds");

        start = System.nanoTime();
        arrayList.remove(a_length);
        finish = System.nanoTime();
        resultArrayList = finish - start;
        System.out.println("Delete END [ArrayList]: " + resultArrayList + " nanoseconds");
        if(resultArrayList < resultLinkedList) System.out.println("Array list is better");else System.out.println("Linked list is better");
        if(resultArrayList < resultLinkedList) results.add("delete end: " + "Array list is better");else results.add("delete end: " + "Linked list is better");
        // --------

        System.out.println(" ---- ");

        // GET START
        start = System.nanoTime();
        linkedList.get(0);
        finish = System.nanoTime();
        resultLinkedList = finish - start;
        System.out.println("get START [LinkedList]: " + resultLinkedList + " nanoseconds");

        start = System.nanoTime();
        arrayList.get(0);
        finish = System.nanoTime();
        resultArrayList = finish - start;
        System.out.println("get START [ArrayList]: " + resultArrayList + " nanoseconds");
        if(resultArrayList < resultLinkedList) System.out.println("Array list is better");else System.out.println("Linked list is better");
        if(resultArrayList < resultLinkedList) results.add("get START: " + "Array list is better");else results.add("get START: " + "Linked list is better");
        // --------

        System.out.println(" ---- ");

        // GET CENTER
        start = System.nanoTime();
        linkedList.get(center);
        finish = System.nanoTime();
        resultLinkedList = finish - start;
        System.out.println("get CENTER [LinkedList]: " + resultLinkedList + " nanoseconds");

        start = System.nanoTime();
        arrayList.get(center);
        finish = System.nanoTime();
        resultArrayList = finish - start;
        System.out.println("get CENTER [ArrayList]: " + resultArrayList + " nanoseconds");
        if(resultArrayList < resultLinkedList) System.out.println("Array list is better");else System.out.println("Linked list is better");
        if(resultArrayList < resultLinkedList) results.add("get CENTER: " + "Array list is better");else results.add("get CENTER: " + "Linked list is better");
        // --------

        System.out.println(" ---- ");

        // GET CENTER
        end = linkedList.size() - 1;
        start = System.nanoTime();
        linkedList.get(end);
        finish = System.nanoTime();
        resultLinkedList = finish - start;
        System.out.println("get END [LinkedList]: " + resultLinkedList + " nanoseconds");

        start = System.nanoTime();
        arrayList.get(end);
        finish = System.nanoTime();
        resultArrayList = finish - start;
        System.out.println("get END [ArrayList]: " + resultArrayList + " nanoseconds");
        if(resultArrayList < resultLinkedList) System.out.println("Array list is better");else System.out.println("Linked list is better");
        if(resultArrayList < resultLinkedList) results.add("get END: " + "Array list is better");else results.add("get END: " + "Linked list is better");
        // --------

        System.out.println(" ---- ");

        // ПЕРЕБОР В ПРЯМОМ ПОРЯДКЕ
        end = linkedList.size() - 1;
        start = System.nanoTime();
        for (int i = 0; i < linkedList.size(); i++) {
            linkedList.get(i);
        }
        finish = System.nanoTime();
        resultLinkedList = finish - start;
        System.out.println("перебор ПРЯМОЙ ПОРЯДОК [LinkedList]: " + resultLinkedList + " nanoseconds");

        start = System.nanoTime();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i);
        }
        finish = System.nanoTime();
        resultArrayList = finish - start;
        System.out.println("перебор ПРЯМОЙ ПОРЯДОК [ArrayList]: " + resultArrayList + " nanoseconds");
        if(resultArrayList < resultLinkedList) System.out.println("Array list is better");else System.out.println("Linked list is better");
        if(resultArrayList < resultLinkedList) results.add("перебор ПРЯМОЙ ПОРЯДОК: " + "Array list is better");else results.add("перебор ПРЯМОЙ ПОРЯДОК: " + "Linked list is better");
        // --------

        System.out.println(" ---- ");

        // ПЕРЕБОР В ОБРАТНОМ ПОРЯДКЕ
        end = linkedList.size() - 1;
        start = System.nanoTime();
        for (int i = linkedList.size() - 1; i >= 0; i--) {
            linkedList.get(i);
        }
        finish = System.nanoTime();
        resultLinkedList = finish - start;
        System.out.println("перебор ОБРАТНЫЙ ПОРЯДОК [LinkedList]: " + resultLinkedList + " nanoseconds");

        start = System.nanoTime();
        for (int i = linkedList.size() - 1; i >= 0; i--) {
            arrayList.get(i);
        }
        finish = System.nanoTime();
        resultArrayList = finish - start;
        System.out.println("перебор ОБРАТНЫЙ ПОРЯДОК [ArrayList]: " + resultArrayList + " nanoseconds");
        if(resultArrayList < resultLinkedList) System.out.println("Array list is better");else System.out.println("Linked list is better");
        if(resultArrayList < resultLinkedList) results.add("перебор ОБРАТНЫЙ ПОРЯДОК: " + "Array list is better");else results.add("перебор ОБРАТНЫЙ ПОРЯДОК: " + "Linked list is better");
        // --------

        System.out.println(" ---- ");

        // ПЕРЕБОР В ОБРАТНОМ ПОРЯДКЕ
        end = linkedList.size() - 1;
        start = System.nanoTime();
        for (int i = linkedList.size() - 1; i >= 0; i--) {
            if(linkedList.get(i) == 10) {
                System.out.println("YEP");
            }
        }
        finish = System.nanoTime();
        resultLinkedList = finish - start;
        System.out.println("проверка ЭЛЕМЕНТ ПУСТОЙ [LinkedList]: " + resultLinkedList + " nanoseconds");

        start = System.nanoTime();
        for (int i = linkedList.size() - 1; i >= 0; i--) {
            if(arrayList.get(i) == 5) {
                System.out.println("YEP");
            }
        }
        finish = System.nanoTime();
        resultArrayList = finish - start;
        System.out.println("проверка ЭЛЕМЕНТ ПУСТОЙ [ArrayList]: " + resultArrayList + " nanoseconds");
        if(resultArrayList < resultLinkedList) System.out.println("Array list is better");else System.out.println("Linked list is better");
        if(resultArrayList < resultLinkedList) results.add("проверка ЭЛЕМЕНТ ПУСТОЙ: " + "Array list is better");else results.add("проверка ЭЛЕМЕНТ ПУСТОЙ: " + "Linked list is better");
        // --------


        System.out.println(" ---- ");

        System.out.println("results: ");
        for(String res : results) {
            System.out.println(res);
        }
    }
}