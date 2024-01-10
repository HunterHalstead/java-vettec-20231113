package Day3.StringBuilder;

public class StringBuilderExample {
    /*
     * Strings are immutable
     *  - which means a new string is created in memory every time the value is changed
     * 
     * StringBuilder
     * - a mutable sequence of character 
     * - any changes will just modify the existing sequence of characters created in memory
     * - provides methods to modify, append, insert, delete and perform various operations 
     *   on strings WITHOUT creating new objects everytime or new space in memory
     * 
     */
    public static void main(String[] args) {
        //We create a new String, can't modify it directly, need ot create new object
        String str = "String";
        str.concat(" another String");
        //str = str.concat(" another String");
        String result = str.concat(" another String");

        System.out.println(str);
        System.out.println(result);

        //these String methods happen very quickly, constant time
        System.out.println(str.length());
        System.out.println(str.charAt(0));

        //when we append another String, the existing String in memory is modified
        StringBuilder sb = new StringBuilder("Vanilla ").append(str);
        sb.append("and chocolate");
        sb.append(" and strawberry");
        System.out.println(sb);

        StringBuilder sb2 = new StringBuilder("StringBuilder");
        //start - the beginning index, inclusive
        //end - the ending index, exclusive
        sb2.replace(1, 5, "red");
        System.out.println(sb2);
        System.out.println(sb2.length());
        System.out.println(sb2.charAt(3));

        StringBuilder sb3 = new StringBuilder("Fruits: ");
        sb3.append("apples, ");
        sb3.append("oranges, ");
        sb3.append("watermelon ");

        //can convert StringBuilder to a String
        String str2 = sb3.toString();
        System.out.println(str2);

        System.out.println(sb3);

         sb3.setLength(3);
         System.out.println(sb3);

        sb3.deleteCharAt(2);
        System.out.println(sb3);

        sb3.reverse();
        System.out.println(sb3);

        StringBuilder sb4 = new StringBuilder("Caroline ");
        sb4.insert(8, "hi");

        System.out.println(sb4);










        
    }
}
