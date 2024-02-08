/* The Board stores the state of the Tic-Tac-Toe board */
public class Board {
    public static final String empty = " ";

    // 3x3 array of single character Strings. This stores the current
    //  state of the board. After construction, it is guarenteed to
    //  contain nine String elements. 
    // Each element stores one of the following...
    //    Board.empty, HumanPlayer.marker, or AiPlayer.marker
    private String[][] board; 

    public Board() {
        board = new String[3][3];
        reset();
    }

    //copies another board, used for AI test cases
    public Board(Board b) {
        String[][] output = new String[b.getBoard().length][b.getBoard()[0].length];
        for(int arr = 0; arr < b.getBoard().length; arr++) {
            for(int i = 0; i < b.getBoard()[arr].length; i++) {
                output[arr][i] = b.getBoard()[arr][i];
            }
        }
        board = output;
    }

    //accessor to the board array, used for AI
    public String[][] getBoard() {
        return board;
    }

    // Reset board so that each element is a an empty string (use Board.empty)
    //  postcondition: board is a 3x3 array. all elements are Board.empty.
    public void reset() {
        for(String[] arr : board) {
            for(int i = 0; i < arr.length; i++) {
                arr[i] = Board.empty;
            }
        }
    }

    // Returns the number of rows in the board
    public int rows() {
        int r = 0;
        for(String arr[] : board) {
            r++;
        }
        return r;
    }

    // Returns the number of columns in the board
    public int columns() {
        int c = 0;
        for(String arr[] : board) {
            for(String s : arr) {
                c++;
            }
            break;
        }
        return c;
    }

    // Returns true if the specified row/column space is empty 
    //  (does not already store an X or O)
    //  You can assume r & c are valid values.
    public boolean isEmpty(int r, int c) {
        return board[r][c].equals(Board.empty);
    }

    // Returns the String marker at the specified row/column (e.g. "X")
    //  You can assume r & c are valid values.
    public String getMarkerAt(int r, int c) {
        return board[r][c];
    }

    // Creates and returns a String that can be printed display the board.
    //  Example return value: " X |   | O \n-----------\n O | X |   \n-----------\n   |   | O "
    public String renderToString() {
        return " " + board[0][2] + " | " + board[1][2] + " | " + board[2][2] + " \n-----------\n" + " " + board[0][1] + " | " + board[1][1] + " | " + board[2][1] + " \n-----------\n" + " " + board[0][0] + " | " + board[1][0] + " | " + board[2][0] + "\n";
    }

    // Returns the number of empty spaces on the board. 
    //  An empty board (at the start of the game) would return 9.
    //  After both players have places one mark, it would return 7.
    public int numberEmpty() {
        int output = 0;
        for(String[] arr : board) {
            for(String i : arr) {
                if(i.equals(" ")) {
                    output++;
                }
            }
        }
        return output;
    }

    // Update the board with the specified move applied.
    //  You can assume it is a valid move.
    public void placeMark(Move m) {
        board[m.r][m.c] = m.mark;
    }

    // Determines if there is a winner, based on the current board state.
    //  Note that in the case that no one has won, it returns 0.
    //  Returns: 0:none, 1:human(HumanPlayer.marker), 2:AI(AiPlayer.marker)
    public int calcWinner() {
        return calcWinner(board);
    }


    //used for AI's testing
    public static int calcWinner(String[][] board) {
        for(int i = 0; i < board.length; i++) {
            if(board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]) && !board[0][i].equals(Board.empty)) {
                return board[0][i].equals(HumanPlayer.marker) ? 1 : 2;
            }
        }
        for(int i = 0; i < board[0].length; i++) {
            if(board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]) && !board[i][0].equals(Board.empty)) {
                return board[i][0].equals(HumanPlayer.marker) ? 1 : 2;
            }
        }
        if(board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && !board[0][0].equals(Board.empty)) {
            return board[0][0].equals(HumanPlayer.marker) ? 1 : 2;
        }
        if(board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[1][1].equals(Board.empty)) {
            return board[1][1].equals(HumanPlayer.marker) ? 1 : 2;
        }
        return 0;
    }
}
