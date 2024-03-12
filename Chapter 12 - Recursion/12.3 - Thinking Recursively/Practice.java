import java.util.ArrayList;

public class Practice {
    /*
     * Write a palindrome string checker. It should take a String as input and
     * return a boolean to indicate if it is a palindrome. Note that a palindrome
     * is a strig that reads the same backwards as forwards. Note that any single
     * letter string is considered a panindrome.
     * Your method must use recursion in its solution.
     * 
     * Examples...
     * input: isPalindrome("racecar"), output: true
     * input: isPalindrome("test"), output: false
     */
    public boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        return s.charAt(0) == s.charAt(s.length() - 1) ? isPalindrome(s.substring(1, s.length() - 1)) : false;
    }

    /*
     * Write a method to sum the digits of a number. It should take an int and
     * return an int. Precondition is that n is non-negative.
     * Your method must use recursion in its solution.
     * 
     * Examples...
     * input: sumDigits(123), output: 6
     * input: sumDigits(572), output: 14
     * input: sumDigits(116), output: 8
     */
    public int sumDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumDigits(n / 10);
    }

    /*
     * Write a method that returns a symmetric String that matches the
     * examples given below. Extrapolate the generic case from the given examples.
     * Your method must use recursion in its solution.
     * 
     * Examples...
     * input: createString(3), output: "321.123"
     * input: createString(5), output: "54321.12345"
     * input: createString(1), output: "1.1"
     * input: createString(0), output: ""
     */
    public String createString(int n) {
        if (n == 0) {
            return ".";
        }
        return n + createString(n - 1) + n;
    }

    /*
     * Write a method that find the smallest number in an array, starting
     * at an index specified by an input parameter.
     * Preconditions: list has at least one element, and 0 <= n < list.length
     * Your method must use recursion in its solution.
     * 
     * Examples...
     * input: minValue({-3, 7, -8, 4, 0}, 0), output: -8
     * input: minValue({8, 7, 1, 10, 6, 9}, 3), output: 6
     * input: minValue({-1, 0, 1, 2, 3}, 1), output: 0
     */
    public int minValue(ArrayList<Integer> ints, int idx) {
        if (ints.size() == 1) {
            return ints.get(0);
        }
        int i = 0;
        if (i < idx) {
            ints.remove(i);
            idx--;
        } else if (ints.get(i) > ints.get(1)) {
            ints.remove(i);
        } else {
            ints.remove(1);
        }
        return minValue(ints, idx);
    }
}