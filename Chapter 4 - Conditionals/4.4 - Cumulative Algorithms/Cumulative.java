public class Cumulative {
    public static String alphabet(char first, int count) {
        // Return a String consiting of a section of the alphabet.
        //  It should start with letter 'first' and contain 'count' letters.
        //  If count goes past 'z', then it should wrap back around to 'a' 
        //    for the next letter.
        //  You can assume that first is a lowercase letter.
        
        // Examples...
        //  alphabet('a', 5) -> "abcde"
        //  alphabet('c', 4) -> "cdef"
        //  alphabet('y', 6) -> "yzabcd"
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int loc = alpha.indexOf(first);
        String output = "";
        for(int i = loc; i<loc+count; i++) {
            output += alpha.charAt(i%26);
        }
        return output;
    }

    public static int factorSum(int n) {
        // Returns the sum of all factors of n, except for n itself
        
        // Examples...
        //  factorSum(6) -> 6      // 1 + 2 + 3
        //  factorSum(14) -> 10    // 1 + 2 + 7
        int output = 0;
        for(int i = 1; i < n; i++) {
            if(n%i == 0) {
                output += i;
            }
        }
        return output;
    }

    public static boolean isPerfect(int n) {
        // Returns true if n is a perfect number, false otherwise
        //  A perfect number is a positive integer that is equal to the sum of its proper divisors.
        //  Use the factorSum function you wrote to help you do this (and do not copy the code).
        
        // Examples...
        //  factorSum(6) -> true   // 1 + 2 + 3 = 6, so it is a perfect number
        //  factorSum(14) -> false // 1 + 2 + 7 = 10, which is not 14, so not perfect
        if (n == factorSum(n)) {
            return true;
        }
        else {
            return false;
        }
    }
}
