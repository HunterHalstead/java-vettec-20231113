package com.skillstorm.spacecomplexity;

import java.util.LinkedList;

public class BigOExamples {
	
	public static void main(String[] args) {
		
	}

	// Get the first value in a list
	public int getFirst(int[] nums) {
		return nums[0]; // O(1) constant
	}
	
	public int getFirst(LinkedList<Integer> nums) {
		return nums.get(0); // O(1) constant
	}
	
	// Get the nth value in a list
	public int getNth(int[] nums, int n) {
		return nums[n]; // O(1) constant
	}
	
	public int getNth(LinkedList<Integer> nums, int n) {
		return nums.get(n); // O(n) linear
	}
	
	// Use a loop to get the max value in a list
	public int  getMax(int[] nums) {
		int max = Integer.MIN_VALUE; // one operation runs 1x
		for (int num: nums)
			max = Math.max(num, max); // 2nd operation repeats nx 
		return max;
	} // Big-O(n + 1) --> O(n)

	// Get the max and min of a list (method-1)
	public int[]  getMaxAndMin(int[] nums) {
		int max = Integer.MIN_VALUE; // one operation runs 1x
		for (int num: nums)
			max = Math.max(num, max); // 2nd operation repeats nx 
		// now compute the min
		int min = Integer.MAX_VALUE; // 3rd operation runs 1x
		for (int num: nums)
			min = Math.min(num, max); // 4th operatoin repeats nx
		return new int[] {max, min};
	} // O(2n + 2) -> O(n)
	
	// Get the max and min of a list (method-2)
	public int[]  getMaxAndMinBetter(int[] nums) {
		int max = Integer.MIN_VALUE; // one operation runs 1x
		int min = Integer.MAX_VALUE; // 3rd operation runs 1x
		for (int num: nums) {
			max = Math.max(num, max); // 2nd operation repeats nx 
			min = Math.min(num, max); // 4th operatoin repeats nx
		}
		return new int[] {max, min};
	} // O(n)
	
	// Use a loop to find an item in a list
	public boolean contains(int value, int[] list) {
		boolean result = false; 
		for (int n : list) {
			if (n == value)
				result = true;
		}
		return result;
	} // Best case and worst case are both O(n)
	
	public boolean containsBetter(int value, int[] list) {
		for (int n : list) {
			if (n == value)
				return true;
		}
		return false;
	} // Best case is now O(1) and worst case is O(n)
	
	// Search a 2-d array
	public boolean contains(int value, int[][] list) {
		boolean result = false; // 1 assignment
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[i].length; j++) {
				if (list[i][j] == value)
					result = true; // 1 comparison here runs how many times?
			}
		}
		return result;
	} // O(n^2)
	
	public boolean containsBetter(int value, int[][] list) {
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[i].length; j++) {
				if (list[i][j] == value) // 1 comparison here runs how many times?
					return true;
			}
		}
		return false;
	} // O(n^2)

}
