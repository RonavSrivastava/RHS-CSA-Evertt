import java.util.ArrayList;

public class Practice {
    /* Write a method called toArrayList that takes an array of Strings and
     *  return an ArrayList populated with the same list of Strings.
     * Example...
     *  input: { "a", "b", "c" }, output: [ a, b, c ]
     */ 
    public static ArrayList<String> toArrayList(String[] input) {
        ArrayList<String> output = new ArrayList<String>();
        for(int i = 0; i < input.length; i++) {
            output.add(input[i]);
        }
        return output;
    }

    /* Write a method called reverseList that takes an array of Strings and
     *  return a new ArrayList with the same strings, but with their locations
     *  in the list reversed in order.
     * Example...
     *  input: { "a", "b", "c" }, output: [ c, b, a ]
     */ 
    public static ArrayList<String> reverseList(String[] input) {
        ArrayList<String> output = new ArrayList<String>();
        for(int i = input.length-1; i >= 0; i--) {
            output.add(input[i]);
        }
        return output;
    }

    /* Write a method called splitString that takes a String and returns an
     *  ArrayList with each word in the String as an element of the ArrayList.
     *  Words in the input are delimited by spaces and punctuation including
     *  periods, commas, exclemation, and question marks.
     * Note that I'm asking you to write your own (don't use a system method for this)
     * Examples...
     *  input: "This is a test", output: [ this, is, a, test ]
     *  input: "Hi. What, is your name?", output: [ Hi, What, is, your, name ]
     */ 
    public static ArrayList<String> splitString(String input) {
        //this is overly complicated but it works
        ArrayList<String> output = new ArrayList<String>();
        String input2 = "";

        //remove all symbols
        for(int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i)) || (input.charAt(i) == ' ')) {
                input2 += input.charAt(i);
            }
        }

        //remove doubled up spaces because the output would have a string with only a space
        String input3 = "";
        for(int i = 0; i < input2.length(); i++) {
            if (input2.charAt(i) == ' ') {
                while(input2.charAt(i) == ' ' && i < input2.length()-1) {
                    i++;
                }
                if(input2.charAt(i) != ' ') {
                    input3 += " ";
                    input3 += input2.charAt(i);
                }
            } else {
                input3 += input2.charAt(i);
            }
        }

        
        int start = 0;
        int end = 0;
        while(true) {
            end = input3.indexOf(" ", start+1);
            if (end == -1) {
                //if it fails to find another space, grab the rest of the string then return
                output.add(input3.substring(start, input3.length()));
                return output;
            }
            output.add(input3.substring(start, end));
            start = end;
        }
    }

    /* Write a method called justPrimes that takes an Array of integer types
     *  and returns an ArrayList of the subset of those numbers that are prime.
     * Examples...
     *  input: { 1, 3, 4, 7, 8, 11 }, output: [ 1, 3, 7, 11 ]
     */ 
    public static ArrayList<String> justPrimes(Integer[] input) {
        ArrayList<String> output = new ArrayList<String>();
        for(int i = 0; i < input.length; i++) {
            if (isPrime(input[i])) {
                output.add(Integer.toString(input[i]));
            }
        }
        return output;
    }

    private static boolean isPrime(int num) {
        for(int i = 2; i < num; i++) {
            if(num%i == 0) {
                return false;
            }
        }
        return true;
    }
}