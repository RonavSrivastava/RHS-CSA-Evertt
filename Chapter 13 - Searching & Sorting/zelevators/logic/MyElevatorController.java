package logic;

import game.ElevatorController;
import game.Game;
import game.Simulation;

public class MyElevatorController implements ElevatorController {
    // Private member data
    private Game game;

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
    }

    // Event: "outside-the-elevator" request, requesting an elevator.
    // The event will be triggered with the request is created/enabled & when it is
    // cleared (reqEnable indicates which).
    public void onElevatorRequestChanged(int floorIdx, Direction dir, boolean reqEnable) {
        System.out.println("onElevatorRequestChanged(" + floorIdx + ", " + dir + ", " + reqEnable + ")");
    }

    // Event: "inside-the-elevator" request, requesting to go to a floor.
    // The event will be triggered with the request is created/enabled & when it is
    // cleared (reqEnable indicates which).
    public void onFloorRequestChanged(int elevatorIdx, int floorIdx, boolean reqEnable) {
        System.out.println("onFloorRequesteChanged(" + elevatorIdx + ", " + floorIdx + ", " + reqEnable + ")");

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
        if (game.isElevatorIdle(0)) {
            for (int i = 0; i < game.getFloorCount(); i++) {
                if (game.hasElevatorRequestDown(i) && game.getElevatorFloor(0) > i) {
                    gotoFloor(0, i);
                } else if (game.hasElevatorRequestUp(i) && game.getElevatorFloor(0) < i) {
                    gotoFloor(0, i);
                }
            }
            if (game.isElevatorIdle(0)) {
                for (int i = 0; i < game.getFloorCount(); i++) {
                    if (game.elevatorHasFloorRequest(0, i)) {
                        gotoFloor(0, i);
                    }
                }
            }
        }
    }
}