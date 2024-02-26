public class PoemAnalyzer {
    private WordsAndCounts WAC;

    public PoemAnalyzer(String p) {
        WAC = new WordsAndCounts(HelperFuncs.splitString(p));
    }

    public void printStats() {
        while (WAC.counts.isEmpty() == false) {
            int curMax = 0;
            for (int i = 0; i < WAC.counts.size(); i++) {
                if (WAC.counts.get(i) > WAC.counts.get(curMax)) {
                    curMax = i;
                }
                if (WAC.poemWordsNoDupes.get(i).compareTo(WAC.poemWordsNoDupes.get(curMax)) < 0
                        && WAC.counts.get(i) >= WAC.counts.get(curMax)) {
                    curMax = i;
                }
            }
            System.out.println(WAC.poemWordsNoDupes.get(curMax) + " (" + WAC.counts.get(curMax) + ")");
            WAC.counts.remove(curMax);
            WAC.poemWordsNoDupes.remove(curMax);
        }
    }
}
