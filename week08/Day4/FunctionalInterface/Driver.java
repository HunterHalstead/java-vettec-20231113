package Day4.FunctionalInterface;

import java.util.LinkedList;
import java.util.Scanner;

public class Driver {
    public static void findNumberGivenCriteria(FindBiggest<Integer> fb) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a number: ");
        Integer num1 = scan.nextInt();
        scan.nextLine();

        System.out.println("Please enter a number:");
        Integer num2 = scan.nextInt();
        scan.nextLine();

        System.out.println("Please enter a number:");
        Integer num3 = scan.nextInt();
        scan.nextLine();

        System.out.println(fb.compare(num1, num2, num3));

        scan.close();

    }


    public static void main(String[] args) {
        FindBiggestInteger fbi = new FindBiggestInteger();

        // findNumberGivenCriteria((num1, num2, num3) -> {
        //     if(num1 < num2) {
        //         if(num1 < num3) {
        //             return num1;
        //         } else {
        //             return num3;
        //         }
        //     } else {
        //         if(num2 < num3) {
        //             return num2;
        //         } else {
        //             return num3;
        //         }
        //     }


        // });

        FindBiggest<Integer> sum = (num1, num2, num3) -> {
           return  num1 + num2 + num3;
        };

        findNumberGivenCriteria(sum);

        LinkedList<String> words = new LinkedList<>();
        
        //TODO: Sort the list of string in ascending order by length using lambda funtion 
    }
}
