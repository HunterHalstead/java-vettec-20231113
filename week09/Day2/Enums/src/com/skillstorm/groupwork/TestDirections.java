package com.skillstorm.groupwork;

import static com.skillstorm.groupwork.enums.Cardinal.*;
import static com.skillstorm.groupwork.enums.Hand.*;

import java.util.LinkedList;

import com.skillstorm.groupwork.classes.ContinueDirection;
import com.skillstorm.groupwork.classes.Road;
import com.skillstorm.groupwork.classes.TurnDirection;
import com.skillstorm.groupwork.enums.Cardinal;
import com.skillstorm.groupwork.enums.Hand;
import com.skillstorm.groupwork.interfaces.Direction;

public class TestDirections {
	
	public static void main(String[] args) {
		test("testRightToLeft", testRightToLeft());
		test("testLeftToRight", testLeftToRight());
		test("testNorthToSouth", testNorthToSouth());
		test("testSouthToNorth", testSouthToNorth());
		test("testEastToWest", testEastToWest());
		test("testWestToEast", testWestToEast());
		test("testContinueDirectionReversed", testContinueDirectionReversed());
		test("testTurnDirectionReversed", testTurnDirectionReversed());
		test("testListOfDirectionsReversed", testListOfDirectionsReversed());
		
	}
	
	public static void test(String test, boolean passed) {
		System.out.printf("%s: %s %n", test, passed ? "passed" : "failed");
	}
	
	public static boolean testRightToLeft() {
		Hand right = RIGHT;
		return right.reverse() == LEFT;
	}
	
	public static boolean testLeftToRight() {
		Hand left = LEFT;
		return left.reverse() == RIGHT;
	}
	
	public static boolean testNorthToSouth() {
		Cardinal north = NORTH;
		return north.reverse() == SOUTH;
	}
	
	public static boolean testSouthToNorth() {
		Cardinal south = SOUTH;
		return south.reverse() == NORTH;
	}
	
	public static boolean testEastToWest() {
		Cardinal east = EAST;
		return east.reverse() == WEST;
	}
	
	public static boolean testWestToEast() {
		Cardinal west = WEST;
		return west.reverse() == EAST;
	}
	
	public static boolean testContinueDirectionReversed() {
		Direction original = new ContinueDirection(3, NORTH, 
									new Road("First St"));
		System.out.println("> " + original);
		Direction reversed = new ContinueDirection(3, SOUTH, 
				new Road("First St"));
		System.out.println("> " + reversed);
		return original.reverse().equals(reversed);
	}
	
	public static boolean testTurnDirectionReversed() {
		Direction original = new TurnDirection(LEFT, 
								new Road("First St"), new Road("A St"));
		System.out.println("> " + original);
		Direction reversed = new TurnDirection(RIGHT, 
								new Road("A St"), new Road("First St"));
		System.out.println("> " + reversed);
		return original.reverse().equals(reversed);
	}
	
	public static boolean testListOfDirectionsReversed() {
		Direction step1 = new ContinueDirection(3, NORTH, 
				new Road("First St"));
		Direction step2 = new TurnDirection(LEFT, 
				new Road("First St"), new Road("A St"));
		Direction step3 = new ContinueDirection(1, SOUTH, 
				new Road("A St"));
		Direction rev3 = new ContinueDirection(1, NORTH, 
				new Road("A St"));
		Direction rev2 = new TurnDirection(RIGHT, 
				new Road("A St"), new Road("First St"));
		Direction rev1 = new ContinueDirection(3, SOUTH, 
				new Road("First St"));
				
		LinkedList<Direction> original = new LinkedList<>();
		original.offer(step1);
		original.offer(step2);
		original.offer(step3);
		System.out.println("Original: ");
		WayHomeApp.print(original);
		System.out.println("Reversed: ");
		LinkedList<Direction> reversed = new LinkedList<>();
		reversed.offer(rev3);
		reversed.offer(rev2);
		reversed.offer(rev1);
		WayHomeApp.print(reversed);
		return WayHomeApp.reverse(original).equals(reversed);
	}

}
