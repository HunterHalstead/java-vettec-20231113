package com.skillstorm;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Problem20 {

	public static void printUsefulData(ArrayList<Data> dataList, Predicate<Data> p) {
		for (Data d : dataList) {
			if (p.test(d))
				System.out.println(d.value);
		}
	}

	public static void main(String[] args) {
		ArrayList<Data> al = new ArrayList<Data>();
		al.add(new Data(1));
		al.add(new Data(2)); 
		al.add(new Data(3));
		printUsefulData(al, (d) ->  d.value > 2);
	}

}

class Data {
	int value;

	Data(int value) {
		this.value = value;
	}
}
