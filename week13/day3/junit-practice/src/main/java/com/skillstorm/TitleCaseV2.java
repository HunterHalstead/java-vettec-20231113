package com.skillstorm;

public class TitleCaseV2 {
	
    public static String titleCase(String str) {
        if (str == null) throw new IllegalArgumentException("Title cannot be null");
        String output = str.toLowerCase();

        StringBuilder sb = new StringBuilder();

        boolean capNext = true;
        for (int i = 0; i < output.length(); i++) {
            if (i == 0)
                sb.append(Character.toUpperCase(output.charAt(i)));
            else if (capNext && wordMoreThan2Chars(str, i))
                sb.append(Character.toUpperCase(Character.toUpperCase(output.charAt(i))));
            else
                sb.append(output.charAt(i));

            capNext = (charSeparator(output.charAt(i)));

        }
        return sb.toString();
    }
    private static boolean charSeparator(char c) {
        return c == ',' || c == ';' || c == ':' || c == '.' || c == ' ' || c == '-';
    }
    private static boolean wordMoreThan2Chars(String str, int startIndex) {
        int length = 0;

        for (int i = startIndex; i < str.length(); i++) {
            if (charSeparator(str.charAt(i))) break;
            else length++;
        }

        return length > 2;
    }
}
