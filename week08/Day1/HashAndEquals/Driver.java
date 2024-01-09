package Day1.HashAndEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Driver {
    public static void main(String[] args) {
        Company stateFarm = new Company("State Farm", 7500, "abc10103");
        Company google = new Company("Google", 25000, "abd12123");
        Company google2 = new Company("Google2", 25000, "abd12123");

        Occupation stateFarmSalesman = new Occupation("Salesman", stateFarm, 80000);
        Employee matthew = new Employee("Matthew", 21, stateFarmSalesman);
        Employee sam = new Employee("Sam", 52, stateFarmSalesman);
        Employee matthew2 = new Employee("Matthew", 21, stateFarmSalesman);
        System.out.println(matthew);
        System.out.println(sam);
        System.out.println("Are the two equal? " + matthew.equals(matthew2));

        System.out.println("Are the two equal? " + google.equals(google2));

        System.out.println("Hash for stateFarm: " + stateFarm.hashCode());
        System.out.println("Hash for google: " + google.hashCode());
        System.out.println("Hash for google2: " + google2.hashCode());

        /*
         * HashSets
         * 
         * Implements the Set Interface
         * 
         * A grouping of items that does NOT contain duplicates
         * 
         * How does HashSet work?
         * 1. It uses hash codes to place items into buckets for quick and easy lookup time
         * 2. Use the equals() when adding an element to the set to determine if its already in there
         *      - If the item is already in the set, then it doesnt need to add
         *      - If the item is not in the set, it add under the bucket
         * 
         * 
         */

         HashSet<Company> companySet = new HashSet<>();
         companySet.add(stateFarm); 
         System.out.println(companySet);
         companySet.add(google); 
         System.out.println(companySet);
         companySet.add(google2);
         System.out.println(companySet);

         // I can check to see if my set has a value in it by using contains()
         if(companySet.contains(google2)) {
            System.out.println("Google 2 is in the set!");
         }

         companySet.remove(stateFarm);
         if(companySet.contains(stateFarm)) {
            System.out.println("State Farm is in the set!");
         } else {
            System.out.println("State Farm is not in the set anymore!");
         }

         companySet.add(stateFarm);
         companySet.add(new Company("Ikea", 80000, "14456abc"));
         System.out.println(companySet);

        //I can use a for each loop to iterate over my set
        //I can NOT use a standard for loop becasue sets are not traditionally indexed
        //In fact, sets dont guarantee the same order at which they are added in

        //HashSets are considered "unordered" collections, meaning that they don't perserve their order
         for(Company company : companySet) {
            System.out.println(company);
         }

         HashMap<String, String> companyMap = new HashMap<>();
         companyMap.put("McDonalds", "Big Mac");
         companyMap.put("Wendys", "Baconator" );
         companyMap.put("Burger King", "Whopper");
         companyMap.put("Chick-Fil-A", "Chicken Sandwich");
         companyMap.put("Taco Bell", "Crunch Wrap");
         companyMap.put("Popeyes", "Chicken Sandwich");

         System.out.println("--------HASH MAP ---------");
         System.out.println(companyMap);

         HashMap<String, LinkedList<String>> companiesWthFoodItem = new HashMap<>();
         companiesWthFoodItem.put("Chicken Sandwhich", new LinkedList<>(Arrays.asList("Wendys", "Chick-Fil-A", "Popeyes" )));

         System.out.println("The most famous item at McDonalds is: " + companyMap.get("McDonalds"));
         System.out.println("The most famous item at Chick-Fil-A is: " + companyMap.get("Chick-Fil-A"));

         HashMap<Integer, Integer> map = new HashMap<>();
         map.put(1, 37); 
         map.put(2, 28); 

         System.out.println(map);
    }
}
