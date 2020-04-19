/*
 * This package demonstrates an example of basics of extending interfaces. 
 */

package com.sks.javacore.interfaces.extend;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.sleep();
        animal.sound();
        animal.eat();
    }

}
