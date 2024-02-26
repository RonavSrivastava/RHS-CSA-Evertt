import java.util.ArrayList;

public class WordsAndCounts {
    public ArrayList<String> poemWordsNoDupes;
    public ArrayList<Integer> counts;
    
    public WordsAndCounts(ArrayList<String> poemWords) {
        poemWordsNoDupes = HelperFuncs.remDupes(poemWords);
        counts = HelperFuncs.count(poemWords, poemWordsNoDupes);
    }
}
