package logic;

import java.util.ArrayList;

import game.ElevatorController;
import logic.MyElevatorController;
import game.Game;
import game.Simulation;

public class OtherElevatorController implements ElevatorController {
    // Private member data
    private Game game;
    // private int[] counts1;
    // private int[] counts2;
    // private ArrayList<Integer> prevReqs;
    // private ArrayList<Integer> curFloors;

    // Students should implement this function to return their name
    public String getStudentName() {
        return "potato"; // <-- TODO: Replace with your name
    }

    public int getStudentPeriod() {
        return 1; // <-- TODO: Replace with your class period
    }

    // Event: Game has started
    public void onGameStarted(Game game) {
        // this.game = game;
        // if (!Game.Create(new MyElevatorController(), new MyElevatorController())) {
        //     throw new Error("Could not create the game :(");
        // }
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

        // ElevatorController e = new MyElevatorController();
        // e.onGameStarted(game);
    }
}