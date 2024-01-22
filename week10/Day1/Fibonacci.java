package Day1;

public class Fibonacci {
    /*
     * Fibonacci
     * - A sequence of numbers that starts with 0 and 1, and each number after it is a sum of the two previous numbers
     * 
     * 0   1   1    2   3   5   8   13  21
     * 
     * f(n) = f(n - 1) + f(n - 2)
     * 
     * f(8) = f(7) + f(6)
     * f(7) = f(6) + f(5)
     * f(6) = f(5) + f(4)
     * f(5) = f(4) + f(3)
     */

    public static void main(String[] args) {
        int n = 5;

        System.out.println(fibonacci(n));

        System.out.println(fibonacci(-3));
        
    }
    private static long fibonacci(int n) {
        //base case
        if(n <= 1) {
            return n;
        }
        return(fibonacci(n - 1) + fibonacci(n - 2));
    }
}
