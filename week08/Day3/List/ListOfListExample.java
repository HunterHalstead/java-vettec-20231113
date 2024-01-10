package Day3.List;

import java.util.ArrayList;
import java.util.List;

public class ListOfListExample {
    public static void main(String[] args) {
        //Create the listOfLists
        List<List<Integer>> listOfLists = new ArrayList<>();

        //create the inner List
        List<Integer> innerList = new ArrayList<>();

        //adding the inner List
        innerList.add(1);
        innerList.add(4);
        innerList.add(6);
        innerList.add(9);

        //add the inner list to the listOfList
        listOfLists.add(innerList);

        List<Integer> innerList2 = new ArrayList<>();
        innerList2.add(4);
        innerList2.add(7);
        innerList2.add(4);
        innerList2.add(1);

        listOfLists.add(innerList2);

        System.out.println(listOfLists);
    }
    
}
