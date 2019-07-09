package com.sks.javacore.ExecutorService;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionException;

/*
 * The java.util.concurrent.ThreadPoolExecutor is an implementation of the ExecutorService interface.
 * The ThreadPoolExecutor executes the given task (Callable or Runnable) using one of its internally pooled threads.
 */
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

public class ThreadPoolExecutorDemo {
    private ThreadPoolExecutor INDEX_EXECUTOR;
    private Thread workProducer;
    private static final int workCount = 20;

    public ThreadPoolExecutorDemo() {
        int corePoolSize = 5;
        int maxPoolSize = 5;
        long keepAliveTime = 5000;
        INDEX_EXECUTOR = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(maxPoolSize),
                new ThreadFactoryBuilder().setNameFormat("IndexExecutor-%d").setDaemon(true).build());
        INDEX_EXECUTOR.prestartAllCoreThreads();
        INDEX_EXECUTOR.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        workProducer = new Thread(new WorkProducer());
    }

    public void startDemo() {
        workProducer.start();
    }

    public static void main(String[] args) {
        ThreadPoolExecutorDemo demo = new ThreadPoolExecutorDemo();
        demo.startDemo();
    }

    class WorkProducer implements Runnable {
        public void run() {
            while (true) {
                System.out.println("-----Going to produce " + workCount + " works-----");
                for (int i = 0; i < workCount; i++) {
                    try {
                        INDEX_EXECUTOR.submit(new Tasks(i));
                    } catch (RejectedExecutionException e) {
                        // Exception could arise when the Executor cannot take any more tasks under its responsibility.
                        // If we try to submit more tasks than the ArrayBlockingQueue can hold, then 
                        // RejectedExecutionException arises.
                        System.out.println("WorkProducer - RejectedExecutionException" + e);
                    }
                }
                System.out.println("-----Produced " + workCount + " works-----");
                try {
                    System.out.println("Going to sleep for 5 seconds");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("WorkProducer - InterruptedException occurred");
                }
            }
        }
    }

    class Tasks implements Runnable {
        private int _taskId;

        public Tasks(int taskId) {
            _taskId = taskId;
        }
        public void run() {
            System.out.println("Started running task " + _taskId);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("Tasks - InterruptedException");
            }
            System.out.println("Completed running task " + _taskId);
        }
    }
}
