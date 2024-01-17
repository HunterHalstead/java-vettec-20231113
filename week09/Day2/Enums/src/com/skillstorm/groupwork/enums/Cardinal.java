package com.skillstorm.groupwork.enums;

import com.skillstorm.groupwork.interfaces.Direction;

/**
 * An enum (a set of constants) that represents the cardinal directions on a compass. 
 * 
 * To learn more, read https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
 *
 */
public enum Cardinal implements Direction {
	
	// TODO 1a Create an enum 
	//  that represents the cardinal directions on a compass
	// TODO 1b Return the opposite direction
	NORTH {
		@Override
		public Cardinal reverse() {
			return SOUTH;
		}
	},
	SOUTH {
		@Override
		public Cardinal reverse() {
			return NORTH;
		}
	},
	EAST {
		@Override
		public Cardinal reverse() {
			return WEST;
		}
	},
	WEST {
		@Override
		public Cardinal reverse() {
			return EAST;
		}
	}
	

}
