package Day2;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    /*
     * Selection Sort
     * - sorting algorithm that works by repeatedly selection the smallest element from an unsorted list and moving it to 
     *   a sorted list
     * 
     * - time complexity is O(n^2)
     * 
     * - best for small data sets
     */
    public static void main(String[] args) {

        Random rand = new Random();

        int[] numbers = new int[10000];//took 28ms
        //int[] numbers = new int[1000000]; //took 211020ms

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1000);
        }

        System.out.println("Before Selection Sort: " + Arrays.toString(numbers));
        long startTime = System.currentTimeMillis();
        selectionSort(numbers);
        long endTime = System.currentTimeMillis();
       

        System.out.println("After Selection Sort: " + Arrays.toString(numbers));
        System.out.println("took " + (endTime - startTime) + "ms");
    }

    private static void selectionSort(int[] numbers) {

        int length = numbers.length;

        //iterates through the array up until the 2nd to last element
        for(int i = 0; i < length - 1; i++) {
            int min  = numbers[i];
            int indexOfMin = i;
            //iterates through the array where the current index is i + 1 and goes to the end of the array trying to find the smallest number
            for(int j = i + 1; j < length; j++) {
                if(numbers[j] < min) {
                    min = numbers[j];
                    indexOfMin = j;
                }
            }
            swap(numbers, i, indexOfMin);       
        }  
    }

    private static void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}
