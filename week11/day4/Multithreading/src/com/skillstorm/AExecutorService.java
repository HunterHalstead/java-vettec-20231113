package com.skillstorm;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AExecutorService {
	
	// An ExecutorService creates and manages threads for you
	
	// Types of threads:
	//  User-created threads - non-daemon threads normally Ex: main-method thread
	//  System threads - for example, garbage collection - daemon threads
	
	public static void main(String[] args) {
		example2();
	}
	
	private static int counter;
	public static void example2() {
		ExecutorService service = null;
		// .submit(Runnable): Future<E> 
		// we can check the future's state
		// boolean isDone()
		// boolean isCanceled()
		// 
		// V get() -- null since Runnnable does not return anything
		// V get(long timeout, timeunit)
//		int count = 0; // only effectively final local variables are accessible in the lambda (anonymous class)
		try {
			service = Executors.newSingleThreadExecutor();
			Future<?> future = service.submit(() -> {
				/////////////////////////////////////////////// new-thread
				for (int i = 0; i < 10000; i++)
					System.out.println(++counter);
				System.out.println();
				//////////////////////////////////////////////
			});
			future.get(1, TimeUnit.MILLISECONDS); // main-thread waits for new-thread
			System.out.println("Done, counter=" + counter);
		} catch (InterruptedException e) {
			System.out.println("Something went wrong");
		} catch (ExecutionException e) {
			System.out.println("Something went wrong");
		} catch (TimeoutException e) {
			System.out.println("Timed out");
		} finally {
			// always shutdown your servic ein a finally block
			if (service != null)
				service.shutdown();
		}
		System.out.println("End main");
	}
	
	public static void example1() {
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().isDaemon());
		
		// Use a ExecutorService
		// Uses the factory pattern so don't call the constructor call the static method on Executors
		ExecutorService service = null;
		// .execute(Runnable)
		try {
			service = Executors.newSingleThreadExecutor();
			service.execute(() -> System.out.println(Thread.currentThread().getName() + " says hi!"));
			service.execute(() -> {for (int i = 0; i < 10; i++) System.out.println("i=" + i);});
			
		} finally {
			// always shutdown your servic ein a finally block
			if (service != null)
				service.shutdown();
		}
		System.out.println("End main");
	}

}
