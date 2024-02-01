package com.skillstorm;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FBlockingQueue {

	/*
	 * Producer-Consumer design pattern: - The consumer continuously takes elements
	 * from the queue and processes them, while the producer pushes them on
	 * 
	 * BlockingQueue - if the queue is full, the producer has to wait to add to it
	 */

	public static void main(String[] args) {
		Restaurant oliveGarden = new Restaurant();
		oliveGarden.open();
	}

}

class Waitress implements Runnable {
	private final BlockingQueue<String> orderQueue;
	private final Scanner in;

	public Waitress(BlockingQueue<String> orderQueue, Scanner in) {
		this.orderQueue = orderQueue;
		this.in = in;
	}

	@Override
	public void run() {
		try {
			// Simulate taking food orders from customers through console input
			System.out.println(">>>>>>>>>>>>>>>>>");
			System.out.println("What would you like to order? (Enter comma separated list on one line)");
			String order = in.nextLine();

			// Put the customer order into the order queue
			for (String dish : order.split(",")) {
				boolean successfullyAdded = orderQueue.offer(dish, 2, TimeUnit.SECONDS);
				if (!successfullyAdded)
					System.out.println("Sorry, we are not accepting anymore orders at this time");
				else
					System.out.println("Order recieved - " + dish);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

class Cook implements Runnable {
	private final BlockingQueue<String> orderQueue;

	public Cook(BlockingQueue<String> orderQueue) {
		this.orderQueue = orderQueue;
	}

	@Override
	public void run() {
		try {
			while (true) {
				// Take an order from the order queue
				String order = orderQueue.poll(5, TimeUnit.SECONDS); // or can hand it a timeout
				if (order != null) {
					// Simulate cooking the dish with a delay
					Thread.sleep(2000);
					// Print "Order up" to indicate the dish is ready
					System.out.println("<<<<<<<<<<<<<<<<<");
					System.out.println("Order up - " + order);
				}
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}

class Restaurant {
	public void open() {
		// Creating a LinkedBlockingQueue for orders
		BlockingQueue<String> orders = new ArrayBlockingQueue<>(10);
		System.out.println(orders.size());

		// Creating a waitress and cook
		Scanner in = new Scanner(System.in);
		Waitress waiter1 = new Waitress(orders, in); // runnable

		Cook cook1 = new Cook(orders);
		Cook cook2 = new Cook(orders);

		// Start a executorservice
		ScheduledExecutorService service = null;
		try {
			service = Executors.newScheduledThreadPool(3);
			// Starting waitress and cook threads
			Future<?> future = service.scheduleWithFixedDelay(waiter1, 0, 1, TimeUnit.MINUTES);
			service.submit(cook1);
			service.submit(cook2);
//			service.scheduleAtFixedRate(new Tick(), 0, 1, TimeUnit.SECONDS);
			future.get(); // this should join to main WHEN the waiter thread ends
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} finally {
			if (service != null)
				service.shutdown();
		}

		try {
			service.awaitTermination(8, TimeUnit.HOURS); // 8 hours we take orders during the day
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

class Tick implements Runnable {

	@Override
	public void run() {
		System.out.println("-");
	}

}