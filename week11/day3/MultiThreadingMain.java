package day3;

public class MultiThreadingMain {
    public static void main(String[] args) {

        for(int i = 0; i < 5; i++) {
            MultiThreadingIntro myThread = new MultiThreadingIntro(i);
            myThread.start();
        }
        //MultiThreadingIntro myThread = new MultiThreadingIntro();
        //MultiThreadingIntro myThread2 = new MultiThreadingIntro();

        //start() - allows you to run multiple concurrent threads
        //myThread.start();
        //myThread2.start();

        //run() - will not execute at the same time!
        //myThread.run();
        //myThread2.run();
    }
}
