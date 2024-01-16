package Day5.Streams;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

public class StreamPractice {
    public static void main(String[] args) {
        List<String> desserts = Arrays.asList("chocolate chip cookies", "double chocolate brownies", 
                                            "strawberry ice cream", "tres leches cake", "flan", "apple pie", "tiramisu", "chocolate ice cream");

        desserts = desserts.stream().filter(dessert -> dessert.contains("chocolate")).collect(Collectors.toList());
        System.out.println(desserts);

        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        //peek() - prints outs each element in the stream
        Integer sum = nums.stream().peek(System.out::println).reduce(0, (x, y) -> {
            //System.out.println("x=" + x + " y=" + y);
            return x + y;
        });
        System.out.println(sum);

        List<House> houses = Arrays.asList(new House("Orange", 2150), new House("White", 850), new House("Blue", 15000));
        //find the house with the largest sqrft
        int largest = houses.stream()
                            .peek(System.out::println)
                            .map(house -> house.sqrFt)
                            .peek(System.out::println)
                            .reduce(0, (x, y) -> {
                                System.out.println("comparing " + x + " and " + y );
                                return Math.max(x, y);
                            });

        System.out.println(largest);
    }
    
}

class House {
    String color;
    int sqrFt;

    public House() {}

    public House(String color, int sqrFt) {
        this.color = color;
        this.sqrFt = sqrFt;
    }

    public String toString() {
        return color + " is the color of the house and it has " + sqrFt + "sqrft";
    }
    
    
}