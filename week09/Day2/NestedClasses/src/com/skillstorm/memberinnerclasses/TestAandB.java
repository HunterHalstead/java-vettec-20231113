package com.skillstorm.memberinnerclasses;

import java.util.LinkedList;

public class TestAandB {
	
	public static void main(String[] args) {
		A a = new A();
		A.B b = a.new B();
		A.B  b2 = a.new B();
		
		b.printXs();
		
		// Look at LinkedList Line 875 private class ListItr implements ListIterator<E>
		LinkedList<String> lst = new LinkedList<>();
	}

}
