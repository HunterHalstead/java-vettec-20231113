package day3;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPractice {
    
    /*
     * every thread has it's own stack
     *      so things like methods and instance variables, each thread will have its own copy of
     *      
     * volatile - synchronization across threads won't block
     *            the other threads from manipulatin gthe variable
     * 
     * static - means that there is only 1 reference in memory
     */
     private static volatile int count = 0;

    /*
     * Atomic Values
     *      -> bascially mean "all at once" and "all or none"
     * 
     * 
     *      -> AtmoicInteger, AtomicDouble etc
     *              - creates a thread safe version of the primitive type
     * 
     *      -> all methods are atomic by default
     */

     private static AtomicInteger atomicCount = new AtomicInteger(0);

     //Synchronized - makes any resource or method thread-safe
     public static synchronized void increment() {
        count++;
        atomicCount.incrementAndGet();
     }

     public static void main(String[] args) {
        CustomThread t1 = new CustomThread(10000000);
        CustomThread t2 = new CustomThread(10000000);

        t1.start();
        t2.start();

        try {
            Thread.sleep(10);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Current count is " + count);
        System.out.println("Current atomic count is " + atomicCount);

        try {
            //telling main to wait for these threads to finish
            t1.join();
            t2.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Total count is " + count);
        System.out.println("Total atomicCount " + atomicCount);

     }
}

class CustomThread extends Thread {
    private int loopAmount;

    public CustomThread(int loopAmount) {
        this.loopAmount = loopAmount;
    }

    public void run() {
        for(int i = 0; i < loopAmount; i++) {

            //increments count and atomicCount
            ThreadPractice.increment();
        }
    }
}
