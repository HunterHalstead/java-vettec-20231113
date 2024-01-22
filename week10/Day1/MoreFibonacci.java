package Day1;

public class MoreFibonacci {
    /*
     * We want to store all the known fibonacci number
     *  - refered to as Memoization
     *  - can think of it as "memorization" or caching 
     * 
     * - cache these operations, so that we only do it once
     */


    private static Long[] fibs = new Long[1000];

    /*
     * Static block is used to execute code as soon as a file is loaded
     * - Initializing static values
     */
    static {
        fibs[0] = (long) 0;
        fibs[1] = (long) 1;
    }

    public static long fibonacci(int n) {
        if(n <= 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }

        long fibMinus1;
        long fibMinus2;

        if(fibs[n - 1] != null) {
            //already have the fibonacci number and we can use it
            fibMinus1 = fibs[n - 1];
            
        } else {
            //if we dont have the fibonacci number
            //we need to calculate it
            fibMinus1 = fibonacci(n - 1);
            //once i have it, then we memoize it
            fibs[n - 1] = fibMinus1;
        }

        if(fibs[n - 2] != null) {
            //already have the fibonacci number and we can use it
            fibMinus2 = fibs[n - 2];
            
        } else {
            //if we dont have the fibonacci number
            //we need to calculate it
            fibMinus2 = fibonacci(n - 2);
            //once i have it, then we memoize it
            fibs[n - 2] = fibMinus2;
        }

        long answer = fibMinus1 + fibMinus2;
        fibs[n] = answer;
        return answer;
    }

    public static long fibonacciNoMemo(int n) {
        if(n <= 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }

        return fibonacciNoMemo(n -1) + fibonacciNoMemo(n -2);
    }
    public static void main(String[] args) {
        System.out.println("Calculating fibonacci number with memoization: " + fibonacci(8));
        System.out.println(fibonacci(50));
        System.out.println(fibonacci(180));

        System.out.println("Calculating fibonacci number without memoization: " + fibonacciNoMemo(8));
        System.out.println(fibonacciNoMemo(50));
    }
}
