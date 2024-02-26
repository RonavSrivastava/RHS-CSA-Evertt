import java.util.ArrayList;

public class HelperFuncs {
    public static ArrayList<String> splitString(String input) {
        // this is overly complicated but it works
        ArrayList<String> output = new ArrayList<String>();
        String input2 = "";

        // remove all symbols
        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i)) || (input.charAt(i) == ' ')) {
                input2 += input.charAt(i);
            }
        }

        // remove doubled up spaces because the output would have a string with only a
        // space
        String input3 = "";
        for (int i = 0; i < input2.length(); i++) {
            if (input2.charAt(i) == ' ') {
                while (input2.charAt(i) == ' ' && i < input2.length() - 1) {
                    i++;
                }
                if (input2.charAt(i) != ' ') {
                    input3 += " ";
                    input3 += input2.charAt(i);
                }
            } else {
                input3 += input2.charAt(i);
            }
        }

        int start = 0;
        int end = 0;
        while (true) {
            end = input3.indexOf(" ", start + 1);
            if (end == -1) {
                // if it fails to find another space, grab the rest of the string then stop
                output.add(input3.substring(start, input3.length()));
                break;
            }
            output.add(input3.substring(start, end));
            start = end;
        }

        for (int i = 0; i < output.size(); i++) {
            if (output.get(i).charAt(0) == ' ') {
                // remove if it starts with a space (there was a bug where the first word didnt
                // have a space before it, and also capitals were messing things up)
                output.set(i, output.get(i).toLowerCase().substring(1));
            } else {
                output.set(i, output.get(i).toLowerCase());
            }
        }
        return output;
    }

    public static ArrayList<String> remDupes(ArrayList<String> poem) {
        ArrayList<String> output = new ArrayList<>();
        for (int i = 0; i < poem.size(); i++) {
            boolean dupe = false;
            for (int j = 0; j < output.size(); j++) {
                if (poem.get(i).equals(output.get(j))) {
                    dupe = true;
                }
            }
            if (!dupe) {
                output.add(poem.get(i));
            }
        }
        return output;
    }

    public static ArrayList<Integer> count(ArrayList<String> poemWords, ArrayList<String> poemWordsNoDupes) {
        ArrayList<Integer> counts = new ArrayList<Integer>();
        for (int i = 0; i < poemWordsNoDupes.size(); i++) {
            counts.add(0);
            for (int j = 0; j < poemWords.size(); j++) {
                if (poemWords.get(j).equals(poemWordsNoDupes.get(i))) {
                    counts.set(i, counts.get(i) + 1);
                }
            }
        }

        return counts;
    }
}