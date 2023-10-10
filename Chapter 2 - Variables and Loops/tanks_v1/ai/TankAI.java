package ai;

import game.Tank;
import game.TankAIBase;
import game.Vec2;

public class TankAI extends TankAIBase {

    public String getPlayerName() {
        return "Potato";  // <---- Put your first name here
    }
        
    // You are free to add member variables & methods to this class (and delete this comment).
    //  You should use the function in its base class (TankAIBase) to query the world. 
    //  Note that you are not allowed to reach into game code directly or make any
    //  modifications to coded in the game package. Use your judgement and ask your 
    //  teacher if you are not sure. If it feels like cheating, it probably is.

    public boolean updateAI() {
        // TODO: Your code goes here
        Vec2 pos = getTankPos();
        Vec2 dir = getTankDir();
        double ang = getTankAngle();
	    double speed = getTankMoveSpeed();
	    double turnSpeed = getTankTurnSpeed();
	    double shotRange = getTankShotRange();
        double shotSpeed = getTankShotSpeed();
        double lvlTimeLeft = getLevelTimeRemaining();
        double lvlTimeMax = getLevelTimeMax();

        

        return true;
    }
}