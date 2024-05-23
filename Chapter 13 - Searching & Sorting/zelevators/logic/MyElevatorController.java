package logic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import game.ElevatorController;
import logic.OtherElevatorController;
import game.Game;
import game.Simulation;

public class MyElevatorController implements ElevatorController {
    // Private member data
    private Game game;
    // private int[] counts1;
    // private int[] counts2;
    private ArrayList<Integer> prevReqs;
    private ArrayList<Integer> curFloors;

    // Students should implement this function to return their name
    public String getStudentName() {
        return "potato"; // <-- TODO: Replace with your name
    }

    public int getStudentPeriod() {
        return 1; // <-- TODO: Replace with your class period
    }

    // Event: Game has started
    public void onGameStarted(Game game) {
        this.game = game;
        // counts1 = new int[game.getFloorCount()];
        // counts2 = new int[game.getFloorCount()];
    }

    // Event: "outside-the-elevator" request, requesting an elevator.
    // The event will be triggered with the request is created/enabled & when it is
    // cleared (reqEnable indicates which).
    public void onElevatorRequestChanged(int floorIdx, Direction dir, boolean reqEnable) {
        // System.out.println("onElevatorRequestChanged(" + floorIdx + ", " + dir + ", "
        // + reqEnable + ")");
        // if (reqEnable) {
        //     counts1[floorIdx]++;
        // } else {
        //     counts1[floorIdx]--;
        // }
    }

    // Event: "inside-the-elevator" request, requesting to go to a floor.
    // The event will be triggered with the request is created/enabled & when it is
    // cleared (reqEnable indicates which).
    public void onFloorRequestChanged(int elevatorIdx, int floorIdx, boolean reqEnable) {
        // System.out.println("onFloorRequesteChanged(" + elevatorIdx + ", " + floorIdx
        // + ", " + reqEnable + ")");
        // if (elevatorIdx == 0 && reqEnable) {
        //     counts2[floorIdx]++;
        // } else if (elevatorIdx == 0 && !reqEnable) {
        //     counts2[floorIdx]--;
        // }
    }

    // Event: Elevator has arrived at the floor & doors are open.
    public void onElevatorArrivedAtFloor(int elevatorIdx, int floorIdx, Direction travelDirection) {
        // System.out.println("onElevatorArrivedAtFloor(" + elevatorIdx + ", " +
        // floorIdx + ", " + travelDirection + ")");
        // game.setElevatorTravelDirection(elevatorIdx, Direction.None);
    }

    // Event: Called each frame of the simulation (i.e. called continuously)
    public void onUpdate(double deltaTime) {
        if (game == null) {
            return;
        }

        prevReqs = new ArrayList<Integer>();
        curFloors = new ArrayList<Integer>();
        // for (int el = 0; el < game.getElevatorCount(); el++) {
        // curFloors.add((int) game.getElevatorFloor(el));
        // }

        for (int el = 0; el < game.getElevatorCount(); el++) {
            if(game.getLevelTimeRemaining() > 120 - 5*el) {
                continue;
            }
            int max = 0;
            for (int i = 0; i < game.getFloorCount() && !prevReqs.contains(i) && !curFloors.contains(i); i++) {
                if ((game.hasElevatorRequestDown(i) || game.hasElevatorRequestUp(i)) && i != game.getElevatorFloor(el)
                        && game.isElevatorIdle(el)) {
                    max = i;
                }
            }

            int max2 = 0;
            for (int i = 0; i < game.getFloorCount() && !prevReqs.contains(i) && !curFloors.contains(i); i++) {
                if (game.elevatorHasFloorRequest(el, i) && i != game.getElevatorFloor(el) && game.isElevatorIdle(el)) {
                    max2 = i;
                }
            }

            int j = -1;
            for (int i = 0; i < game.getFloorCount() && !prevReqs.contains(i) && !curFloors.contains(i); i++) {
                // System.out.println(game.getElevatorFloor(0) + " curFloor");
                // - .... .. ... / .. ... / .-. --- -. .- ...- ... / -.-. --- -.. . / .-.. -- .- ---
                if (game.hasElevatorRequestDown(i) && (int) game.getElevatorFloor(el) > i) {
                    j = i > j ? i : j;
                } else if (game.hasElevatorRequestUp(i) && (int) game.getElevatorFloor(el) < i) {
                    j = i < j ? i : j;
                }
                if ((int) game.getElevatorFloor(el) < i && game.elevatorHasFloorRequest(el, i)) {
                    j = i > j ? i : j;
                } else if ((int) game.getElevatorFloor(el) > i && game.elevatorHasFloorRequest(el, i)) {
                    j = i < j ? i : j;
                }
            }

            if (game.getElevatorTravelDirection(el).equals(Direction.Down)) {
                for (int i = 0; i < game.getElevatorFloor(el) && !prevReqs.contains(i)
                        && !curFloors.contains(i); i++) {
                    if ((game.elevatorHasFloorRequest(el, i) || game.hasElevatorRequestDown(i)) && j < i) {
                        j = i;
                    }
                }
            } else {
                for (int i = game.getFloorCount() - 1; i > game.getElevatorFloor(el) && !prevReqs.contains(i)
                        && !curFloors.contains(i); i--) {
                    if ((game.elevatorHasFloorRequest(el, i) || game.hasElevatorRequestUp(i)) && j > i) {
                        j = i;
                    }
                }
            }

            if (j != -1) {
                // System.out.println(j + " j");
                if (!game.isElevatorIsHeadingToFloor(el, j) && game.isElevatorIdle(el)) {
                    // System.out.println("go to " + j);
                    curFloors.add((int) game.getElevatorFloor(el));
                    prevReqs.add(j);
                    // if (j > game.getElevatorFloor(el)) {
                    //     game.setElevatorTravelDirection(el, Direction.Up);
                    // } else {
                    //     game.setElevatorTravelDirection(el, Direction.Down);
                    // }
                    gotoFloor(el, j);
                }
            } else {
                // System.out.println(j + " j");
                // System.out.println(max2 + " max2");
                // System.out.println(max + " max");
                if (!game.isElevatorIsHeadingToFloor(el, max2) && game.isElevatorIdle(el)) {
                    // System.out.println("go to " + max2);
                    curFloors.add((int) game.getElevatorFloor(el));
                    prevReqs.add(max2);
                    // if (max2 > game.getElevatorFloor(el)) {
                    //     game.setElevatorTravelDirection(el, Direction.Up);
                    // } else {
                    //     game.setElevatorTravelDirection(el, Direction.Down);
                    // }
                    gotoFloor(el, max2);
                } else if (!game.isElevatorIsHeadingToFloor(el, max) && game.isElevatorIdle(el)) {
                    // System.out.println("go to " + max);
                    curFloors.add((int) game.getElevatorFloor(el));
                    prevReqs.add(max);
                    // if (max > game.getElevatorFloor(el)) {
                    //     game.setElevatorTravelDirection(el, Direction.Up);
                    // } else {
                    //     game.setElevatorTravelDirection(el, Direction.Down);
                    // }
                    gotoFloor(el, max);
                }

                // if (curFloors.size() > 0) {
                //     System.out.println(curFloors);
                // }
            }
        }
    }

    public boolean isAnElevatorAtFloor(int floorIdx) {
        for (int i = 0; i < game.getElevatorCount(); i++) {
            if ((int) game.getElevatorFloor(i) == floorIdx) {
                return true;
            }
        }
        return false;
    }
}