package logic;

import game.ElevatorController;
import game.Game;

// *********************************************************************************
//  This is the code for SECOND PLAYER (your code goes in MyElevatorController.java)
// *********************************************************************************

public class OtherElevatorController implements ElevatorController {

    // Private member data
    private Game game;
    private int[] counts1;
    private int[] counts2;

    // Students should implement this function to return their name
    public String getStudentName() {
        return "potato2"; // <-- TODO: Replace with your name
    }

    public int getStudentPeriod() {
        return 1; // <-- TODO: Replace with your class period
    }

    // Event: Game has started
    public void onGameStarted(Game game) {
        this.game = game;
        counts1 = new int[game.getFloorCount()];
        counts2 = new int[game.getFloorCount()];
    }

    // Event: "outside-the-elevator" request, requesting an elevator.
    // The event will be triggered with the request is created/enabled & when it is
    // cleared (reqEnable indicates which).
    public void onElevatorRequestChanged(int floorIdx, Direction dir, boolean reqEnable) {
        System.out.println("onElevatorRequestChanged(" + floorIdx + ", " + dir + ", " + reqEnable + ")");
        if (reqEnable) {
            counts1[floorIdx]++;
        } else {
            counts1[floorIdx]--;
        }
    }

    // Event: "inside-the-elevator" request, requesting to go to a floor.
    // The event will be triggered with the request is created/enabled & when it is
    // cleared (reqEnable indicates which).
    public void onFloorRequestChanged(int elevatorIdx, int floorIdx, boolean reqEnable) {
        System.out.println("onFloorRequesteChanged(" + elevatorIdx + ", " + floorIdx + ", " + reqEnable + ")");
        if (elevatorIdx == 1 && reqEnable) {
            counts2[floorIdx]++;
        } else if (elevatorIdx == 1 && !reqEnable) {
            counts2[floorIdx]--;
        }
    }

    // Event: Elevator has arrived at the floor & doors are open.
    public void onElevatorArrivedAtFloor(int elevatorIdx, int floorIdx, Direction travelDirection) {
        System.out.println("onElevatorArrivedAtFloor(" + elevatorIdx + ", " + floorIdx + ", " + travelDirection + ")");

    }

    // Event: Called each frame of the simulation (i.e. called continuously)
    public void onUpdate(double deltaTime) {
        if (game == null) {
            return;
        }

        int max = 0;
        for (int i = 0; i < counts1.length; i++) {
            if (counts1[i] > max && i != game.getElevatorFloor(1) && game.isElevatorIdle(1)) {
                max = i;
            }
        }

        int max2 = 0;
        for (int i = 0; i < counts2.length; i++) {
            if (counts2[i] > max && i != game.getElevatorFloor(1) && game.isElevatorIdle(1)) {
                max2 = i;
            }
        }
        // if (!game.isElevatorIsHeadingToFloor(0, max)) {
        // gotoFloor(0, max);
        // }

        int j = -1;
        int prevJ = Integer.MAX_VALUE;
        for (int i = 0; i < game.getFloorCount(); i++) {
            // System.out.println(game.getElevatorFloor(1) + " curFloor");
            if (game.hasElevatorRequestDown(i) && (int) game.getElevatorFloor(1) >= i
                    && i != (int) game.getElevatorFloor(1)) {
                j = i > j ? i : j;
            } else if (game.hasElevatorRequestUp(i) && (int) game.getElevatorFloor(1) <= i
                    && i != (int) game.getElevatorFloor(1)) {
                j = i < j ? i : j;
            }
            if ((int) game.getElevatorFloor(1) <= i && game.elevatorHasFloorRequest(1, i)
                    && i != (int) game.getElevatorFloor(1)) {
                j = i > j ? i : j;
            } else if ((int) game.getElevatorFloor(1) >= i && game.elevatorHasFloorRequest(1, i)
                    && i != (int) game.getElevatorFloor(1)) {
                j = i < j ? i : j;
            }
        }
        if (j != -1) {
            // System.out.println(j + " j");
            if (!game.isElevatorIsHeadingToFloor(1, j)) {
                System.out.println("go to " + j);
                gotoFloor(1, j);
            }
        } else {
            // System.out.println(j + " j");
            // System.out.println(max2 + " max2");
            // System.out.println(max + " max");
            if (!game.isElevatorIsHeadingToFloor(1, max) && game.isElevatorIdle(1)) {
                System.out.println("go to " + max);
                gotoFloor(1, max);
            } else if (!game.isElevatorIsHeadingToFloor(1, max2) && game.isElevatorIdle(1)) {
                System.out.println("go to " + max2);
                gotoFloor(1, max2);
            }
            // if (j < game.getElevatorFloor(1)) {
            // game.setElevatorTravelDirection(1, Direction.Down);
            // } else {
            // game.setElevatorTravelDirection(1, Direction.Up);
            // }
            // for (int i = 0; i < game.getFloorCount(); i++) {
            // if ((game.hasElevatorRequestUp(i) || game.hasElevatorRequestDown(i))) {
            // j = Math.abs(j - i) < prevJ ? i : j;
            // }
            // }
            // if (!game.isElevatorIsHeadingToFloor(1, j)) {
            // System.out.println("go to " + j);
            // gotoFloor(1, j);
            // }
        }
    }
}