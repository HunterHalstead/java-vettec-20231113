# Week 11 ExecutorService Review

On Monday's multithreading exam, you will need to know how to create and work with thread directly as well as how to work with the Collections API ExcecutorService. 

Below are the classes and methods to be familiar with. These notes are also covered in the GitHub repo files:

- [AExecutorService.java](https://github.com/ericahicks/java-vettec-20231113/blob/main/week11/day4/Multithreading/src/com/skillstorm/AExecutorService.java)
- [BCallable.java](https://github.com/ericahicks/java-vettec-20231113/blob/main/week11/day4/Multithreading/src/com/skillstorm/BCallable.java)
- [CThreadPools.java](https://github.com/ericahicks/java-vettec-20231113/blob/main/week11/day4/Multithreading/src/com/skillstorm/CThreadPools.java)
- [DSchedulingTasks.java](https://github.com/ericahicks/java-vettec-20231113/blob/main/week11/day4/Multithreading/src/com/skillstorm/DSchedulingTasks.java)


## ExecutorService

### Creating an ExecutorService object

 Executors factory methods:
- newSingleThreadExecutor()	ExecutorService	
- newSingleThreadScheduledExecutor()	ScheduledExecutorService	
- newCachedThreadPool()	ExecutorService	
   - Creates as many threads as needed for the tasks given, then caches the thread to be reused, so when given a task, this thread pool looks in the cache for an available thread or creates a new thread
   - Warning: it can grow out of control
- newFixedThreadPool(int nThreads)	ExecutorService	
   - Creates a set number of threads, so sometimes tasks are going to have to wait
   - Suggestion: 10 is a good number 
- newScheduledThreadPool(int nThreads)	ScheduledExecutorService

### Submitting tasks to the ExecutorService

 - execute(runnable) void
 - submit(runnable) Future<E>
 - submit(callable) Future<E>
 
### Waiting for tasks to complete

 - Use the Future<E> object returned by .submit() 
``` 
future.get(); 
```
 - Use the service object itself to await all the tasks in the service to finish 
```
awaitTermination(long, TimeUnit)
```

## Runnable vs Callable

Runnable and Callable are both functional interfaces that can be used to define a task to be run in a thread.

Runnable has one method
 ``` void run() ```
Note,  
 - does not take in any parameters
 - does not return a value
 - cannot throw any checked exceptions (can throw RuntimeExceptions)

Callable has one method
``` E call() throws Exception ```
Note, 
 - does not take in any paramters
 - returns a value of any type
 - can throw any exception including checked exceptions


## Future

A Future is an object that holds information about a task. It has useful methods for getting the current state, canceling the task, or getting the value returned by the task.

   .get() 
   .get(long, timeunit)
   .cancel()
   .isDone()
   .isCanceled()
   .cancel()

To read more see [the java docs]().

> A Future represents the result of an asynchronous computation. Methods are provided to check if the computation is complete, to wait for its completion, and to retrieve the result of the computation. The result can only be retrieved using method get when the computation has completed, blocking if necessary until it is ready. Cancellation is performed by the cancel method. Additional methods are provided to determine if the task completed normally or was cancelled. Once a computation has completed, the computation cannot be cancelled. If you would like to use a Future for the sake of cancellability but not provide a usable result, you can declare types of the form Future<?> and return null as a result of the underlying task.

### Using Future


```
  Future<?> result1 = service.submit(runnable) -- note runnables return nothing 
  result1.get(); // waits endlessly to get the returned value
                // always going to return null for runnables
  Future<Integer> result2 = service.submit(callable);
  result2.get(); // waits endlessly to get the returned value
                 // the data type the  callable function returns
  result2.get(long, TimeUnit.SECONDS); // waits set time
                                       // throws TimeoutException 
```

### Discussion:

Can the lambda expressions below be used as a Runnable, Callable, both, or neither?

```
 (x) -> x++ // 1
 () -> 5 // 2
 () -> throw new RuntimeException() // 3 
 () -> throw new IOException() // 4
```

Answers:

```
// 1 Neither because it takes in a parameter
// 2 Callable becaused implicit return statement returns a value
// 3 Either because Runnable can throw unchecked exceptions
// 4 Callable because only callable can throw checked exceptions
```


## Scheduling

ScheduledExecutorService

```
schedule(runnable, long, TimeUnit) // returns Future specifically ScheduledFuture
schedule(callable, long, TimeUnit)
scheduleAtFixedRate(runnable, long, long, TimeUnit)
scheduleWithFixedDelay(callable, long, long, TimeUnit)
```

(ScheduledFuture is a subtype of Future that has a method to `.getDelay(TimeUnit)`)

Note the difference between fixed-rate and fixed-delay. Example,
  - Fixed-rate - An hour since it last started (every hour on the hour)
  - Fixed-delay - An hour since it last finished (takes into account time taken to run)

Note the fixed-rate and fixed-delay only accept a Runnable. Wherea schedule can accept a Runnable or Callable argument.
