package Day5.Review;

//Funcational Interface
//the interface must have have only 1 abstract method
@FunctionalInterface
interface Action {
    void act(int num);
}


public class LambdaReview {

    public static void performActionOnNumber100(Action action) {
        action.act(100);
    }

    /*
     * In order to use Lambdas in java, a functional interface is required
     * 
     * lambdas froego the requirement of creating a class that satisfies the interface
     * because of these functional interfaces we only have one method to implement, I can define a function instead
     * 
     */

    public static void main(String[] args) {
        //setting the actionaImplementation to a function that represents the act method
        Action actionImplementation = (num) -> {
            System.out.println("The number provided is: " + num);
        };
        performActionOnNumber100(actionImplementation);


        Action numberDoubler = (num) -> {
            System.out.println("The number doubled is: " + (num * 2));
        };
        performActionOnNumber100(numberDoubler);

        actionImplementation.act(500);
        numberDoubler.act(50);

        performActionOnNumber100((num) -> {
            System.out.println("The original number is: " + num);
            System.out.println("The number divided by 10 is: " + (num / 10));
        }); 
    }
}
