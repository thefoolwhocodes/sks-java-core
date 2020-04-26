package com.sks.javacore.concurrency.locks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrentList {
    private List<Integer> list;
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();

    ConcurrentList(Integer...integers) {
        list = new ArrayList<Integer> ();
        list.addAll(Arrays.asList(integers));
    }

    public void add(Integer element, int recursionLevel) {
        rwLock.writeLock().lock();
        System.out.println("add aquired write lock, thread name: " + Thread.currentThread().getName());

        try {
            list.add(element);
            try {
                if (recursionLevel < 2) {
                    System.out.println("add aquired write lock recursion depth:" + recursionLevel + " thread name: " + Thread.currentThread().getName());
                    add(element+1, ++recursionLevel);
                }
                System.out.println("add aquired write lock and will sleep, thread name: " + Thread.currentThread().getName());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
        } finally {
            rwLock.writeLock().unlock();
            System.out.println("add released write lock, thread name: " + Thread.currentThread().getName());
        }
    }

    public void display() {
        rwLock.readLock().lock();
 
        try {
            System.out.println(list);
            System.out.println("display aquired read lock and will sleep, thread name: " + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
        } finally {
            rwLock.readLock().unlock();
        }
    }

    public int size() {
        Lock readLock = rwLock.readLock();
        readLock.lock();
 
        try {
            return list.size();
        } finally {
            readLock.unlock();
        }
    }
 
}
