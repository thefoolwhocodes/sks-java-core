/*
 * This class demonstrates the basics of HashMap.
 */
package com.sks.javacore.collections.hashmap;

import java.util.HashMap;

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

    public static void main(String[] args) {
        put();
        replaceAll();
    }
}
