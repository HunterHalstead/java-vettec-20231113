package Day2.HashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<Integer> nums = new HashSet<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        System.out.println(nums);
        System.out.println("Adding 3 again? " + nums.add(3)); //cant add duplicate values, returns false
        System.out.println(nums);

        Iterator<Integer> itr = nums.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next().hashCode());
        }

        Set<String> cookies = new HashSet<>();
        cookies.add("Chocolate Chip");
        cookies.add("Ginger Snap");
        cookies.add("Snicker Doodle");

        System.out.println(cookies);
        //returns java.util.NoSuchElementException
        // Iterator<Integer> itr2 = nums.iterator();
        // while(itr2.hasNext()) {
        //     System.out.println(itr.next().hashCode());
        // }

        System.out.println(cookies.size());
        cookies.remove("Ginger Snap");
        System.out.println(cookies);
        System.out.println("Size is now " + cookies.size());
        cookies.remove("Ginger Snap");
        System.out.println("Removing ginger snaps again? " + cookies.remove("Ginger Snaps"));

        System.out.println("We can check is the set empty? " + cookies.isEmpty());
        cookies.clear();
        System.out.println(cookies);
        System.out.println("We can check is the set empty? " + cookies.isEmpty());
    }
}
