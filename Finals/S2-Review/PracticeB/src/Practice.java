import java.util.ArrayList;

public class Practice {
    /*
     * strCatColumn - concatenates a column in a 2D array of strings.
     * returns null on invalid parameters.
     * strCatColumn({ { "a", "b", "c" }, { "d", "e", "f" } }, 0 ) -> "ad"
     * strCatColumn({ { "a", "b", "c" }, { "d", "e", "f" } }, 1 ) -> "be"
     */
    public String strCatColumn(String[][] m, int c) {
        if (c > m[0].length - 1 || c < 0) {
            return null;
        }
        String output = "";
        for (String[] r : m) {
            output += r[c];
        }
        return output;
    }

    /*
     * calcSeriesRecursive - write a RECURSIVE method that computes the sum
     * of the first n terms of: a(1)+b + a(2)+b + ... + an+b
     * calcSeriesRecursive(2,1,3) -> 15 (because: 3 + 5 + 7 = 15)
     * calcSeriesRecursive(-3,10,12) -> -114
     */
    public int calcSeriesRecursive(int a, int b, int n) {
        if (n == 0) {
            return 0;
        }
        return a * n + b + calcSeriesRecursive(a, b, n - 1);
    }

    /*
     * createFibonacciArray - write a method that returns an array containing
     * the numbers in the fibonacci sequence starting at a given number. If
     * the given number is not part of the sequence, then null should be
     * returned. The number of items in sequence is the second parameter.
     * createFibonacciArray(1, 5) -> { 1, 1, 2, 3, 5 }
     * createFibonacciArray(8, 4) -> { 8, 13, 21, 34 }
     * createFibonacciArray(4, 3) -> null
     */
    public int[] createFibonacciArray(int first, int seqCount) {
        int[] arr = new int[seqCount];
        int a = 0;
        int b = 1;
        while (a != first) {
            if (a > first) {
                return null;
            }
            int temp = b;
            b = a + b;
            a = temp;
        }
        for (int i = 0; i < seqCount; i++) {
            if (i > 1) {
                arr[i] = arr[i - 1] + arr[i - 2];
            } else if (i == 0) {
                arr[i] = a;
            } else if (i == 1) {
                arr[i] = b;
            }
        }
        return arr;

        // ArrayList<Integer> seq = new ArrayList<Integer>();
        // seq.add(0);
        // seq.add(1);
        // while (seq.get(seq.size() - 1) != first) {
        // if (seq.size() == 1) {
        // seq.add(1);
        // } else {
        // seq.add(seq.get(seq.size() - 1) + seq.get(seq.size() - 2));
        // if (seq.get(seq.size() - 1) > first) {
        // return null;
        // }
        // }
        // }
        // for (int i = 0; i < seqCount - 1; i++) {
        // if (seq.size() == 1) {
        // seq.add(1);
        // } else {
        // seq.add(seq.get(seq.size() - 1) + seq.get(seq.size() - 2));
        // }
        // }
        // while (seq.get(0) != first) {
        // seq.remove(0);
        // }
        // int[] arr = new int[seqCount];
        // for (int i = 0; i < seqCount; i++) {
        // arr[i] = seq.get(i);
        // }
        // return arr;
    }
}