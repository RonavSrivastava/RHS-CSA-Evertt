public class Board {
    private static String board =   "-----------------" + "\n" + 
                                    "| | | | | | | | |" + "\n" + 
                                    "-----------------" + "\n" + 
                                    "| | | | | | | | |" + "\n" + 
                                    "-----------------" + "\n" + 
                                    "| | | | | | | | |" + "\n" + 
                                    "-----------------" + "\n" + 
                                    "| | | | | | | | |" + "\n" + 
                                    "-----------------" + "\n" + 
                                    "| | | | | | | | |" + "\n" + 
                                    "-----------------" + "\n" + 
                                    "| | | | | | | | |" + "\n" + 
                                    "-----------------" + "\n" + 
                                    "| | | | | | | | |" + "\n" + 
                                    "-----------------" + "\n";
    int[] boardArray = new int[64];

    public Board() {
        for(int i = 0; i < 64; i++) {
            boardArray[i] = 1;
        }
    }

    public void updateBoard(int x, int y) {
        /*
        1 = guessed & missed
        2 = guessed & hit
        3 = unguessed & ship location
        4 = unguessed & empty
        */
    }

    public void printBoard() {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                System.out.print(boardArray[i]);
            }
            System.out.println();
        }
    }
}
