package Day2;

import java.util.Random;

public class BubbleSort {

    /*
     * Bubble Sort
     * - simple sorting algorithm that compares adjacent elements of an array and swaps them if the element on the right is smaller
     *   than the element on the left
     * 
     * - time complexity is O(n^2) - slow, not good
     * 
     * - not efficient for large data sets
     * 
     */
    public static void main(String[] args) {

        Random rand = new Random();

        int[] numbers = new int[100000];

        //iterates through the array and fills it up with int between 0 and 1000
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1000);
        }

        System.out.println("Before Bubble Sort: ");
        printArray(numbers);

        boolean swappedSomething = true;

        while(swappedSomething) {
            swappedSomething = false;

            //iterates through the array up to the 2nd to last element 
            for(int i = 0; i < numbers.length - 1; i++) {
                //checks if current index is > the next index
                if(numbers[i] > numbers[i + 1]) {
                    swappedSomething = true;
                    //set a temp variable to store the value of our current index
                    int temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                }
            }
        }

        System.out.println("\nAfter Bubble Sort: ");
        printArray(numbers);

    }

    private static void printArray(int[] numbers) {
        for(int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
