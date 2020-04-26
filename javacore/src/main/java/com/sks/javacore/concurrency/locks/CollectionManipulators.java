package com.sks.javacore.concurrency.locks;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

public class CollectionManipulators {
    private ExecutorService readerService;
    private ExecutorService writerService;
    private ConcurrentList list;
    private Random random;
    private int readersCount;
    private int writersCount;

    private static CollectionManipulators instance = null;
    private volatile boolean running = false;

    private CollectionManipulators() {}

    public static CollectionManipulators getInstance() {
        if (instance == null) {
            synchronized(CollectionManipulators.class) {
                if (instance == null) {
                    instance = new CollectionManipulators();
                }
            }
        }
        return instance;
    }

    public synchronized void startUp() {
        running = true;
        list = new ConcurrentList();
        random = new Random();
        readersCount = 2;
        writersCount = 2;

        ThreadFactory namedReaderThreadFactory = new ThreadFactoryBuilder().setNameFormat("DistributedLog-Reader-Thread-%d").build();
        readerService = Executors.newFixedThreadPool(10, namedReaderThreadFactory);

        for (int i=0 ; i < readersCount ; i ++) {
            readerService.execute(new Reader());
        }

        ThreadFactory namedWriterThreadFactory = new ThreadFactoryBuilder().setNameFormat("DistributedLog-Writer-Thread-%d").build();
        writerService = Executors.newFixedThreadPool(10, namedWriterThreadFactory);
        for (int i=0 ; i < writersCount ; i ++) {
            writerService.execute(new Writer());
        }
    }

    class Reader implements Runnable {
        public void run() {
            System.out.println("Started Reader thread: " + Thread.currentThread().getName());
            while (running) {
                list.display();
                System.out.println("Iterating: " + Thread.currentThread().getName());
            }
        }
    }

    class Writer implements Runnable {
        public void run() {
            System.out.println("Started Writer thread: " + Thread.currentThread().getName());
            while (running) {
                list.add(random.nextInt(100),0);
                System.out.println("Iterating: " + Thread.currentThread().getName());
            }
        }
    }
}
