import java.util.ArrayList;

public class Practice {
    /*
     * strPatternA - prints out a pattern of dashes, driven by the
     * givin input parameters. Use the examples to understand the pattern.
     * strPatternA(3, 2)
     * "--
     * -----
     * --------"
     * strPatternA(2, 5)
     * "-----
     * -------"
     * strPatternA(4, 1)
     * "-
     * -----
     * ---------
     * -------------"
     */
    public String strPatternA(int x, int y) {
        String output = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x * i + y; j++) {
                output += "-";
            }
            output += "\n";
        }
        output = output.substring(0, output.length() - 1);
        return output;
    }

    /*
     * strPatternB - prints a string multiple times, separated by commas.
     * strPatternB("abc", 3) -> "abc, abc, abc"
     * strPatternB("x", 4) -> "x, x, x, x"
     * strPatternB("ttfn", 1) -> "ttfn"
     */
    public String strPatternB(String str, int n) {
        if (str.length() == 0) {
            return "";
        }
        String output = "";
        for (int i = 0; i < n; i++) {
            output += str + ", ";
        }
        output = output.substring(0, output.length() - 2);
        return output;
    }

    /*
     * percToLetterGrade - Converts from a [0,100] to an N,D,C,B,A letter grade
     * percToLetterGrade(89.9) -> "B"
     * percToLetterGrade(61.8) -> "D"
     * percToLetterGrade(55.5) -> "N"
     */
    public String percToLetterGrade(double perc) {
        if (perc >= 0 && perc <= 100) {
            if (perc >= 90) {
                return "A";
            } else if (perc >= 80) {
                return "B";
            } else if (perc >= 70) {
                return "C";
            } else if (perc >= 60) {
                return "D";
            } else if (perc < 60) {
                return "N";
            }
        }
        return "Not a valid grade";
    }

    /*
     * strToList - Converts a list of integers into an array. The string is
     * deliminated by a character given as a parameter. It returns null
     * in an invalid chacter is found in the string. Note that the helper
     * method tryParseInt is provided for you below.
     * strToList("1,2,3,4", ',') -> { 1, 2, 3, 4 }
     * strToList("5; 2", ';') -> { 5, 2 }
     * strToList("5; 2", ',') -> null
     */
    public int[] strToList(String str, char delim) {
        for(int i = 0; i < recur(str, delim, new int[] {}).length; i++) {
            System.out.println(recur(str, delim, new int[] {})[i]);
        }
        return recur(str, delim, new int[] {});
    }

    public int[] recur(String str, char delim, int[] cur) {
        if (str.length() == 0 || str.indexOf(delim) == -1) {
            return new int[] {};
        }
        int[] next = new int[cur.length + 1];
        for (int i = 0; i < cur.length; i++) {
            next[i + 1] = cur[i];
        }
        String sub = str.substring(0, str.indexOf(delim));
        String rest = str.substring(str.indexOf(delim) + 1, str.length());
        next[0] = tryParseInt(sub);
        if(next[0].equals(null)) {
            return null;
        }
        return recur(rest, delim, next);
    }

    // Helper method - converts an integer contained in a string to an Integer
    // type. If an integer is not contained in the string, it will return null.
    public Integer tryParseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
