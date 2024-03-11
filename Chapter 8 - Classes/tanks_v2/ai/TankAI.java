package ai;
 
import java.util.ArrayList;
 
import game.PowerUp;
import game.Tank;
import game.TankAIBase;
import game.Target;
import game.Vec2;
 
public class TankAI extends TankAIBase {
   
    public String getPlayerName() {
        return "Aarav";  // <---- Put your first name here
    }
    public int getPlayerPeriod() {
        return 1;                // <---- Put your period here
    }
       
    // You are free to add member variables & methods to this class (and delete this comment).
    //  You should use the methods in its base class (TankAIBase) to query the world.
    //  Note that you are not allowed to reach into game code directly or make any
    //  modifications to code in the game package. Use your judgement and ask your
    //  teacher if you are not sure. If it feels like cheating, it probably is.
 
    public boolean updateAI() {
        PowerUp powerUps[] = getPowerUps();
        Tank tank = this.getTank();
        Target targets[] = getTargets();
 
 
        for(int i = 0; i < targets.length; i++) {
            if(getTankShotRange() >= targetDistance(tank, targets[i])) {
                if(Math.atan((double)(Math.abs((targets[i].getPos().x - tank.getPos().x))/Math.abs((targets[i].getPos().y - tank.getPos().y)))) <= (double)(Math.PI/2))
                queueCmd("shoot", new Vec2((targets[i].getPos().x - tank.getPos().x), (targets[i].getPos().y - tank.getPos().y)));
            }
        }
 
 
        double temp = pUpDistance(tank, powerUps[0]);
        ArrayList<Vec2> pU = new ArrayList<Vec2>();
        for(int i = 1; i < powerUps.length; i++) {
            if(pUpDistance(tank, powerUps[i]) < temp) {
                temp = pUpDistance(tank, powerUps[i]);
                pU.add(0, powerUps[i].getPos());
            }
            else {
                pU.add(powerUps[0].getPos());
            }
        }
       
            if(tank.getPos().x < pU.get(0).x) {
                queueCmd("move", new Vec2(1, 0));
            }
            else if(tank.getPos().x > pU.get(0).x) {
                queueCmd("move", new Vec2(-1, 0));
            }
            else if(tank.getPos().y < pU.get(0).y) {
                queueCmd("move", new Vec2(0, 1));
            }
            else if(tank.getPos().y > pU.get(0).y) {
                queueCmd("move", new Vec2(0, -1));
            }
       
        return true;
    }
 
    public double targetDistance(Tank tank, Target target) {
        return Math.sqrt((tank.getPos().x - target.getPos().x)*(tank.getPos().x - target.getPos().x) + (tank.getPos().y - target.getPos().y)*(tank.getPos().y - target.getPos().y));
    }
 
    public double pUpDistance(Tank tank, PowerUp pUp) {
        return Math.sqrt((tank.getPos().x - pUp.getPos().x)*(tank.getPos().x - pUp.getPos().x) + (tank.getPos().y - pUp.getPos().y)*(tank.getPos().y - pUp.getPos().y));
    }
 
 
}