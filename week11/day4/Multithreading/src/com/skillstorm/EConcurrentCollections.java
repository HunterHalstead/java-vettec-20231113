package com.skillstorm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

// Review - classes java.util.concurrency gives us for handling data consistency between threads
/*
 * AtomicInteger = makes sure reads and writes are atomic (happen as one operation not two seperate operations)
 * - get()
 * - getAndSet() - returns the old value and then sets it to a new value
 * - getAndIncrement() - equivalent of postfix increment operator
 * - incrementAndGet() - equivalent of prefix increment operator
 * - getAndDecrement() 
 * - decrementAndGet()
 */

/*
 * Concurrent Collections we have:
 * - ConcurrentHashMap
 * - ConcurrentLinkedDeque
 * - ConcurrentSkipListSet
 * - ConcurrentSkipListMap
 * - CopyOnWriteArrayList - on modification, it creates an entirely new copy of the underlying array
 * - CopyOnWriteArraySet     so only use CopyOnWrite classes if you know you are mainly reading not writing
 * - LinkedBlockingQueue
 * - LinkedBlockingDeque
 */
public class EConcurrentCollections {
	
	public static void main(String[] args) {
		// Option 1: Take a normal collection and turn it into a thread-safe "synchronized" collection
		
		// Option 2: Use java.concurrent class's Concurrent collection classes
		ConcurrentHashMap<String, Integer> population = new ConcurrentHashMap<>();
//		population.put("Los Angeles", 3_849_000);
//		population.put("Chicago", 2_697_000);
//		population.put("Philadelphia", 1_576_000);
//		
//		for (Entry<String, Integer> entry : population.entrySet()) {
//			System.out.println(entry.getKey() + " " + entry.getValue());
//			population.put(entry.getKey().substring(0, 1), entry.getValue());
//		}
//		System.out.println("-------------");
//		for (Entry<String, Integer> entry : population.entrySet()) {
//			System.out.println(entry.getKey() + " " + entry.getValue());
//		}
//		for (Entry<String, Integer> entry : population.entrySet()) {
//			population.remove(entry.getKey().substring(0, 1));
//		}
//		System.out.println("-------------");
//		for (Entry<String, Integer> entry : population.entrySet()) {
//			System.out.println(entry.getKey() + " " + entry.getValue());
//		}
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("Los Angeles", 3_849_000);
		map.put("Chicago", 2_697_000);
		map.put("Philadelphia", 1_576_000);
		map.put("L", 3_849_000);
		map.put("C", 2_697_000);
		map.put("P", 1_576_000);
		// Collections utility class has method to get a Synchronized version
		Map<String, Integer> synchronizedMap = Collections.synchronizedMap(map); 
		// only synchronized get and put operations to be atomic
		// does not allow concurrent modification
		// Exception in thread "main" java.util.ConcurrentModificationException
		Map<String, Integer> concurrentMap = new ConcurrentHashMap<>(map);
		for (String key : concurrentMap.keySet()) {
			map.remove(key.substring(0,1));
		}
		System.out.println(map);
	}
	
	
	
}
