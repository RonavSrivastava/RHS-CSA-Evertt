package ai;
 
import game.Simulation;
import game.Tank;
import game.TankAIBase;
import game.Target;
import game.Vec2;
 
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;
 
public class OtherAI extends TankAIBase {
 
    public String getPlayerName() {
        return "The_BigPotato2"; // <---- Put your first name here
    }
 
    public int getPlayerPeriod() {
        return 1;
    }
 
    public int timeSinceShot = 1;
    public boolean prevCmd = false;
 
    public boolean updateAI() {
        Random random = new Random();
        Vec2 pos = getTankPos();
        Dictionary<Integer, Double> dict = new Hashtable<>();
        for (int i = 0; i < getPowerUps().length; i++) {
            dict.put(i, Dist(getPowerUps()[i].getPos(), pos));
        }
        dict = bubSort(dict);
 
        if (getTankShotRange() < 14) {
            earlyGame();
        } else {
            if (!(tank.getPos().x < 12 && tank.getPos().x > 10 && tank.getPos().y < 7 &&
                    tank.getPos().y > 5)) {
                moveToPU(new Vec2(11, 6));
                System.out.println(tank.getPos());
            } else {
                lateGame();
            }
        }
 
        return true;
    }
 
    public void earlyGame() { // get powerups in early game, only shoot under certain conditions
        Vec2 pos = getTankPos();
        // Vec2 otherPos = getOther().getPos();
        Dictionary<Integer, Double> dict = new Hashtable<>();
        for (int i = 0; i < getPowerUps().length; i++) {
            dict.put(i, Dist(getPowerUps()[i].getPos(), pos));
        }
        dict = bubSort(dict);
        // double puDist = Dist(getPowerUps()[closestPU(dict)].getPos(), pos);
        // double otherpuDist = Dist(getPowerUps()[closestPU(dict)].getPos(), otherPos);
        Dictionary<Integer, Double> angs = new Hashtable<Integer, Double>() {
        };
        angs.put(0, getAng(getPowerUps()[closestPU(dict)].getPos(), pos));
        angs.put(1, getAng(getTargets()[0].getPos(), pos));
        angs.put(2, getAng(getTargets()[1].getPos(), pos));
        angs.put(3, getAng(getTargets()[2].getPos(), pos));
        angs.put(4, getTankAngle());
        angs = bubSort(angs);
 
        // for (int i = angs.size() - 1; i > 0; i--) {
        // if (!(angs.get(i) > getTankAngle() + 0.1
        // && angs.get(i) < getAng(getPowerUps()[closestPU(dict)].getPos(), pos) - 0.1))
        // {
        // angs.remove(i);
        // }
        // }
 
        // for (int i = angs.size() - 1; i > 0; i--) {
        // if (angs.get(i) > getAng(getTargets()[0].getPos(), pos) - 0.1
        // && angs.get(i) < getAng(getTargets()[0].getPos(), pos) + 0.1) {
        // queueCmd("shoot", getTargets()[0].getPos().subtract(pos));
        // }
        // }
 
        for (int i = 0; i < getTargets().length; i++) {
            if (Dist(getTargets()[i].getPos(), pos) < getTankShotRange()) {
                queueCmd("shoot", getTargets()[i].getPos().subtract(pos));
            }
        }
        // if (otherpuDist > puDist) {
        moveToPU(getPowerUps()[closestPU(dict)].getPos());
        // } else {
        // moveToPU(getPowerUps()[closestPU(dict)].getPos(), true);
        // }
    }
 
    public void lateGame() {
        Vec2 pos = getTankPos();
        // Vec2 otherPos = getOther().getPos();
        Dictionary<Integer, Double> dict2 = new Hashtable<>();
        for (int i = 0; i < getTargets().length; i++) {
            dict2.put(i, Dist(getTargets()[i].getPos(), pos));
        }
        dict2 = bubSort(dict2);
        // double tgtDist = Dist(getTargets()[closestTgt(dict2)].getPos(), pos);
        // double othertgtDist = Dist(getTargets()[closestTgt(dict2)].getPos(),
        // otherPos);
 
        queueCmd("shoot", getTargets()[closestTgt(dict2)].getPos().subtract(pos));
    }
 
    public void moveToPU(Vec2 coor) {
        Vec2 pos = getTankPos();
        Vec2 dir = getTankDir();
        double dX = coor.x - pos.x;
        double dY = coor.y - pos.y;
        if (-0.5 <= dY && dY <= 0.5) {
            dX = Math.min(10, dX);
            dX = Math.max(-10, dX);
            if (dX < 0) {
                queueCmd("move", new Vec2(dX + 0.5, 0));
            } else {
                queueCmd("move", new Vec2(dX - 0.5, 0));
            }
        } else if (-0.5 <= dX && dX <= 0.5) {
            dY = Math.min(10, dY);
            dY = Math.max(-10, dY);
            if (dY < 0) {
                queueCmd("move", new Vec2(0, dY + 0.5));
            } else {
                queueCmd("move", new Vec2(0, dY - 0.5));
            }
        } else if (dir.y <= 0.5 && dir.y >= -0.5) {
            dX = Math.min(10, dX);
            dX = Math.max(-10, dX);
            if (dX < 0) {
                queueCmd("move", new Vec2(dX + 0.5, 0));
            } else {
                queueCmd("move", new Vec2(dX - 0.5, 0));
            }
        } else {
            dY = Math.min(10, dY);
            dY = Math.max(-10, dY);
            if (dY < 0) {
                queueCmd("move", new Vec2(0, dY + 0.5));
            } else {
                queueCmd("move", new Vec2(0, dY - 0.5));
            }
        }
    }
 
    public void moveToPU(Vec2 coor, boolean isSmall) {
        Vec2 pos = getTankPos();
        Vec2 dir = getTankDir();
        if (isSmall) {
            double dX = coor.x - pos.x;
            double dY = coor.y - pos.y;
            if (-0.5 < dY && dY < 0.5) {
                dX = Math.min(5, dX);
                dX = Math.max(-5, dX);
                queueCmd("move", new Vec2(dX, 0));
            } else if (-0.5 < dX && dX < 0.5) {
                dY = Math.min(5, dY);
                dY = Math.max(-5, dY);
                queueCmd("move", new Vec2(0, dY));
            } else if (dir.y < 0.5 && dir.y > -0.5) {
                dX = Math.min(5, dX);
                dX = Math.max(-5, dX);
                queueCmd("move", new Vec2(dX, 0));
            } else {
                dY = Math.min(5, dY);
                dY = Math.max(-5, dY);
                queueCmd("move", new Vec2(0, dY));
            }
        } else {
            double dX = coor.x - pos.x;
            double dY = coor.y - pos.y;
            if (-0.5 < dY && dY < 0.5) {
                queueCmd("move", new Vec2(dX, 0));
            } else if (-0.5 < dX && dX < 0.5) {
                queueCmd("move", new Vec2(0, dY));
            } else if (dir.y < 0.5 && dir.y > -0.5) {
                queueCmd("move", new Vec2(dX, 0));
            } else {
                queueCmd("move", new Vec2(0, dY));
            }
        }
    }
 
    public int closestPU(Dictionary<Integer, Double> dict) {
        Vec2 pos = getTankPos();
        for (int i = 0; i < dict.size(); i++) {
            if (Math.abs(Dist(getPowerUps()[i].getPos(), pos) - dict.get(0)) < 0.1) {
                return i;
            }
        }
        return 0;
    }
 
    public Dictionary<Integer, Double> swap(Dictionary<Integer, Double> dict, int a, int b) {
        Double temp1 = dict.get(a);
        Double temp2 = dict.get(b);
        dict.remove(a);
        dict.remove(b);
        dict.put(b, temp1);
        dict.put(a, temp2);
        return dict;
    }
 
    public Dictionary<Integer, Double> bubSort(Dictionary<Integer, Double> dict) {
        int len = dict.size();
        for (int j = 0; j < len; j++) {
            boolean done = true;
            for (int i = 0; i < len - 1 - j; i++) {
                if (dict.get(i) > dict.get(i + 1)) {
                    swap(dict, i, i + 1);
                    done = false;
                }
            }
            if (done) {
                break;
            }
        }
        return dict;
    }
 
    public double Dist(Vec2 coor1, Vec2 coor2) {
        return Math.sqrt(Math.pow(coor1.x - coor2.x, 2) + Math.pow(coor1.y - coor2.y, 2));
    }
 
    public int closestTgt(Dictionary<Integer, Double> dict) {
        int prevMax = 0;
        for (int i = 1; i < dict.size(); i++) {
            if (Math.abs(getAng(tank.getPos(), getTargets()[i].getPos())) < Math
                    .abs(getAng(tank.getPos(), getTargets()[prevMax].getPos()))) {
                prevMax = i;
            }
        }
        System.out.println(prevMax);
        return prevMax;
    }
 
    public void moveTotgt(Target t) {
        double ang = Math.atan2(t.getPos().y - tank.getPos().y, t.getPos().x - tank.getPos().y);
        double dX = (Dist(t.getPos(), getTankPos()) - tank.getShotRange()) * Math.cos(ang);
        double dY = (Dist(t.getPos(), getTankPos()) - tank.getShotRange()) * Math.sin(ang);
        moveToPU(new Vec2(dX, dY), true);
    }
 
    public double getAng(Vec2 p1, Vec2 p2) {
        return Math.atan2(p2.y - p1.y, p2.x - p1.x);
    }
 
    public void moveToNoClamp(Vec2 coor) {
        Vec2 pos = getTankPos();
        Vec2 dir = getTankDir();
        double dX = coor.x - pos.x;
        double dY = coor.y - pos.y;
        if (-0.5 <= dY && dY <= 0.5) {
            if (dX < 0) {
                queueCmd("move", new Vec2(dX + 0.5, 0));
            } else {
                queueCmd("move", new Vec2(dX - 0.5, 0));
            }
        } else if (-0.5 <= dX && dX <= 0.5) {
            if (dY < 0) {
                queueCmd("move", new Vec2(0, dY + 0.5));
            } else {
                queueCmd("move", new Vec2(0, dY - 0.5));
            }
        } else if (dir.y <= 0.5 && dir.y >= -0.5) {
            if (dX < 0) {
                queueCmd("move", new Vec2(dX + 0.5, 0));
            } else {
                queueCmd("move", new Vec2(dX - 0.5, 0));
            }
        } else {
            if (dY < 0) {
                queueCmd("move", new Vec2(0, dY + 0.5));
            } else {
                queueCmd("move", new Vec2(0, dY - 0.5));
            }
        }
    }
}