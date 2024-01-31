package day3;

public class MultiThreadingPractice {
    /*
     * Multi-Threading
     *      -> splitting different taks onto multiple threads to be done concurrently
     *      -> by default we have the single main thread that gets ran
     *  
     *      Doing your laundry
     *          washer -> dryer -> fold
     *              no sense in waiting for one load to be folded before putting a 2nd in the washer
     * 
     *      trade-off: performance speed vs power usage
     *          - will use more resources while its running, but will be done faster
     * 
     * 
     *      Thread States
     *          1. NEW - created but not yet started (new Thread())
     *          2. RUNNABLE - thread has started (thread.start())
     *          3. BLOCKED - thread is waiting on some lock before continuing
     *          4. WAITING - thread waiting indefinitely (thread.join() or thread.wait())
     *          5. TIMED-WAITING - thread waiting for a specified amount of time (thread.join(3000))
     *          6. TERMINATED - thread is finished
     */

    public static void main(String[] args) {
        RunnableTask task1 = new RunnableTask("Task 1");
        RunnableTask task2 = new RunnableTask("Task 2");
        RunnableTask task3 = new RunnableTask("Task 3");

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

/*
 * Runnable Interface
 *      -> a functional interface fpr defining how a thread will run
 *              a funcional interface is just an interface with 1 method
 * 
 *      -> Runnable Interface vs Thread Class
 *          - Runnable Interface allows you to extend any other class and implemenet mulitple interfaces
 *          - Thread Class limits you to only extending one class
 */

 class RunnableTask implements Runnable {

    private String taskName;

    public RunnableTask(String taskName) {
        this.taskName = taskName;
    }

    //run() - is where define what the thread will do while its running
    @Override
    public void run() {
        System.out.println("Task " + taskName + " is running in " +
                                Thread.currentThread().getName());

        System.out.println("Task " + taskName + " has finished!");
    }
 }
