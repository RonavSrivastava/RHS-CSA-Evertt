public class Board {
    private String[][] board = new String[3][3];

    public Board() {
        for(String[] arr : board) {
            for(int i = 0; i < arr.length; i++) {
                arr[i] = " ";
            }
        }
    }

    public String draw() {
        return " " + board[0][2] + " | " + board[1][2] + " | " + board[2][2] + " \n-----------\n" + " " + board[0][1] + " | " + board[1][1] + " | " + board[2][1] + " \n-----------\n" + " " + board[0][0] + " | " + board[1][0] + " | " + board[2][0] + "\n";
    }

    public void placeMark(Move m) {
        board[m.r][m.c] = m.mark;
    }

    public int calcWinner() {
        return 0;
    }

    public String[] getEmptySpaces() {
        String[] output = {null, null, null, null, null, null, null, null, null};
        int arrNum = 0;
        for(String[] arr : board) {
            for(int i = 0; i < arr.length; i++) {
                if(arr[i].equals(" ")) {
                    output[arrNum*3 + i] = "" + arrNum + "," + i%3;
                }
            }
            arrNum++;
        }
        return output;
    }
}