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
		return new ContinueDirection(numBlocks, (Cardinal) heading.reverse(), road);

		////////////////////////////////////////////////////////////////////
	}

	public String toString() {
		return String.format("Head %d blocks on %s going %s", numBlocks, road, heading);
	}

	@Override
	public int hashCode() {
		return Objects.hash(heading, numBlocks, road);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContinueDirection other = (ContinueDirection) obj;
		return heading == other.heading && numBlocks == other.numBlocks && Objects.equals(road, other.road);
	}

	

}
