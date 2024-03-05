package ai;
 
import game.Tank;
import game.TankAIBase;
import game.Vec2;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
 
public class OtherAI extends TankAIBase {
 
    // public String getPlayerName() {
    //     return "The_BigPotato2";  // <---- Put your first name here
    // }
    // public int getPlayerPeriod() {
    //     return 1;
    // }
 
    // public boolean updateAI() {
    //     Vec2 pos = getTankPos();
    //     Dictionary<Integer, Double> dict= new Hashtable<>();
    //     for(int i = 0; i < getPowerUps().length; i++) {
    //         dict.put(i, Dist(getPowerUps()[i].getPos(), pos));
    //     }
    //     dict = bubSort(dict);
    //     // System.out.println(dict);
 
    //     // earlyGame();
 
    //     return true;
    // }
 
    // public void earlyGame() { //get powerups in early game, only shoot under certain conditions
    //     Vec2 pos = getTankPos();
    //     Vec2 otherPos = getOther().getPos();
    //     Vec2 otherDir = getOther().forward();
    //     Vec2 otherVel = getOther().getVel();
    //     double otherDist = Dist(pos, otherPos);
    //     Dictionary<Integer, Double> dict= new Hashtable<>();
    //     for(int i = 0; i < getPowerUps().length; i++) {
    //         dict.put(i, Dist(getPowerUps()[i].getPos(), pos));
    //     }
    //     dict = bubSort(dict);
    //     double puDist = Dist(getPowerUps()[closestPU(dict)].getPos(), pos);
    //     double otherpuDist = Dist(getPowerUps()[closestPU(dict)].getPos(), otherPos);

    //     if (otherpuDist > puDist) {
    //         moveToPU(getPowerUps()[closestPU(dict)].getPos());
    //     }
    //     else {
    //         moveToPU(getPowerUps()[closestPU(dict)].getPos(), true);
    //     }
    // }

    // public void shootOtherMove() {
    //     //TODO - make a better shoot the other person when they are moving code
    // }

    // public void moveToPU(Vec2 coor) {
    //     Vec2 pos = getTankPos();
    //     Vec2 dir = getTankDir();
    //     double dX = coor.x - pos.x;
    //     double dY = coor.y - pos.y;
    //     if (-0.5 < dY && dY < 0.5) {
    //         dX = Math.min(10, dX);
    //         dX = Math.max(-10, dX);
    //         queueCmd("move", new Vec2(dX, 0));
    //     }
    //     else if (-0.5 < dX && dX < 0.5) {
    //         dY = Math.min(10, dY);
    //         dY = Math.max(-10, dY);
    //         queueCmd("move", new Vec2(0, dY));
    //     }
    //     else if (dir.y < 0.5 && dir.y > -0.5) {
    //         dX = Math.min(10, dX);
    //         dX = Math.max(-10, dX);
    //         queueCmd("move", new Vec2(dX, 0));
    //     }
    //     else {
    //         dY = Math.min(10, dY);
    //         dY = Math.max(-10, dY);
    //         queueCmd("move", new Vec2(0, dY));
    //     }
    // }
 
    // public void moveToPU(Vec2 coor, boolean isSmall) {
    //     Vec2 pos = getTankPos();
    //     Vec2 dir = getTankDir();
    //     if(isSmall) {
    //         double dX = coor.x - pos.x;
    //         double dY = coor.y - pos.y;
    //         if (-0.5 < dY && dY < 0.5) {
    //             dX = Math.min(5, dX);
    //             dX = Math.max(-5, dX);
    //             queueCmd("move", new Vec2(dX, 0));
    //         }
    //         else if (-0.5 < dX && dX < 0.5) {
    //             dY = Math.min(5, dY);
    //             dY = Math.max(-5, dY);
    //             queueCmd("move", new Vec2(0, dY));
    //         }
    //         else if (dir.y < 0.5 && dir.y > -0.5) {
    //             dX = Math.min(5, dX);
    //             dX = Math.max(-5, dX);
    //             queueCmd("move", new Vec2(dX, 0));
    //         }
    //         else {
    //             dY = Math.min(5, dY);
    //             dY = Math.max(-5, dY);
    //             queueCmd("move", new Vec2(0, dY));
    //         }
    //     }
    //     else {
    //         double dX = coor.x - pos.x;
    //         double dY = coor.y - pos.y;
    //         if (-0.5 < dY && dY < 0.5) {
    //             queueCmd("move", new Vec2(dX, 0));
    //         }
    //         else if (-0.5 < dX && dX < 0.5) {
    //             queueCmd("move", new Vec2(0, dY));
    //         }
    //         else if (dir.y < 0.5 && dir.y > -0.5) {
    //             queueCmd("move", new Vec2(dX, 0));
    //         }
    //         else {
    //             queueCmd("move", new Vec2(0, dY));
    //         }
    //     }
    // }
 
    // public int closestPU(Dictionary<Integer, Double> dict) {
    //     Vec2 pos = getTankPos();
    //     for(int i = 0; i < dict.size(); i++) {
    //         if (Math.abs(Dist(getPowerUps()[i].getPos(), pos) - dict.get(0)) < 0.1) {
    //             return i;
    //         }
    //     }
    //     return 0;
    // }
 
    // public Dictionary<Integer, Double> swap(Dictionary<Integer, Double> dict, int a, int b) {
    //     Double temp1 = dict.get(a);
    //     Double temp2 = dict.get(b);
    //     dict.remove(a);
    //     dict.remove(b);
    //     dict.put(b, temp1);
    //     dict.put(a, temp2);
    //     return dict;
    // }
 
    // public Dictionary<Integer, Double> bubSort(Dictionary<Integer, Double> dict) {
    //     int len = dict.size();
    //     int n = 0;
    //     for(int j = 0; j < len; j++) {
    //         boolean done = true;
    //         for(int i = 0; i < len-1-n; i++) {
    //             if(dict.get(i) > dict.get(i+1)) {
    //                 swap(dict, i, i+1);
    //                 done = false;
    //             }
    //         }
    //         if(done) {
    //             break;
    //         }
    //         n++;
    //     }
    //     return dict;
    // }
 
    // public double Dist(Vec2 coor1, Vec2 coor2) {
    //     return Math.sqrt(Math.pow(coor1.x - coor2.x, 2) + Math.pow(coor1.y - coor2.y, 2));
    // }
}