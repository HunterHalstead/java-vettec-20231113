package day5.MultiThreadingReview;

public class DeadLock {
    public static void main(String[] args) {
        
        Object resourceA = new Object();
        Object resourceB = new Object();

        //Thread1 is waiting on resourceB
        Thread thread1 = new Thread(() -> {
            synchronized(resourceA) {
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(resourceB) {
                    System.out.println("Thread 1: Locked ResourceB");
                }
            }
        });

        //Thread2 is waiting on resourceA
        Thread thread2 = new Thread(() -> {
            synchronized(resourceB) {
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(resourceA) {
                    System.out.println("Thread 2: Locked ResourceA");
                }
            }
        });

        thread1.start();
        thread2.start();

    }
}