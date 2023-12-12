public class StringUtil {
    public static String firstHalf(String input) {
        // Returns a string containing the first half of 'input'
        // In the case of an odd number of characters, the extra goes in the second half (excluded here)
        //  Example: "0123456789" -> "01234"
        // 
        // Requirements...
        //  - Use a loop to build the return string.

        int len = input.length();
        len /= 2;
        String output = "";
        for (int i = 0; i < len; i++) {
            output = output + input.charAt(i);
        }

        return output;
    }

    public static String beforeSpace(String input) {
        // Returns a string containing the portion of the string BEFORE the space
        // In the case of no space, the full string should be returned
        //  Example: "abcd ef" -> "abcd"
        // 
        // Requirements...
        //  - Use the string function substring.
        int start = 0;
        int len = input.length();
        int end = len;
        for (int i = 0; i < len; i++) {
            char inputChar = input.charAt(i);
            for (;inputChar == ' ';) {
                end = i;
                return input.substring(start, end);
            }
        }
        return input.substring(start, end);
    }

    public static String afterSpace(String input) {
        // Returns a string containing the portion of the string AFTER the space
        // In the case of no space, an empty string should be returned
        //  Example: "abcd ef" -> "ef"
        // 
        // Requirements...
        //  - Use the string function substring.
        int len = input.length();
        int start = 0;
        int end = len;
        for (int i = 0; i < len-1; i++) {
            char inputChar = input.charAt(i);
            for (;inputChar == ' ';) {
                start = i+1;
                return input.substring(start, end);
            }
        }
        return "";
    }

    public static String swapAtSpace(String input) {
        // Returns a string that swaps the section before and after the space
        //  Example: "abcd ef" -> "ef abcd"
        // 
        // Requirements...
        //  - The other functions you created for this.
        int spaceLoc = input.indexOf(" "); 
        String str1 = input.substring(0, spaceLoc);
        String str2 = input.substring(spaceLoc + 1, input.length());
        return str2 + " " + str1;
    }

    public static char firstNonRepeatedChar(String input) {
        // Returns the first character that is not repeated later in the string (looking left to right)
        //  Example: "abcabcdef" -> 'd'

        //loop through each character
        for(int i = 0; i < input.length(); i++) {
            char curChar = input.charAt(i);
            boolean done = true;
            for(int j = 0; j < input.length(); j++) {
                //loop through all the characters again
                for (;input.charAt(j) == curChar && j != i && done;) {
                    //if they match, then break and move to next character
                    done = false;
                }
            }
            for (;done;) {
                //if it didnt find a match, then return whatever the character was
                return curChar;
            }
        }
        return 0;
    }
}
