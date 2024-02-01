package com.skillstorm;

import java.security.DomainCombiner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BCallable {
	
	// Callable is an interface like Runnable 
	// -- overcomes limitations of Runnable (no return value, can't throw exceptions)
	// except it's method is 
	// E run() throws Exception
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<Integer> result = service.submit(() -> {
				int counter = 1;
				for (int i = 0; i < 10; i++) {
					counter++;
				}
				return counter;
			});
			System.out.println(result.get());
		} finally {
			if (service != null)
				service.shutdown();
		}
		// Step 1: Create an instance of executor service
		// Step 2: hand it tasks 
		//   - .execute(Runnable): void
		//   - .submit(Runnabble): Future
		//   - .submit(Callable): Future
		// Step 3; shut it down
				
	}

}
