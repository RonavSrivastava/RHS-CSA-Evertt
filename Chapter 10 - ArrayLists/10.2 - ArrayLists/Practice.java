import java.util.ArrayList;

public class Practice {
    /* Write a method called toArrayList that takes an array of Strings and
     *  return an ArrayList populated with the same list of Strings.
     * Example...
     *  input: { "a", "b", "c" }, output: [ a, b, c ]
     */ 
    // TODO: write the method toArrayList
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
    // TODO: write the method reverseList
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
    // TODO: write the method splitString
    public static ArrayList<String> splitString(String input) {
        ArrayList<String> output = new ArrayList<String>();
        for(int i = 0; i < input.length(); i++) {
            
        }
        return output;
    }

    /* Write a method called justPrimes that takes an Array of integer types
     *  and returns an ArrayList of the subset of those numbers that are prime.
     * Examples...
     *  input: { 1, 3, 4, 7, 8, 11 }, output: [ 1, 3, 7, 11 ]
     */ 
    // TODO: write the method justPrimes
}