package com.skillstorm;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DSchedulingTasks {
	private static int unreadEmails = 10;
	public static void main(String[] args) {
		// ScheduledExecutorService 
		// - schedule to happen once in the future or repeatedly at given intervals
		
		// Methods:
		// - schedule(runnable, delay, timeunit)
		// - schedule(callable, delay, timeunit)
		// - scheduleAtFixedRate(runnable, initialdelay, delay, timeunit)
		// - scheduleAtFixedDelay(runnable, initialdelay, delay, timeunit)
		
		// Example: run every hour = fixed rate
		// 2pm
	    // 3pm
		// 4pm
		// 5pm 
		
		// If the task takes half an hour, only run every hour since finished = fixed delay
		// 2pm-2:30
		// 3:30-4
		// 5-5:30
		// 6:30
		
		////////////////////////////////////////////////////////////////////
		// Step 1: create executor
		// Step 2: schedule some tasks
		// step 3: shutdown the executor
		// 
		// main instead of .get on one task, can wait for all tasks using
		// method:
		// service.awaitTermination(30, TimeUnit.SECONDS)
		
		ScheduledExecutorService service = null;
		try {
			service = Executors.newScheduledThreadPool(10);
			Runnable task = () -> {
				System.out.println("Checking email");
				unreadEmails = unreadEmails > 5 ? unreadEmails - 5 : 0;
				System.out.println("Unread emails now " + unreadEmails);
			};
			
			Runnable task2 = () -> {
				// Add to the unread emails
				System.out.println("Querying email server");
				int newEmails = new Random().nextInt(10);
				unreadEmails += newEmails;
				System.out.println("Unread emails now " + unreadEmails);
			};
			
			
			service.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);
			service.scheduleAtFixedRate(task2, 1, 1, TimeUnit.SECONDS);
			
		} finally {
			if (service != null)
				service.shutdown();
		}
		try {
			service.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			System.out.println("Stopping tasks");
		}
		System.out.println("End of main");
	}
}