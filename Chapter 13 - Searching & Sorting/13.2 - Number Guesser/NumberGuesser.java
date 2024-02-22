import java.util.ArrayList;

public class NumberGuesser extends NumberGuesserBase {
    private int curGuess;
    private int split;
    private ArrayList<Integer> posGuesses;

    public NumberGuesser() {
        curGuess = 0;
        split = 500;
        posGuesses = new ArrayList<Integer>();
        for(int i = 0; i < 1001; i++) {
            posGuesses.add(i);
        }
    }

    /* Things you can use & how your methods should behave...
     *   Your methods should repeatedly call the parent class method guess(int n)
     *   to guess a number, until a match is found. That method returns...
     *       0 : You are correct (you got it!)
     *      -1 : My number is smaller than your guess
     *       1 : My number is larger than your guess
     * Each of your methods should return the correctly guessed number. */

    /* guessNumberBasic() should be a very simple linear/sequential
     *   guesser (i.e. it should guess 1, 2, 3, ... till it finds it).
     *   This method should not attempt to minimize guesses, it is purely 
     *   a linear / sequential guesser. Keep it simple. */
    public int guessNumberBasic() {
        while(guess(curGuess) != 0) {
            curGuess++;
        }
        int temp = curGuess;
        curGuess = 0;
        return temp;
    }

    /* guessNumberFast() should try to guess the number with the minimum
     *   number of guesses. This is the method I will judge you on. 
     *   Unlike the sequential guesser, this method should attempt to 
     *   minimize the number of guesses it takes to guess the answer. */
    public int guessNumberFast() {
        boolean done = false;
        while(done == false) {
            int check = guess(split);
            if(check == 1) {
                for(int i = posGuesses.size() - 1; i >= 0; i--) {
                    if(posGuesses.get(i) < split) {
                        posGuesses.remove(i);
                    }
                }
                split = posGuesses.size()/2 + posGuesses.get(0);
            }
            else if (check == -1) {
                for(int i = posGuesses.size() - 1; i >= 0; i--) {
                    if(posGuesses.get(i) > split) {
                        posGuesses.remove(i);
                    }
                }
                split = posGuesses.size()/2 + posGuesses.get(0);
            }
            else {
                done = true;
            }
        }
        int temp = split;
        split = 500;
        posGuesses = new ArrayList<Integer>();
        for(int i = 0; i < 1001; i++) {
            posGuesses.add(i);
        }
        return temp;
    }
}
