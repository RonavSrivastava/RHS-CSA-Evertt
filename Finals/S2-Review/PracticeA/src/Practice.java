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
        return (perc >= 90 && perc <= 100) ? "A" : (perc >= 80) ? "B" : (perc >= 70) ? "C" : (perc >= 60) ? "D" : (perc < 60 && perc >= 0) ? "N" : null;
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
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ' && str.charAt(i-1) == delim) {
                str = str.substring(0, i) + str.substring(i + 1, str.length());
                i--;
            }
        }

        ArrayList<Integer> output = new ArrayList<Integer>();
        while (str.length() > 0 && str.indexOf(delim) != -1) {
            output.add(tryParseInt(str.substring(0, str.indexOf(delim))));
            if (tryParseInt(str.substring(0, str.indexOf(delim))) == null) {
                output.remove(output.size() - 1);
            }
            str = str.substring(str.indexOf(delim) + 1, str.length());
        }
        output.add(tryParseInt(str));
        if (tryParseInt(str) == null) {
            return null;
        }

        int[] arr = new int[output.size()];
        for (int i = 0; i < output.size(); i++) {
            arr[i] = output.get(i);
        }
        return arr;
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
