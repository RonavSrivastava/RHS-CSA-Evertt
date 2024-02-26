import java.util.ArrayList;

public class PoemAnalyzer {
    private ArrayList<String> poemWords;
    public ArrayList<String> poemWordsNoDupes;
    public ArrayList<Integer> counts;

    public PoemAnalyzer(String p) {
        poemWords = HelperFuncs.splitString(p);
        poemWordsNoDupes = HelperFuncs.remDupes(poemWords);
        counts = HelperFuncs.count(poemWords, poemWordsNoDupes);
    }

    public void printStats() {
        while (counts.isEmpty() == false) {
            int curMax = 0;
            for (int i = 0; i < counts.size(); i++) {
                if (counts.get(i) > counts.get(curMax)) {
                    curMax = i;
                }
                if (poemWordsNoDupes.get(i).compareTo(poemWordsNoDupes.get(curMax)) < 0
                        && counts.get(i) >= counts.get(curMax)) {
                    curMax = i;
                }
            }
            System.out.println(poemWordsNoDupes.get(curMax) + " (" + counts.get(curMax) + ")");
            counts.remove(curMax);
            poemWordsNoDupes.remove(curMax);
        }
    }
}
