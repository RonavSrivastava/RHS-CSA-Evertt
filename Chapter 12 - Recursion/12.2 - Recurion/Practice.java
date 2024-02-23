public class Practice {
    private int num;
    private int pow;

    /* Write a recurisve version of the method pow, which computes the value of
     *  b to the power of e. Preconditions: b >= 1 && e >= 1
     *  note: Do not modify pow, but do implement powR to have the same behavior,
     *        but impliment it with recursion, instead of a loop.
     * Example...
     *  input: powR(3, 2), output: 9
     *  input: powR(5, 3), output: 125
     */ 
    public int pow(int b, int e) {
        int result = 1;
        for (int i = 0; i < e; i++) {
            result *= b;
        }
        return result;
    }
    public int powR(int b, int e) {
        if(e == 0) {
            return 1;
        }
        return b * powR(b, e-1);
    }


    /* Write a recurisve version of the method createString, which prints out an asterisk
     *  surrounded by a symmetric set of brackets. Preconditions: n >= 0
     *  note: Do not modify createString, but do implement createStringR to have the same behavior,
     *        but impliment it with recursion, instead of a loop.
     * Example...
     *  input: createStringR(3), output: [[[*]]]
     *  input: createStringR(5), output: [[[[[*]]]]]
     *  input: createStringR(0), output: *
     */
    public String createString(int n) {
        String prefix = "";
        String postfix = "";
        for (int i = 0; i < n; i++) {
            prefix += "[";
            postfix += "]";
        }
        return prefix + "*" + postfix;
    }
    public String createStringR(int n) {
        if(n == 0) {
            return "*";
        }
        return "[" + createStringR(n-1) + "]";
    }

    
    /* Write a method called printBinary that takes an integer and prints out the number
     *  in binary (base 2). Your implementation must use recursion. 
     *  Preconditions: Integer.MAX_VALUE >= n >= 0
     * Examples...
     *  input: printBinary(5), output: 0101 (or 101)
     *  input: printBinary(201), output: 011001001 (or 11001001)
     */ 
    // TODO: write the method printBinary
    public void printBinaryR(int n) {
        num = n;
        pow = getLargestPow2(n);
        printBinaryR();
    }

    public void printBinaryR() {
        if(pow < 0) {
            return;
        }
        else if(powR(2, pow) > num) {
            System.out.print(0);
            pow--;
            printBinaryR();
        }
        else {
            System.out.print(1);
            num = num - powR(2, pow);
            pow--;
            printBinaryR();
        }
    }

    public int getLargestPow2(int n) {
        for(int i = 0; i < n; i++) {
            if(powR(2, i) > n) {
                return i-1;
            }
        }
        return -1;
    }
}