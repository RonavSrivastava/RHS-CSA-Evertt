package logic;

import game.ElevatorController;
import game.Game;
import game.Simulation;

public class MyElevatorController implements ElevatorController {
    // Private member data
    private Game game;
    private int[] counts;

    // Students should implement this function to return their name
    public String getStudentName() {
        return "537K"; // <-- TODO: Replace with your name
    }

    public int getStudentPeriod() {
        return 1; // <-- TODO: Replace with your class period
    }

    // Event: Game has started
    public void onGameStarted(Game game) {
        this.game = game;
        counts = new int[game.getFloorCount()];
    }

    // Event: "outside-the-elevator" request, requesting an elevator.
    // The event will be triggered with the request is created/enabled & when it is
    // cleared (reqEnable indicates which).
    public void onElevatorRequestChanged(int floorIdx, Direction dir, boolean reqEnable) {
        System.out.println("onElevatorRequestChanged(" + floorIdx + ", " + dir + ", " + reqEnable + ")");
        if (reqEnable) {
            counts[floorIdx]++;
        } else {
            counts[floorIdx]--;
        }
    }

    // Event: "inside-the-elevator" request, requesting to go to a floor.
    // The event will be triggered with the request is created/enabled & when it is
    // cleared (reqEnable indicates which).
    public void onFloorRequestChanged(int elevatorIdx, int floorIdx, boolean reqEnable) {
        System.out.println("onFloorRequesteChanged(" + elevatorIdx + ", " + floorIdx + ", " + reqEnable + ")");
        if (elevatorIdx == 0 && reqEnable) {
            counts[floorIdx]++;
        } else if (elevatorIdx == 0 && !reqEnable) {
            counts[floorIdx]--;
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
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > max) {
                max = i;
            }
        }
        if (!game.isElevatorIsHeadingToFloor(0, max)) {
            gotoFloor(0, max);
        }
        // int j = 0;
        // int prevJ = Integer.MAX_VALUE;
        // for (int i = 0; i < game.getFloorCount(); i++) {
        // if (game.hasElevatorRequestDown(i) && game.getElevatorFloor(0) >= i &&
        // game.getElevatorTravelDirection(0).equals(Direction.Down)) {
        // j = i > j ? i : j;
        // } else if (game.hasElevatorRequestUp(i) && game.getElevatorFloor(0) <= i &&
        // game.getElevatorTravelDirection(0).equals(Direction.Up)) {
        // j = i < j ? i : j;
        // }
        // if (game.getElevatorFloor(0) <= i && game.elevatorHasFloorRequest(0, i) &&
        // game.getElevatorTravelDirection(0).equals(Direction.Up)) {
        // j = i > j ? i : j;
        // } else if (game.getElevatorFloor(0) >= i && game.elevatorHasFloorRequest(0,
        // i) && game.getElevatorTravelDirection(0).equals(Direction.Down)) {
        // j = i < j ? i : j;
        // }
        // }
        // if (j != 0) {
        // if(j < game.getElevatorFloor(0)) {
        // game.setElevatorTravelDirection(0, Direction.Down);
        // } else {
        // game.setElevatorTravelDirection(0, Direction.Up);
        // }
        // if (!game.isElevatorIsHeadingToFloor(0, j)) {
        // System.out.println("go to " + j);
        // gotoFloor(0, j);
        // }
        // } else {
        // if(j < game.getElevatorFloor(0)) {
        // game.setElevatorTravelDirection(0, Direction.Down);
        // } else {
        // game.setElevatorTravelDirection(0, Direction.Up);
        // }
        // for (int i = 0; i < game.getFloorCount(); i++) {
        // if ((game.hasElevatorRequestUp(i) || game.hasElevatorRequestDown(i))) {
        // j = Math.abs(j - i) < prevJ ? i : j;
        // }
        // }
        // if (!game.isElevatorIsHeadingToFloor(0, j)) {
        // System.out.println("go to " + j);
        // gotoFloor(0, j);
        // }
        // }
    }
}