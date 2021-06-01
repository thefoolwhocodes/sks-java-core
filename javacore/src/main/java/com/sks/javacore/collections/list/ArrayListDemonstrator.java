/*
 * This class demonstrates the basics of ArrayListDemonstrator implementation of List interface.
 * ArrayListDemonstrator implementation is not synchronized.
 * Implements Serializable, Cloneable, Iterable<E>, Collection<E>, List<E>, RandomAccess.
 * Good practice to use ensureCapacity before adding large number of elements.
 */
package com.sks.javacore.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemonstrator {

    /**
     * Demonstration for ways to iterate over the list
     */
    private static void demonstrateArrayList1()
    {
        System.out.println("Started - demonstrateArrayList1");

        List<String> list = new ArrayList<String>(4);
        list.add("Amazon");
        list.add("Google");
        list.add("ThoughtWorks");
        list.add("Adobe");

        for (int i=0 ; i < list.size(); i++) {
            System.out.println("Element at index[" + i + "] is: " + list.get(i));
        }

        for(String element: list) {
            System.out.println("Element: " + element);
        }

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println("Iterator's Element: " + iterator.next());
        }

        list.forEach((elements) -> {
            System.out.println("forEach's Element: " + elements);
        });

        list.stream().forEach((elements) -> {
            System.out.println("stream forEach's Element: " + elements);
        });

        System.out.println("Finished - demonstrateArrayList1");
    }

    public static void printList(List<String> accounts) {
        for (String item : accounts) {
            System.out.println(item);
        }
    }

    /**
     * Demonstration to initialize list in one line
     */
    public static void demonstrateArrayList2() {
        System.out.println("Started - demonstrateArrayList2");

        printList(Arrays.asList(new String[] { "data1", "data2" }));

        System.out.println("Finished - demonstrateArrayList2");
    }
    
    public static void main(String[] args) {
        demonstrateArrayList1();
        demonstrateArrayList2();
    }

}
