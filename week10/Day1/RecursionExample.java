package Day1;

public class RecursionExample {

    /*
     * Recursion
     * - The process of of a function calling itself again and again until a desired outcome
     * 
     * - can lead to StackOverflowError
     * 
     * - we can prevent this by implementing a base case
     * 
     * - base case is our exit strategy (end of a road block), that lets us know when we've reached the end of out solution
     * 
     * Iterative
     * - anything you can do recursively, you can also do iteratively 
     * - use while loops to achieve the same goal
     * 
     */

    public static void doStuffRecursively() {
        System.out.println("Inside doStuff()");
        doStuffRecursively(); //this recursively calls itself
    } 

    public static int sumArrayRecursive(int[] nums, int index) {
        //base case
        if(index < 0 || nums == null || nums.length == 0) {
            return 0;
        }

        //totalSum is the value of the current index + the sum of everything that comes before it in the array
        int totalSum = nums[index] + sumArrayRecursive(nums, index - 1);
        System.out.println(totalSum);
        return totalSum;
    }

    public static int sumArrayIterative(int[] nums) {
        int sum = 0;
        if(nums == null) {
            return 0;
        }

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        //doStuffRecursively();
        int[] numbers = {8, 4, 10};
        int totalSum = sumArrayRecursive(numbers, numbers.length - 1);
        System.out.println("The total sum of the array done recursively is: " + totalSum);

        int sum = sumArrayIterative(numbers);
        System.out.println("The total sum of the array done iteratively is: " + sum);
    }
    
}
