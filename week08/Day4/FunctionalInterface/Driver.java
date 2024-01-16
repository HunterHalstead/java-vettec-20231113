package Day4.FunctionalInterface;

import java.util.Arrays;
import java.util.Collections;
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


    public static void main(String[] args) {;
        findNumberGivenCriteria((num1, num2, num3) -> {
            //Find the smallest number of all 3
            if(num1 < num2) {
                if(num1 < num3) {
                    return num1;
                } else {
                    return num3;
                }
            } else {
                if(num2 < num3) {
                    return num2;
                } else {
                    return num3;
                }
            }


        });

        // FindBiggest<Integer> sum = (num1, num2, num3) -> {
        //    return  num1 + num2 + num3;
        // };

        //findNumberGivenCriteria(sum);

        //TODO: Sort the list of string in ascending order by length using lambda funtion 
        LinkedList<String> words = new LinkedList<>(Arrays.asList("A", "Cat", "Dog", "Water", "Trees", "Abdelnasser", "supercalifragilisticexpialidocious", "Skillstorm", "five"));
        System.out.println(words);
        Collections.sort(words, (word1, word2) -> {
            return word1.length() - word2.length();
        });

        //Collections.sort(words, (word1, word2) -> word1.length() - word2.length());

        System.out.println(words);


        
    }
}
