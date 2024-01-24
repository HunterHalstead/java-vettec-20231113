package Day1;

public class Recursion {
    public static void main(String[] args) {

        sayHey(3);
    }

    private static void sayHey(int count) {
        System.out.println("HEY");    
        //sayHey();

        /*
         * Implement an "exit" strategy
         *  - create a base case: just a condition inside a method where it can return without making another recursive call
         *  - have code that allows the program to work toward the base case
         * 
         * Need these 2 elements to prevent StackOverFlowError
         * 
         */

        //Base case
        if(count <= 1) {
            return;
        }

        //each time a recursive call is made, count will decrease by 1
        //will eventually reach the base case
        sayHey(count - 1);
    }

    /*
     * Recursion
     * - Calling a function within a function
     * 
     * StackOverflowError
     * - if your call stack grows too much it will overflow
     * 
     */
}