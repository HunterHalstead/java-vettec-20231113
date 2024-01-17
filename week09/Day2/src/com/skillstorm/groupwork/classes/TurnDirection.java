package com.skillstorm.groupwork.classes;

import java.util.Objects;

import com.skillstorm.groupwork.enums.Hand;
import com.skillstorm.groupwork.interfaces.Direction;

/**
 * This class represents one step in a set of directions
 * to travel from one location to another along the imaginary
 * grid city of Squareville. (All distances are measurable in blocks,
 * and all roads are on a grid.)
 *
 */
public class TurnDirection implements Direction {

	private Hand turn; // right-hand turn or left-hand turn

	private Road from;

	private Road onto;

	public TurnDirection() {
		super();
	}

	public TurnDirection(Hand turn, Road from, Road onto) {
		super();
		this.turn = turn;
		this.from = from;
		this.onto = onto;
	}

	@Override
	public TurnDirection reverse() {
		////////////////////////////////////////////////////////////////////
		// TODO 4 Reverse this turn direction
		// Hint: Use this.turn, this.from, this.onto to create the reverse
		
		
		
		return null;
		////////////////////////////////////////////////////////////////////
	}



}
