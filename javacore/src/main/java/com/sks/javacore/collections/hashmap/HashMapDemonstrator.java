/*
 * This class demonstrates the basics of HashMap.
 */
package com.sks.javacore.collections.hashmap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;

public class HashMapDemonstrator {

    private static void put() {
        System.out.println("Started - put");

        HashMap<Integer, Integer> objHM = new HashMap<Integer, Integer>();
        objHM.put(1, 10);
        objHM.put(2, 20);
        System.out.println(objHM);

        System.out.println("Finished - put");
    }

    private static void replaceAll() {
        System.out.println("Started - replaceAll");

        HashMap<Integer, Integer> objHM = new HashMap<Integer, Integer>();
        objHM.put(1, 10);
        objHM.put(2, 20);
        objHM.replaceAll((k, v) -> v = v + 1);
        System.out.println(objHM);

        System.out.println("Finished - replaceAll");
    }

    /**
     * Demonstration of BiFunction usage during replaceAll.
     */
    private static void replaceAllByFilter() {
        System.out.println("Started - replaceAllByFilter");

        Collection<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(5);

        {
            System.out.println("Started - replaceAllByFilter - example 1 - explicit BiFunction");
            HashMap<Integer, Integer> objHM = new HashMap<Integer, Integer>();
            objHM.put(1, 10);
            objHM.put(2, 20);
            objHM.put(3, 30);
            objHM.put(4, 40);
            objHM.put(5, 50);

            BiFunction<Integer, Integer, Integer> function1 = (s1, s2) -> {
                if (list.contains(s1))
                    return s2 + 1;
                else
                    return s2;
            };

            objHM.replaceAll(function1);
            System.out.println(objHM);
        }

        {
            System.out.println("Started - replaceAllByFilter - example 2 - implicit BiFunction");
            HashMap<Integer, Integer> objHM = new HashMap<Integer, Integer>();
            objHM.put(1, 10);
            objHM.put(2, 20);
            objHM.put(3, 30);
            objHM.put(4, 40);
            objHM.put(5, 50);

            objHM.replaceAll((s1, s2) -> {
                if (list.contains(s1))
                    return s2 + 1;
                else
                    return s2;
            });

            System.out.println(objHM);
        }

        System.out.println("Finished - replaceAllByFilter");
    }

    private static void addUpdateAllByFilter() {
        System.out.println("Started - addUpdateAllByFilter");

        Collection<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(5);
        list.add(9);

        HashMap<Integer, Integer> objHM = new HashMap<Integer, Integer>();
        objHM.put(1, 10);
        objHM.put(2, 20);
        objHM.put(3, 30);
        objHM.put(4, 40);
        objHM.put(5, 50);

        objHM.replaceAll((k, v) -> {
            if (list.contains(k))
                return v + 1;
            else {
                return v;
            }
        });

        list.forEach(e -> {
            if (!objHM.containsKey(e))
                objHM.put(e, 1);
        });

        System.out.println(objHM);

        System.out.println("Finished - addUpdateAllByFilter");
    }

    private static void lambdaErrorExplanation() {
        List<String> list = new ArrayList<String>();
        list.add("name");
        list.add("age");
        list.add("address");

        boolean flag = true;
        flag = false;

        {
            flag = true;
        }

        /*
         * list.stream().forEach(e -> { //error Local variable flag defined in an
         * enclosing scope must be final or effectively final if (flag) {
         * System.out.println(e); } });
         */
    }

    public static void main(String[] args) {
        put();
        replaceAll();
        replaceAllByFilter();
        addUpdateAllByFilter();
        lambdaErrorExplanation();
    }
}
