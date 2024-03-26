import java.util.ArrayList;

public class NumberGuesser extends NumberGuesserBase {
    public NumberGuesser() {
    }

    /*
     * Things you can use & how your methods should behave...
     * Your methods should repeatedly call the parent class method guess(int n)
     * to guess a number, until a match is found. That method returns...
     * 0 : You are correct (you got it!)
     * -1 : My number is smaller than your guess
     * 1 : My number is larger than your guess
     * Each of your methods should return the correctly guessed number.
     */

    /*
     * guessNumberBasic() should be a very simple linear/sequential
     * guesser (i.e. it should guess 1, 2, 3, ... till it finds it).
     * This method should not attempt to minimize guesses, it is purely
     * a linear / sequential guesser. Keep it simple.
     */
    public int guessNumberBasic() {
        int curGuess;
        for (curGuess = 0; guess(curGuess) != 0; curGuess++) {}
        return curGuess;
    }

    /*
     * guessNumberFast() should try to guess the number with the minimum
     * number of guesses. This is the method I will judge you on.
     * Unlike the sequential guesser, this method should attempt to
     * minimize the number of guesses it takes to guess the answer.
     */
    public int guessNumberFast() {
        ArrayList<Integer> posGuesses = new ArrayList<Integer>();
        for (int i = 0; i < 1001; i++) {
            posGuesses.add(i);
        }

        return recur(posGuesses);
        // return binarySearch(posGuesses);
    }

    public int recur(ArrayList<Integer> posGuesses) {
        int idx = posGuesses.size() / 2;
        int check = guess(posGuesses.get(idx));
        for (int i = posGuesses.size() - 1; i >= 0; i--) {
            if ((check == 1 && i <= idx) || (check == -1 && i >= idx)) {
                posGuesses.remove(i);
            }
        }
        return check == 0 ? posGuesses.get(idx) : recur(posGuesses);
    }

    public int binarySearch(ArrayList<Integer> posGuesses) {
        int min = 0;
        int max = posGuesses.size();

        while (min <= max) {
            int mid = (max + min) / 2;
            int check = guess(mid);
            if (check == 0) {
                return mid;
            } else if (min == max) {
                return -1;
            } else if (check == -1) {
                max = mid - 1;
            } else if (check == 1) {
                min = mid + 1;
            }
        }
        return -1;
    }
}
