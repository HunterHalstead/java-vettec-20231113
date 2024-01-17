package com.skillstorm.groupwork.classes;

import java.util.Objects;

import com.skillstorm.groupwork.enums.Cardinal;
import com.skillstorm.groupwork.interfaces.Direction;

/**
 * This class represents one step in a set of directions
 * to travel from one location to another along the imaginary
 * grid city of Squareville. (All distances are measurable in blocks,
 * and all roads are on a grid.)
 *
 */
public class ContinueDirection implements Direction {

	private int numBlocks;

	private Cardinal heading;

	private Road road;

	public ContinueDirection() {
		super();
	}

	public ContinueDirection(int numBlocks, Cardinal heading, Road road) {
		super();
		this.numBlocks = numBlocks;
		this.heading = heading;
		this.road = road;
	}

	public ContinueDirection reverse() {
		////////////////////////////////////////////////////////////////////
		// TODO 3 Reverse this continue direction
		// Hint: Use this.turn, this.from, this.onto to create the reverse
		
		
		return null;
		////////////////////////////////////////////////////////////////////
	}


	

}
