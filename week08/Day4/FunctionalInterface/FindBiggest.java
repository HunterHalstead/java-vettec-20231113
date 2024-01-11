package Day4.FunctionalInterface;

/*
 * Every interface with a single abstract method is known as a Functional Interface
 * Instances of functional intefaces can be created with lambda expressions
 */
@FunctionalInterface //will generate an erro if the funcational interface doesnt satisfy the condition it should
public interface FindBiggest<T> {
    T compare(T item1, T item2, T item3);
}
