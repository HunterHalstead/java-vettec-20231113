package com.skillstorm;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ReviewExecutorService {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		Runnable r = () -> 5; // doesn't work
		Callable<Integer> c = () -> 5;
//		Runnable r1 = () -> {throw new IOException();}; // doesn't work
		Callable<Object> r1 = () -> {throw new IOException();};
		Runnable r2 = () -> {throw new RuntimeException();};
		
		ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
		ScheduledFuture<?> result = service.schedule(()->{int x = 5;}, 1, TimeUnit.SECONDS);
		result.isCancelled();
		result.getDelay(TimeUnit.SECONDS);
		result.get();
		
	}

}
