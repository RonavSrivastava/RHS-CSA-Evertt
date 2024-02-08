public class AiPlayer extends Player {
    public static final String marker = "O";

    // old random code
    // public Move getNextMove(Board board) {
    //     int numEmpty = board.numberEmpty();
    //     int offset = (int)(Math.random() * numEmpty);
    //     for (int r = 0; r < board.rows(); ++r) {
    //         for (int c = 0; c < board.columns(); ++c) {
    //             if (board.isEmpty(r, c)) {
    //                 if (offset == 0) {
    //                     return new Move(r, c, marker);
    //                 }
    //                 --offset;
    //             }
    //         }
    //     }
    //     return null;
    // }

    public Move getNextMove(Board board) {
        //if i am one from winning, win
        int arrNum = 0;
        for(String[] arr : board.getBoard()) {
            for(int i = 0; i < arr.length; i++) {
                //test each spot to see if AI would win
                Board testBoard = new Board(board);
                testBoard.placeMark(new Move(arrNum, i, AiPlayer.marker));
                if(testBoard.calcWinner() == 2 && board.isEmpty(arrNum, i)) {
                    //AI would win, so take it
                    return new Move(arrNum, i, AiPlayer.marker);
                }
            }
            arrNum++;
        }

        //if they are one move from winning, stop them
        arrNum = 0;
        for(String[] arr : board.getBoard()) {
            for(int i = 0; i < arr.length; i++) {
                //test each spot to see if human would win
                Board testBoard = new Board(board);
                testBoard.placeMark(new Move(arrNum, i, HumanPlayer.marker));
                if(testBoard.calcWinner() == 1 && board.isEmpty(arrNum, i)) {
                    //they would win, block them
                    return new Move(arrNum, i, AiPlayer.marker);
                }
            }
            arrNum++;
        }

        //prioritize the center
        if(board.isEmpty(1, 1)) {
            return new Move(1, 1, marker);
        }


        //dumb case where the board is like 
        //X |   |   
        //  | O |   
        //  |   | X 
        //and the AI goes bottom left so human can go top right and win
        if((board.getBoard()[2][0].equals(board.getBoard()[0][2]) && board.getBoard()[2][0].equals(HumanPlayer.marker)) || (board.getBoard()[0][0].equals(board.getBoard()[2][2]) && board.getBoard()[0][0].equals(HumanPlayer.marker)) && board.isEmpty(1, 0)) {
            return new Move(1, 0, marker);
        }

        //then a corner
        if(board.isEmpty(0, 0)) {
            return new Move(0, 0, marker);
        }
        if(board.isEmpty(2, 0)) {
            return new Move(2, 0, marker);
        }
        if(board.isEmpty(0, 2)) {
            return new Move(0, 2, marker);
        }
        if(board.isEmpty(2, 2)) {
            return new Move(2, 2, marker);
        }


        //eh doesnt matter just do a random one
        int numEmpty = board.numberEmpty();
        int offset = (int)(Math.random() * numEmpty);
        for (int r = 0; r < board.rows(); ++r) {
            for (int c = 0; c < board.columns(); ++c) {
                if (board.isEmpty(r, c)) {
                    if (offset == 0) {
                        return new Move(r, c, marker);
                    }
                    --offset;
                }
            }
        }
        return null;
    }
}