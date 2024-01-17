package com.skillstorm.groupwork;

import java.util.LinkedList;

import com.skillstorm.groupwork.interfaces.Direction;

public class WayHomeApp {

	
	/** Given a list of directions, print out the reverse 
	 * directions to get back to where you started.
	 * 
	 * @param directions A list of directions to get from some pt A to pt B
	 * @return A new stack of directions with the directions reversed
	 */
	public static LinkedList<Direction> reverse(LinkedList<Direction> directions) {
		LinkedList<Direction> reversed = new LinkedList<>();
		////////////////////////////////////////////////////
		// TODO 5 Reverse the order of the directions
		// Hint: Use the stack methods (push, pop, and peek) 
		// to write a loop that reverses the order of the directions.
		// (Don't forget to reverse each direction itself) 
		
		
		return reversed;
		////////////////////////////////////////////////////
	}
	
	/**
	 * Prints the directions from the front of the list to the back of the list.
	 * @param directions
	 */
	public static void print(LinkedList<Direction> directions) {
		for (Direction dir : directions) {
			System.out.println("> " + dir);
		}
	}

}
