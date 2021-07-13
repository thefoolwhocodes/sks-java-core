package com.sks.javacore.concurrency.synchronizedblocks;

public class SyncronizedBlockInInstance {

    private class SyncronizedBlock {

        public void doWork1() {
            synchronized (this) {
                System.out.println("doWork1 - working for 10 seconds.");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("doWork1 - work done.");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void doWork2() {
            synchronized (this) {
                System.out.println("doWork2 - working for 10 seconds.");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("doWork2 - work done.");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    SyncronizedBlock object;

    SyncronizedBlockInInstance() {
        object = new SyncronizedBlock();
    }

    class MyRunnable1 implements Runnable {
        @Override
        public void run() {
            while (true) {
                object.doWork1();
            }
        }
    }

    class MyRunnable2 implements Runnable {
        @Override
        public void run() {
            while (true) {
                object.doWork2();
            }
        }
    }

    public void startDemo() {
        Thread t1 = new Thread(new MyRunnable1());
        t1.start();
        Thread t2 = new Thread(new MyRunnable2());
        t2.start();
    }

    public static void main(String[] args) {
        SyncronizedBlockInInstance demo = new SyncronizedBlockInInstance();
        demo.startDemo();
    }

}
