package com.skillstorm.groupwork.enums;

import com.skillstorm.groupwork.interfaces.Direction;

/**
 * This class is used to represent something left-handed or right-handed.
 *
 * To learn more about enums, read https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
 */
public enum Hand implements Direction {
	
	// TODO 2a Create an enum 
	//  that represents the constants right and left
	// TODO 2b Return the opposite
	LEFT {
		@Override
		public Hand reverse() {
			return RIGHT;
		}
	},
	RIGHT {
		@Override
		public Hand reverse() {
			return LEFT;
		}
	};

}
