# Groupwork - The Way Home App

## Goal

The goal is to write a program that when given a set of directions will reverse all the directions to give "The Way Home"

## Steps

1. In Cardinal.java:
   a. Create the enum values to represent the cardinal directions on a compass
   b. Implement the reverse to return the opposite direction

2. In Hand.java
   a. Create the enum values to represents something is left or right handed.
   b. Implement the reverse method to return the opposite hand

3. In ContinueDirection.java
   a. Add a toString, hashCode, and equals methods
   b. Implement the reverse method to reverse the directions

4. In TurnDirection.java
   a. Add a toString, hashCode, and equals methods
   b. Implement the reverse method to reverse the directions

5. In wayHomeApp.java
   a. Implement the reverse method to reverse all the directions in a list
   
6. Run the TestDirections.java to see if you have correctly implemented the above 4 classes

## Bonus

If you finish early, create a class GroupGenerator with a method that takes in a list of names and returns a randomized set of groups.

```
public class GroupGenerator {

    public Set<List<String>> randomizeGroups(List<String> names, int numPeoplePerGroup) {
        // Your code here
    }

    public Set<List<String>> randomizeNGroups(int nGroups, List<String> names) {
        // Your code here
    }
}
```
