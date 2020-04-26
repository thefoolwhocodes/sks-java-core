/*
 * This package demonstrates an example of ReentrantReadWriteLock.
 * In the example it is also shown that how a thread can take lock multiple times that is
 * called as Reentrant. 
 */

package com.sks.javacore.concurrency.locks;

public class Main {

    public static void main(String[] args) {
        CollectionManipulators.getInstance().startUp();
    }

}
