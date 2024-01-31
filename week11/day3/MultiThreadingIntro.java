package day3;

public class MultiThreadingIntro extends Thread {

    /*
     * Threads
     *  - sequence of executed instructions
     *  
     * How to create a thread?
     *  - Extending the Thread class
     *  - Impleneting a Runnable Interface
     * 
     */
    private int threadNumber;
    public MultiThreadingIntro(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
     public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println(i + " from thread " + threadNumber);
            if(threadNumber == 2) {
                //throw new RuntimeException(); //won't affect the other threads
            }
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException e) {
                
            }
        }
        
     }

}