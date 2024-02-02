import java.util.Random;

public class AIPlayer extends Player {
    public AIPlayer(String m) {
        super(m);
    }

    public Move getNextMove(Board board) {
        Random random = new Random();
        String[] options = board.getEmptySpaces();
        String moveStr = null;
        while(moveStr == null) {
            moveStr = options[(int) (random.nextInt(9))];
        }
        System.out.println(moveStr);
        return Move.StringToMove(moveStr, mark);
    }
}
