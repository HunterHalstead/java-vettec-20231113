package Day4.Lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaPredicateExample {
	////////////////////////////////////////////////////////////////////////////////////////////////
	// Enthuware OCA Test 1 Question 43
	public static boolean checkList(List list, Predicate<List> predicate) {
		return predicate.test(list);
	}
	
	public static boolean checkList2(List list, Predicator<List> predicator) {
		return predicator.test(list);
	}
	
	public static void main(String[] args) {
		checkList(new ArrayList(), new MyClass());
		checkList(new ArrayList(), (lst) -> lst.isEmpty()); // more concise, hides verbose class creation and instantiation
		
		checkList2(new ArrayList(), new MyClass2());
//		checkList2(new ArrayList(), (lst) -> lst.isEmpty()); // Target Type must be functional interface
	}

}

class MyClass implements Predicate<List> {

	@Override
	public boolean test(List list) {
		return list.isEmpty();
	}
}

////////////////////////////////////////////////////////////////////////////////////////////////////
abstract class Predicator<E> {
	
	abstract boolean test(E e);
}

class MyClass2 extends Predicator<List> {

	@Override
	boolean test(List e) {
		return false;
	}
	
}