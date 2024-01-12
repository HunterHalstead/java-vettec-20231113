package Day5.Streams;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {

    /*
     * Streams
     * - A way to process collection of objects 
     * - Not a datastructure, takes in inpute from Collections and Arrays
     * - don't change the original data
     * - lazily executed, they're not going to be evaluated until the result is needed
     * - Stream operations can be chained together to create a pipeline
     * 
     * Different stream funcitons (think of streams as a list)
     * All of the following functions do NOT mutate the original data set
     * 
     * forEach - takes a stream and performs a lambda expression on each element of the stream. It does NOT return a new stream
     * 
     * map - takes a stream and performs a lambda expression on each element of the stream, but returns a 
     *       values that it used to construct the new stream
     * 
     * filter - takes a stream and perform a lamnda expression on each element of the stream. That lambda will return true/false
     *          where false represents that element should NOT be added to the new stream and true will add data to the new stream
     * 
     * reduce - takes a stream and perform a lamnda expression on each element of the stream. It adds the return to an accumulated value
     *          Think of a snowball rolling down the hill, the accumulated value gets bigger and bigger with each iteration
     * 
     */

    public static void main(String[] args) {
        LinkedList<String> fruits = new LinkedList<>(Arrays.asList("Apple", "Durang", "Pineapple", "Mango", "Strawberry", "Tomato", "Kiwi", "blueberry", "Pear", "Blackberry"));

        System.out.println(fruits);

        //create a new stream 
        Stream<String> fruitStream = fruits.stream();

        //iterating through a stream to print out each elements in our stream
        fruitStream.forEach(fruit -> System.out.println(fruit));

        //will create a new stream of apples, where each apple corresponds to the fruit in the first stream 
        //uses the map operation to transform each element in the stream to an apple 
        fruits.stream().map(fruit -> "Apple").forEach(fruit -> System.out.println(fruit));

        //I want to map over all of my fruits and capitalize them
        //collect is a function that collects all the data in the stream and does something
        //Collectors.toList() provides a lambda function for transforming our stream back to a list
        List<String> capitalizedFruits = fruits.stream().map(fruit -> fruit.toUpperCase()).collect(Collectors.toList());
        System.out.println(capitalizedFruits);

        System.out.println(fruits);

        int[] nums = {1, 4, 6, 2, 8};

        //Example of map funcationality, map operation would create a new array,l this one doesnt
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            nums[i] = num * 2;
        }
        //example of forEach functionality
        for(int num : nums) {
            System.out.println(num);
        }

        //Filter Examples

        //Filters through fruits and returns fruits that begin with the letter p
        List<String> fruitsThatBeginWithP = fruits.stream().filter(fruit -> fruit.toLowerCase().charAt(0) == 'p').collect(Collectors.toList());
        System.out.println(fruitsThatBeginWithP);

        //Filter through fruits and return a new stream of fruit that contains the string berry in it
        List<String> berries = fruits
                .stream()
                .filter(fruit -> fruit.toLowerCase().contains("berry"))
                .collect(Collectors.toList());

        System.out.println(berries);

        //Reduce Example

        List<Integer> numbers = new LinkedList<>(Arrays.asList(2, 5, 7, 4, 4, 65, 76, 21));

        /*
         * 1. Takes our Interger List and turns it into a Stream of Integers
         * 2. we call the reduce operation on that Stream
         * 3. we first set the initial value of accumulated value to be 0
         * 4. we define our lambda to take that accumulator and the current number were looking at and then return the new accumulator
         * 5. Finish looping through all the numbers, then return the end acc (accumulated) value
         */
        int sumOfNumbers = numbers
            .stream()
            .reduce(0, (acc, number) -> acc + number);
        System.out.println(sumOfNumbers);


        int maxOfNumbers = numbers
            .stream()
            .reduce(Integer.MIN_VALUE, (max, number) -> {
                int newMax = Math.max(max, number);
                return newMax;
            });
            System.out.println(maxOfNumbers);

        int seansMaxOfNumbers = numbers
            .stream()
            .reduce(Integer.MIN_VALUE, (max, number) -> Math.max(max, number));
        System.out.println(seansMaxOfNumbers);

        int joshsMaxOfNumbers = numbers.stream().reduce(Integer.MIN_VALUE, (max, number) -> Math.max(max, number));
        System.out.println(joshsMaxOfNumbers);

        System.out.println(Arrays.asList(2, 5, 7, 4, 4, 65, 76, 21)
                .stream()
                .reduce(Integer.MIN_VALUE, (max, number) -> Math.max(max, number)));

        int nassersMaxOfNumbers = numbers.stream().reduce(Integer.MIN_VALUE, Math::max);
        System.out.println(nassersMaxOfNumbers);

        Optional<Integer> i = numbers.stream().reduce(Math::max);
        System.out.println(i);
    }
}
