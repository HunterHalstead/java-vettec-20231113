package day3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DoingLaundry {

    //you will have to wait for the washingMachine to be finished before you can put in another load
    //ReentrantLock() - allows threads to reenter into a lock on a resource
    public static Lock washerLock = new ReentrantLock();
    public static Lock dryerLock = new ReentrantLock();
    public static Lock folderLock = new ReentrantLock();
    public static void main(String[] args) {
        List<Laundry> laundryToDo = new ArrayList<>();
        laundryToDo.add(new Laundry("whites", "dirty"));
        laundryToDo.add(new Laundry("delicates", "dirty"));
        laundryToDo.add(new Laundry("bedding", "dirty"));

        Thread washer;
        Thread dryer;
        Thread folder;

        for(Laundry laundry : laundryToDo) {
            washer = new Thread(new WashingMachine(laundry));
            dryer = new Thread(new DryingMachine(laundry));
            folder = new Thread(new FoldingMachine(laundry));

            washer.start();
            dryer.start();
            folder.start();
        }
    }
}

class Laundry {
    String type;
    String status;  //dirty, washed, folded, dried

    public Laundry() { }

    public Laundry(String type, String status) {
        this.type = type;
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

class WashingMachine implements Runnable {

    Laundry currentLoad;
    public WashingMachine(Laundry currentLoad) {
        this.currentLoad = currentLoad;
    }

    @Override
    public void run() {

        //loop until the current load has been set to dirty
        while(!currentLoad.getStatus().equals("dirty")) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        DoingLaundry.washerLock.lock();

        System.out.println("The washing machine has started " + currentLoad.getType());

        try {
            //simulating the washer
            Thread.sleep(3000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The washing machine has finished " + currentLoad.getType());
        currentLoad.setStatus("washed");

        //once the load has finished, unlock the washer
        DoingLaundry.washerLock.unlock();
    }
    
}

class DryingMachine implements Runnable {

    Laundry currentLoad;
    public DryingMachine(Laundry currentLoad) {
        this.currentLoad = currentLoad;
    }

    @Override
    public void run() {

        //loop until the current load has been set to washed
        while(!currentLoad.getStatus().equals("washed")) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        DoingLaundry.dryerLock.lock();

        System.out.println("The drying machine has started " + currentLoad.getType());

        try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The drying machine has finished " + currentLoad.getType());
        currentLoad.setStatus("dried");

        DoingLaundry.dryerLock.unlock();
    }
    
}

class FoldingMachine implements Runnable {

    Laundry currentLoad;
    public FoldingMachine(Laundry currentLoad) {
        this.currentLoad = currentLoad;
    }

    @Override
    public void run() {

        //loop until the current load has been set to dried
        while(!currentLoad.getStatus().equals("dried")) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //will lock our folder
        DoingLaundry.folderLock.lock();

        System.out.println("The folding machine has started " + currentLoad.getType());

        try {
            //simulating the folding
            Thread.sleep(4000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }        

        System.out.println("The folding machine has finished " + currentLoad.getType());
        currentLoad.setStatus("folded");

        //once the load has finished, unlock the folder
        DoingLaundry.folderLock.unlock();
    }
    
}

/*
 * DEADLOCK
 *  - When two or more threads are waiting for each other to release a resource.
 *  - real world example:
 *      when you think your friend is going to give you a phone call, but your phone also thinks you're going to 
 *      give them a call, so no one calls and nothing happens
 * 
 * How to prevent and resolve deadlocks:
 *  - Avoid nested locks:
 *          Ensure that you only lock one resource at a time, or acquire locks in a specific order 
 *  - use lock timeouts:
 *          Set a timeout for aquiring locks and release themif the timeout expires
 * 
 * LIVELOCK:
 *  - When two or more threads keep on transferring states between one another instead of waiting infinitly
 *  - real world example:
 *       when you and a friend decided to meet up at a move theater. You are at movie theater A and your friend goes to movie theater B.
 *       you wonder where your friend is and walk to movie theater B, while your friend also wonders where you are and walks to movie 
 *       theater A. You don't take the same path and never run into eahcother. So you're stuck in this loop. 
 * 
 * How to prevent and resolve livelocks:
 *  - Wait for resources
 *  - Prioritize resources or threads
 *          
 * 
 */
