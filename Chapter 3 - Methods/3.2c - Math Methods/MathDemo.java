// Demos the creation of simple math methods (pow, sumToN, ...)
public class MathDemo {
    public static void main(String[] args) {

        // Add code the exercises (run & test) all the code you wrote in this class. 
        // Pick good examples (non-trivial but also something you can hand-verify).  
        // Be sure to identify the output For example: System.out.println("pow(2, 3) == " + pow(2, 3));
        System.out.println("pow(2, 3) == " + pow(2, 3));
        System.out.println("factorial(7) == " + factorial(7));
        System.out.println("sumToN(3) == " + sumToN(3));
        System.out.println("sumSquares(4) == " + sumSquares(4));
        System.out.println("repeat(\"hehe\", 2) == " + repeat("hehe", 2));
        System.out.println("padLeft(\"hehe\", 6) == " + padLeft("hehe", 6));
        printTableOfSquares(1000);
        System.out.println("---- MathDemo: Done ----"); 
    }
    
    // ------------------------------------------------------
    // computes 'num' to the 'exponent'  Thus pow(2,3) == 8
    // ‘exponent’ is required to be non-negative integer.  
    // num and exponent are both integers. returns an integer.  
    public static int pow(int b, int e) throws ArithmeticException {
        if (e < 0) {
            throw new ArithmeticException("the exponent must be positive");
        }
        int output = b;
        for(int i = 0; i < e-1; i++) {
            output *= b;
        }
        return output;
    }
    
    // ------------------------------------------------------
    // computes n! that is n * (n-1) * (n-2) ... 3 * 2 * 1
    // factorial(0) == 1.  
    // takes an integer n and returns an integer; 
    public static int factorial(int b) {
        int output = b;
        for(int i = b-1; i > 0; i--) {
            output *= i;
        }
        if (output == 0) {
            return 1;
        }
        else {
            return output;
        }
    }

    // ------------------------------------------------------
    // computes the sum of all integers from 1 to maxNum inclusive.  
    // Thus sumToN(0) == 0  sumToN(3) == 6
    // takes an integer maxNum and returns an integer; 
    public static int sumToN(int b) {
        int output = b;
        for(int i = b-1; i > 0; i--) {
            output += i;
        }
        return output;
    }
    
    // ------------------------------------------------------
    // computes the sum of the squares to n.   
    // that is N*N + (N-1)*(N-1) ... 3*3 + 2*2 + 1*1
    // takes an integer maxNum and returns an integer     
    public static int sumSquares(int b) {
        int output = b*b;
        for(int i = b-1; i > 0; i--) {
            output += i*i;
        }
        return output;
    }
    
    // ------------------------------------------------------
    // returns a string that is 'str' repeated 'count' times 
    // takes a str and count argument and returns a string. 
    public static String repeat(String str, int count) {
        String output = "";
        for(int i = 0; i < count; i++) {
            output += str;
        }
        return output;
    }
    
    // ------------------------------------------------------
    // returns a string that is 'str' padded with spaces 
    // so that it has a total of 'width' characters
    // Callers should insure that the length of str <= width
    // Takes a str and width argument and returns a string.
    public static String padLeft(String str, int width) throws IllegalArgumentException {
        if (str.length() > width) {
            throw new IllegalArgumentException("the length of the string must be less than the width");
        }
        String output = "";
        for(int i = 0; i < width-str.length(); i++) {
            output += " ";
        }
        output += str;
        return output;
    }
    
    // ------------------------------------------------------
    // print a table of square that starts at 1 and goes up to and includes maxN
    // +-----+-------+
    // |  N  |  N*N  |
    // +-----+-------+
    // |   1 |     1 |
    // |   2 |     4 |
    //      ... omitted ...
    // |  10 |   100 |
    //      ... omitted ...
    // | 100 | 10000 | 
    // +-----+-------+
    // You can assert that maxN*maxN < 100000 and maxN < 1000
    // Thus N will be at most a 3 digit number and maxN will be
    // at most a 5 digit number.   
    public static void printTableOfSquares(int maxN) throws IllegalArgumentException {
        if (maxN > 1000) {
            throw new IllegalArgumentException("input must be less than 1000");
        }
        String intStr;
        String intStr2;

        System.out.println("+-----+-------+");
        System.out.println("|  N  |  N*N  |");
        System.out.println("+-----+-------+");

        for(int i = 0; i <= maxN; i++) {
            System.out.print("|");
            intStr = Integer.toString(i);
            System.out.print(padLeft(intStr, 4) + " ");
            System.out.print("|");
            intStr2 = Integer.toString(i*i);
            System.out.print(padLeft(intStr2, 7) + " ");
            System.out.println("|");
        }

        System.out.println("+-----+-------+");

        // NOTE YOU MUST PAD INTEGERS so that the table looks pretty.  
        // Thus you immediately can use your padLeft method.  
        
        // HINT: To convert an integer to a strings use the method
    }    
}  
