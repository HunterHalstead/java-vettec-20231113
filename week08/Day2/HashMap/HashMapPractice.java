package Day2.HashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapPractice {
    public static void main(String[] args) {
        
        HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put("accuracy", "The quality or state of being correct or precise.");
        dictionary.put("precision", "The quality, condition, or fact of being exact and accurate.");
        dictionary.put("consistency", "Conformity in the application of something, typically that which is necessary for the sake of logic, accuracy, or fairness.");
        System.out.println(dictionary);

        HashMap<Integer, String> codes = new HashMap<>();
        codes.put(133, "happy");
        codes.put(156, "angry");
        System.out.println(codes);

        codes.put(null, "null");
        codes.put(null, "nothin");
        System.out.println(codes);

        codes.replace(null, "not specified");
        System.out.println(codes);
        codes.replace(1, "unkown"); //can't replace a key that doesn't exsist
        System.out.println(codes);

        /*
         * SUMMARY
         * put() - create or overwite if it doesnt exist
         * putIfAbsent() - create (does NOT overwrite)
         * replace() - overwrites (does NOT create)
         * 
         * Retrieval Options
         * .get(Object key) - get one value
         * .keySet() - get all the keys
         * .values() - gets a collection of all the values
         */


         Map<Integer, Integer> nums = new HashMap<>();
         nums.put(1, 111);
         nums.put(2,222);
         nums.replace(2, 333); //key 2 gets replaced
         nums.put(null, 000);
         nums.replace(3, 333);
         nums.put(1, 999);
         System.out.println(nums);

    }
}
