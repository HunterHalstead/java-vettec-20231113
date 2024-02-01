package com.skillstorm;

public class CThreadPools {
	
	/**
	 * newSingleThreadExecutor()	ExecutorService	
	 *    
	 *   
	 * newSingleThreadScheduledExecutor()	ScheduledExecutorService	
	 *    
	 *    
	 * newCachedThreadPool()	ExecutorService	
	 *   Creates as many threads as needed for the tasks given, then caches the thread to be reused
	 *   so when given a tack, this thread pool looks in the cache for an available thread or creates a new thread
	 *   Warning: it can grow out of control
	 *    
	 * newFixedThreadPool(int nThreads)	ExecutorService	
	 *    Creates a set number of threads, so sometimes tasks are going to have to wait
	 *    Suggestion: 10 is a good number 
	 *    
	 * newScheduledThreadPool(int nThreads)	ScheduledExecutorService	
	 *    
	 */
	
	
	// Need multithreading everywhere such as to stop the program when I hit an infinite loop
	// I can't have the terminate button wait till the loop ends
//	public static void main(String[] args) {
//		while (true)
//			System.out.println("hello");
//	}

}
