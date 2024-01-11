package Day4.Lambdas;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Lambda {
    /*
     * What is a Lambda?
     * - In Java 8, the ability to use lambda function was added
     * - They were added to support the growing coding paradigm, known as "Functional Programing"
     * - Lambdas provides a means to pass a "function" to another function
     * 
     * Lambdas are often referred as:
     * 1. Lambdas
     * 2. Anonymous Functions 
     * 3. Arrow Functions 
     * 
     * Functional Programming:
     * 1. Functions are first class citizens
     *  - I can pass functions to other functions
     *  - I can return functions
     *  - In Java, I can NOT pass fucntions to function nor return functions
     * 2. Believe in a concept known as "pure functions"
     *  - This means, that no function should have any "side effects"
     *  - by side effects, it means by any behaviour that isnt part of the fucntions primary purpose
     *      - mutating the value of a parameter
     *      - calculating some other value
     *  - Each function should have one purpose and stick to that 
     * 
     * Functional Programming in Java is completely opt in, Java is OOP at its core
     * 
     */
    public static void main(String[] args) {

        LinkedList<City> cities = new LinkedList<>();
        cities.add(new City("Jacksonville",950223 ));
        cities.add(new City("Atlanta",185665 ));
        cities.add(new City("New York",7457812 ));
        cities.add(new City("Boston",150000 ));
        cities.add(new City("Seattle",350000 ));
        cities.add(new City("Miami",1600023 ));

        //Use lambdas to sort our list of cities
        //Using lambdas, I can define the actual compare method by iteself and pass that into the Collections.sort()

        System.out.println("Unsorted List of Cities:");
        System.out.println(cities);
        Collections.sort(cities, new CityPopulationComparator());
        System.out.println("Sorted Cities by population using Comparator Interface:");
        System.out.println(cities);

        //Uses lambda function to sort my cities by name
        System.out.println("Sorted Cities by name using Lambda:");
        Collections.sort(cities, (city1, city2) -> city1.getName().compareTo(city2.getName()));
        System.out.println(cities);

        Comparator<City> cityNameReverseSorter = (city1, city2) -> {
            if(city1 == null) {
                if(city2 == null) {
                    return 0;
                }
                return 1;
            }
            if(city1.getName() == null) {
                if(city2.getName() == null) {
                    return 0;
                }
                return 1;
            }
            return city2.getName().compareTo(city1.getName());
        };
        //Sorts this list according to the order induced by the specified Comparator
        cities.sort(cityNameReverseSorter);
        System.out.println("Reversed Sorted List of Cities by name:");
        System.out.println(cities);

        /*
         * Lambdas function syntax rules
         * 
         * General Structure
         * 
         * No argument hello world function
         * () -> System.out.println("Hello World");
         * 
         * () - The parantheses are where my arguments (or loack thereof) for the function go. 
         *      There is no data type for them.
         * -> - Arrow symbolizes the start of our function body
         * All else - the code that you want to run by the function. The function ends at the first semicolon
         * 
         * The way that function's are written
         * 
         * I can only have one line in the function
         * 
         * (city1, city2) -> {
         *      return city1.getPopulation() - city2.getPopulation();
         * }
         * 
         * Valid examplaes of lambdas:
         * 
         * This function takes no arguments and returns 1
         * 1. () -> 1;
         * 
         *    Non-lambda equivalent
         *    public static int someFunction() {
         *         return 1;
         *    }
         * 
         * 2. () -> { return 1; }
         * 
         * If and only if you have one argument, you can omit ()
         * This function will take a parameter called num and return num
         * 3. num -> num;
         *    num -> { return num; }
         *   (num) -> num;
         * 
         *    Non-lambda equivalent
         *    public static int someFunction(int num) {
         *          return num;
         *    }
         * 
         * 4. (num1, num2) -> { return num1 + num2 }
         * 
         * Invalid Examples:
         * 
         * Lambdas with {}, if you're trying to return, MUST type return explicitly
         * 1. () -> { 1; }
         * 
         * Without {}, it MUST all be done on one line
         * 2. (num1, num2) -> System.out.println(num1); System.out.println(num2);
         * 
         * 
         */

    }
}
