package Day2.HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class HashMapDriver {
    public static void main(String[] args) {
        
        /*
         * HashMaps
         * 
         * Store data in key-value pairs
         *  - Think of an actual key (key to your house)
         *  - The value is whats inside the house
         * 
         * they also use hashcode and equals in order to ensure super fast lookup times
         * 
         * Keys must be unique
         *  - we performs the hashcode and equals on the keys
         *  - is because we store multiple of the same value
         * 
         * Examples of Key-Value pairs:
         * 1. House key and the inside of the house
         * 2. Dictionary (a word and the defintion)
         * 3. car key and the actual car
         * 4. Color name and RGB values
         * 5. Book ISBN and the actual book
         * 6. SSN and the person
         * 
         */

         HashMap<Integer, String> numMap = new HashMap<>();

        //adding to the hashmap using the put()
         numMap.put(1, "one");
         numMap.put(2, "two");
         numMap.put(3, "three");

        //this adds the key 4 with a value that already exsists in the hashmap 
         numMap.put(4, "three");
         System.out.println(numMap);

        //retrieve items from hashmap
        System.out.println(numMap.get(1));

        numMap.remove(3);
        System.out.println(numMap);



        /*
         * We want to write a HsahMap that "maps" hashtags to our posts
         * 
         * This maps a string (hashtag) to a list of associated posts
         * 
         * Only with the key do we use the hashcode and equals 
         * for the object we just retrieve the data using the key
         */

        HashMap<String, LinkedList<Post>> hashtags = new HashMap<>();
        Post exploringTheNetherlands = new Post("Exploring the Netherlands", "Come visit the Netherlands!", "Caroline Ahumada");
        Post sightSeeingInJapan = new Post("Sight Seeing in Japan", "Japan is such an incredible place!", "Sam Park");
        Post caveDivingInFlorida = new Post("Cave Diving In Florida", "The underwater perspective is amazing!", "Rod Palmer");

        hashtags.put("#travel", new LinkedList<>(Arrays.asList(exploringTheNetherlands, sightSeeingInJapan, caveDivingInFlorida)));
        hashtags.put("#japan", new LinkedList<>(Arrays.asList(sightSeeingInJapan)) );

        System.out.println(hashtags);

        //this gives me all the posts about travel
        LinkedList<Post> posts = hashtags.get("#travel");

        System.out.println("Displaying all the #travel posts:");
        for(Post post : posts) {
            System.out.println(post.getContent());
        }

        //hashtags.remove("#japan");
        System.out.println(hashtags);

        System.out.println(hashtags.get("#japan"));

        //add to the hashmap only iof the key isnt in there
        hashtags.putIfAbsent("#travel", null);
        System.out.println(hashtags.get("#travel"));

        //it takes the hashcode of the key provided and checks that entire buckest for the key
        if(hashtags.containsKey("#florida")) {
            System.out.println("Contains posts about flroida!");
        } else {
            System.out.println("No posts about florida can be found :( ");
        }

        //we can NOT use a standard for loop since there are no indicies for our Maps/Sets.
        //MUST use for-each loop
        for(String key : hashtags.keySet()) {
            System.out.println(key);
        }

        for(LinkedList<Post> value : hashtags.values()) {
            System.out.println(value);
        }

    }
    
}
