/*
 * This class demonstrates the basics of ArrayListDemonstrator implementation of List interface.
 * ArrayListDemonstrator implementation is not synchronized.
 * Implements Serializable, Cloneable, Iterable<E>, Collection<E>, List<E>, RandomAccess.
 * Good practice to use ensureCapacity before adding large number of elements.
 */
package com.sks.javacore.collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemonstrator {

    private static void demonstrateArrayList()
    {
        System.out.println("Started - demonstrateArrayList");

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

        System.out.println("Finished - demonstrateArrayList");
    }

    public static void main(String[] args) {
        demonstrateArrayList();
    }

}
