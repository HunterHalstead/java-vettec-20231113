package Day2.HashSet;

import java.util.HashSet;

public class HashSetDriver {
    public static void main(String[] args) {
        Movie starWars = new Movie("Star Wars", "George Lucas");
        Movie bladeRunner = new Movie("Blade Runner", "Ridley Scott");
        Movie theGodFather = new Movie("The God Father", "Franics Ford Copola");
        Movie theFifthElement = new Movie("The Fifth Element", "Luc Besson");
        Movie bladeRunner2 = new Movie("Blade Runner", "Ridley Scott");

        HashSet<Movie> movieCollection = new HashSet<>();
        movieCollection.add(starWars);
        movieCollection.add(bladeRunner);
        movieCollection.add(theGodFather);
        movieCollection.add(theFifthElement);
        movieCollection.add(bladeRunner2);

        System.out.println(movieCollection);
        System.out.println("Star Wars: " + starWars.hashCode());
        System.out.println("Blade Runner: " + bladeRunner.hashCode());
        System.out.println("The Fifth ELement: " + theFifthElement.hashCode());
        System.out.println("Blade Runner 2: " + bladeRunner2.hashCode());

        movieCollection.remove(bladeRunner2);
        System.out.println(movieCollection);

        /*
         * Data Structure is just a term used to define some structure that holds data
         * 
         * Each data structure holds their data in their own unique way
         * 
         * Stacks - LIFO (Add to the top, remove from the top)
         * Queues - FIFO (Add to the back, remove from the front)
         * Lists - keep data orderly in a list-like format
         * Sets - Precent duplicates
         * Maps - store key-value pairs
         * 
         * 
         * HashSet is an "Unordered" collection
         *  - NO duplicates
         *  - use hashcodes to determine their order
         *  - super quick, almost constant lookup times
         * 
         */
    }
}
