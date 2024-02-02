import java.util.Scanner;

public class HumanPlayer extends Player{
    public HumanPlayer(String m) {
        super(m);
    }

    public Move getNextMove(Board board) {
        Scanner scan = new Scanner(System.in);
        String[] options = board.getEmptySpaces();
        String moveStr = null;
        while(moveStr == null) {
            System.out.print("Your move: ");
            moveStr = scan.next();
            for(String i : options) {
                if (i != null && i.equals(moveStr)) {
                    scan.close();
                    return Move.StringToMove(moveStr, mark);
                }
            }
            System.out.println("Not a valid move, try again");
            moveStr = null;
        }
        scan.close();
        return null;
    }
}
