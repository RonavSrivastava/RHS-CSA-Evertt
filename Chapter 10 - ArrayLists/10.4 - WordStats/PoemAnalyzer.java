import java.util.ArrayList;

public class PoemAnalyzer {
    private String poem;
    private ArrayList<String> poemWords;
    public ArrayList<String> poemWordsNoDupes;
    public ArrayList<Integer> counts;

    public PoemAnalyzer(String p) {
        poem = p;
        poemWords = splitString(p);
        cleanPoem();
        poemWordsNoDupes = noDupes(poemWords);
        counts = new ArrayList<>();
        count();
    }

    private void cleanPoem() {
        for(int i = 0; i < poemWords.size(); i++) {
            if(poemWords.get(i).charAt(0) == ' ') {
                poemWords.set(i, poemWords.get(i).toLowerCase().substring(1));
            }
            else {
                poemWords.set(i, poemWords.get(i).toLowerCase());
            }
        }
    }

    private static ArrayList<String> splitString(String input) {
        //this is overly complicated but it works
        ArrayList<String> output = new ArrayList<String>();
        String input2 = "";

        //remove all symbols
        for(int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i)) || (input.charAt(i) == ' ')) {
                input2 += input.charAt(i);
            }
        }

        //remove doubled up spaces because the output would have a string with only a space
        String input3 = "";
        for(int i = 0; i < input2.length(); i++) {
            if (input2.charAt(i) == ' ') {
                while(input2.charAt(i) == ' ' && i < input2.length()-1) {
                    i++;
                }
                if(input2.charAt(i) != ' ') {
                    input3 += " ";
                    input3 += input2.charAt(i);
                }
            } else {
                input3 += input2.charAt(i);
            }
        }

        
        int start = 0;
        int end = 0;
        while(true) {
            end = input3.indexOf(" ", start+1);
            if (end == -1) {
                //if it fails to find another space, grab the rest of the string then return
                output.add(input3.substring(start, input3.length()));
                return output;
            }
            output.add(input3.substring(start, end));
            start = end;
        }
    }

    private ArrayList<String> noDupes(ArrayList<String> poem) {
        ArrayList<String> output = new ArrayList<>();
        for(int i = 0; i < poem.size(); i++) {
            boolean dupe = false;
            for(int j = 0; j < output.size(); j++) {
                if(poem.get(i).equals(output.get(j))) {
                    dupe = true;
                }
            }
            if(!dupe) {
                output.add(poem.get(i));
            }
        }
        return output;
    }

    private void count() {
        for(int i = 0; i < poemWordsNoDupes.size(); i++) {
            counts.add(0);
            for(int j = 0; j < poemWords.size(); j++) {
                if(poemWords.get(j).equals(poemWordsNoDupes.get(i))) {
                    counts.set(i, counts.get(i)+1);
                }
            }
        }
    }

    public void printStats() {
        while(counts.isEmpty() == false) {
            int curMax = 0;
            for(int i = 0; i < counts.size(); i++) {
                if(counts.get(i) > counts.get(curMax)) {
                    curMax = i;
                }
                if (poemWordsNoDupes.get(i).compareTo(poemWordsNoDupes.get(curMax)) < 0 && counts.get(i) >= counts.get(curMax)) {
                    curMax = i;
                }
            }
            System.out.println(poemWordsNoDupes.get(curMax) + " (" + counts.get(curMax) + ")");
            counts.remove(curMax);
            poemWordsNoDupes.remove(curMax);
        }
    }
}
