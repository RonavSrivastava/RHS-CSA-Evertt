import java.util.ArrayList;
import java.util.Arrays;

public class AppMain {
    public static void main(String[] args) {
        Practice practice = new Practice();

        System.out.println("-------- isPalindrome --------");
        System.out.println(practice.isPalindrome("racecar"));
        System.out.println(practice.isPalindrome("test"));

        System.out.println("\n-------- sumDigits --------");
        System.out.println(practice.sumDigits(123));
        System.out.println(practice.sumDigits(572));
        System.out.println(practice.sumDigits(116));

        System.out.println("\n-------- createString --------");
        System.out.println(practice.createString(3));
        System.out.println(practice.createString(5));
        System.out.println(practice.createString(1));
        System.out.println(practice.createString(0));
        
        System.out.println("\n-------- minValue --------");
        System.out.println(practice.minValue(new ArrayList<>(Arrays.asList(-3, 7, -8, 4, 0)), 0));
        System.out.println(practice.minValue(new ArrayList<>(Arrays.asList(8, 7, 1, 10, 6, 9)), 3));
        System.out.println(practice.minValue(new ArrayList<>(Arrays.asList(-1, 0, 1, 2, 3)), 1));
    }
}
