package Day3.List;

import java.util.ArrayList;
import java.util.List;

public class ListOfListStringExample {
    public static void main(String[] args) {
        List<List<String>> listOfLists = new ArrayList<>();

        List<String> innerList = new ArrayList<>();
        innerList.add("Sam");
        innerList.add("Nasser");
        innerList.add("Josh");

        listOfLists.add(innerList);

        List<String> innerList2 = new ArrayList<>();
        innerList2.add("Carlos");
        innerList2.add("Sean");
        innerList2.add("Hunter");

        listOfLists.add(innerList2);

        List<String> innerList3 = new ArrayList<>();
        innerList3.add("Caroline");
        innerList3.add("Rod");

        listOfLists.add(innerList3);

        System.out.println(listOfLists);
    }
}
