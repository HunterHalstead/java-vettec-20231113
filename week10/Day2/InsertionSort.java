package Day2;

import java.util.Random;

public class InsertionSort {
    /*
     * Insertion Sort
     * - sorting algorithm that is split into a sorted and unsorted list. Where elements from the unsorted list are inserted
     *   into the sorted list in the correct position
     *      - works similarly to a sorting through a deck of cards
     * 
     * - time complexity is O(n^2)
     *      - best case is O(n), when array is already sorted
     * 
     * 
     */
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10000];//took 30ms
        //int[] numbers = new int[1000000]; //took 418884ms

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before Insertion Sort:");
        printArray(numbers);

        long startTime = System.currentTimeMillis();
        insertionSort(numbers);
        long endTime = System.currentTimeMillis();

        System.out.println("After Insertion Sort:");
        printArray(numbers);

        System.out.println("took " + (endTime - startTime) + "ms");
    }

    private static void insertionSort(int[] inputArray) {
        //no need to start is the first index, bc it is already sorted
        for(int i = 1; i < inputArray.length; i++) {
            int currentValue = inputArray[i];

            int j = i - 1;

            /*
             * Will walk back to the beginning of the array and only stop if we've hit the beginning of the array or if we 
             * run into a value that is <= to the current value that we want to insert
             */
            while(j >= 0 && inputArray[j] > currentValue) {
                //for each element that we run into that is > than the current value, we need to shift to the right 
                inputArray[j + 1] = inputArray[j]; 
                j--;
            }
            inputArray[j + 1] = currentValue;
        }
    }

    private static void printArray(int[] numbers) {
        for(int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
