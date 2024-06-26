package logic;
 
import java.time.format.SignStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import game.ElevatorController;
import game.Game;
 
public class OtherElevatorController implements ElevatorController {
 
    // Private member data
    private Game game;
 
    private double time = 0;
 
    // Students should implement this function to return their name
    public String getStudentName() {
        return "Dhruv";
    }
 
    public int getStudentPeriod() {
        return 1;
    }
 
    // Event: Game has started
    public void onGameStarted(Game game) {
        this.game = game;
    }
 
    // rrquest class to keep track of outside the elevator requests
    class Request {
 
        //floor jumbers
        private final int floor;
        //timestamp of request
        private final long timestamp;
        //request direction
        private final Direction dir;
 
        public Request(int floor, long timestamp, Direction dir) {
            this.floor = floor;
            this.timestamp = timestamp;
            this.dir = dir;
        }
 
        public int getFloor() {
            return this.floor;
        }
 
        public long getTimeStamp() {
            return this.timestamp;
        }
 
        public Direction getDir() {
            return this.dir;
        }
 
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Request) {
                Request other = (Request) obj;
                return other.getDir() == getDir() && other.getTimeStamp() == getTimeStamp()
&& other.getFloor() == getFloor();
            }
            return false;
        }
 
    }
 
    class AutonomousElevator {
 
        //index of elevator
        private final int selfIdx;
        //minimum floor its covering
        private int minFloor;
        // max floor its covering
        private int maxFloor;
 
        // current requests
        private final List<Request> requests = new ArrayList<>();
        //current floors were going to
        private final List<Integer> floorQueue = new ArrayList<>();
 
        //keeping track of whether were picking up or dropping off
        boolean fulfillingRequest = false;
 
        public AutonomousElevator(int selfIdx, int minFloor, int maxFloor) {
            this.selfIdx = selfIdx;
            this.minFloor = minFloor;
            this.maxFloor = maxFloor;
        }
 
        private int getElevatorFloor() {
            return (int) game.getElevatorFloor(selfIdx);
        }
 
        private boolean isIdle() {
            return game.isElevatorIdle(selfIdx);
        }
 
        //checking if an wlevator has a request
        public boolean hasRequest(int floor) {
            return requests.stream().anyMatch(request -> request.getFloor() == floor);
        }
 
        //checking if one of the elevators has a request
        public boolean someoneHasRequest(int floor) {
            for (AutonomousElevator elevator : elevators) {
                if (elevator.hasRequest(floor))
                    return true;
            }
            return false;
        }
 
        //removimg request from an elevator
        public void removeRequest(int floor) {
            requests.removeIf(request -> request.getFloor() == floor);
        }
 
        // removing request from all the registered elevators
        public void removeRequestFromOthers(int floor) {
            for (AutonomousElevator elevator : elevators) {
                if (elevator.hasRequest(floor)) {
                    elevator.removeRequest(floor);
                }
            }
        }
 
        public boolean isGoingToFloor(int floor) {
            return floorQueue.contains(floor);
        }
 
        //method to handle a request - only run if zombie is not in elevator 
        private void fulfillRequest(Request request) {
            if (getElevatorFloor() != request.getFloor())
                gotoFloor(selfIdx, request.getFloor());
            requests.remove(request);
            fulfillingRequest = true;
        }
 
        //choosing first request to fulfill based on timestamp 
        private void evaluatePosition() {
            Request closest = null;
            for (Request request : requests) {
                if (closest == null) {
                    closest = request;
                } else {
                    if (request.getTimeStamp() < closest.getTimeStamp()) {
                        closest = request;
                    }
                }
            }
            if (closest != null)
                fulfillRequest(closest);
        }
 
        // elevator call event
        public void onElevatorCall(int floorIdx, Direction dir) {
            requests.add(new Request(floorIdx, System.currentTimeMillis(), dir));
        }
 
        // adding floor to queue - if ready to go then go to floor
        public void onFloorSelect(int floorIdx) {
            if (isIdle()) {
                floorQueue.add(floorIdx);
                gotoFloor(selfIdx, floorIdx);
            } else {
                floorQueue.add(floorIdx);
            }
            removeRequestFromOthers(floorIdx);
        }
 
        //elevator arrive event choosing what action to take
        public void onElevatorArrive() {
            if (fulfillingRequest) {
                fulfillingRequest = false;
            } else {
                if (floorQueue.size() > 1) {
                    for (int i = 0; i < floorQueue.size(); i++) {
                        if (floorQueue.get(i) == getElevatorFloor()) {
                            floorQueue.remove(i);
                            break;
                        }
                    }
                    List<Integer> floors = new ArrayList<>();
                    for (Integer integer : floorQueue) {
                        if (someoneHasRequest(integer)) {
                            if (!floors.contains(integer))
                                floors.add(integer);
                        }
                    }
                    boolean didFindFloor = floors.size() > 0;
                    if (floors.size() <= 0)
                        floors = floorQueue;
                    int minFloor = -1;
                    for (Integer integer : floors) {
                        if (minFloor == -1
                                || Math.abs(getElevatorFloor() - integer) < Math.abs(getElevatorFloor() - minFloor)) {
                            minFloor = integer;
                        }
                    }
                    if (isIdle()) {
                        if (didFindFloor)
                            removeRequestFromOthers(minFloor);
                        gotoFloor(selfIdx, minFloor);
                    }
 
                } else if (floorQueue.size() == 1) {
                    for (int i = 0; i < floorQueue.size(); i++) {
                        if (floorQueue.get(i) == getElevatorFloor()) {
                            floorQueue.remove(i);
                            break;
                        }
                    }
                    if (isIdle())
                        evaluatePosition();
                }
            }
        }
 
        //idle function - basically wame as elevator arrive
        public void onIdle() {
            if (!fulfillingRequest && floorQueue.size() <= 0) {
                evaluatePosition();
            } else if (floorQueue.size() > 0) {
                List<Integer> floors = new ArrayList<>();
                for (Integer integer : floorQueue) {
                    if (someoneHasRequest(integer)) {
                        if (!floors.contains(integer))
                            floors.add(integer);
                    }
                }
                boolean didFindFloor = floors.size() > 0;
                if (floors.size() <= 0)
                    floors = floorQueue;
                int minFloor = -1;
                for (Integer integer : floors) {
                    if (minFloor == -1
                            || Math.abs(getElevatorFloor() - integer) < Math.abs(getElevatorFloor() - minFloor)) {
                        minFloor = integer;
                    }
                }
                if (minFloor != -1)
                    if (didFindFloor)
                        removeRequestFromOthers(minFloor);
                gotoFloor(selfIdx, minFloor);
            }
        }
 
        //need to depcreate this but i couldnt figure out the hesder in VS code
        public void initalize() {
            evaluatePosition();
        }
 
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof AutonomousElevator) {
                AutonomousElevator other = (AutonomousElevator) obj;
                return selfIdx == other.selfIdx;
            }
            return false;
        }
 
        public int getRequestCount() {
            return requests.size();
        }
 
    }
 
    //list of registered elevators
    List<AutonomousElevator> elevators = new ArrayList<>();
 
    // Event: "outside-the-elevator" request, requesting an elevator.
    // The event will be triggered with the request is created/enabled & when it is
    // cleared (reqEnable indicates which).
 
    // distributing requests to the elevators, making sure its spread out so one elevator isnt carrying
    public synchronized void onElevatorRequestChanged(int floorIdx, Direction dir, boolean reqEnable) {
        if (elevators.stream().anyMatch(elevator -> elevator.hasRequest(floorIdx)
                || elevator.isGoingToFloor(floorIdx)))
            return;
        if (reqEnable) {
            AutonomousElevator min = null;
            for (AutonomousElevator elevator : elevators) {
                if (floorIdx >= elevator.minFloor && floorIdx <= elevator.maxFloor) { // imma change this to
                                                                                      // redistribute it to the least
                                                                                      // requests TODO
                    if (min == null || elevator.getRequestCount() < min.getRequestCount()) {
                        min = elevator;
                    }
                }
            }
            min.onElevatorCall(floorIdx, dir);
        }
    }
 
    // Event: "inside-the-elevator" request, requesting to go to a floor.
    // The event will be triggered with the request is created/enabled & when it is
    // cleared (reqEnable indicates which).
    //handling elevator floor selection and sending the info packet to the AutonomisElevator
    public synchronized void onFloorRequestChanged(int elevatorIdx, int floorIdx, boolean reqEnable) {
        if (reqEnable) {
            for (AutonomousElevator elevator : elevators) {
                if (elevatorIdx == elevator.selfIdx) {
                    elevator.onFloorSelect(floorIdx);
                    return;
                }
            }
        }
    }
 
    // Event: Elevator has arrived at the floor & doors are open.
    // feeding event to autonomus elevator
    public synchronized void onElevatorArrivedAtFloor(int elevatorIdx, int floorIdx, Direction travelDirection) {
        for (AutonomousElevator elevator : elevators) {
            if (elevatorIdx == elevator.selfIdx) {
                elevator.onElevatorArrive();
                return;
            }
        }
    }
 
    // Event: Called each frame of the simulation (i.e. called continuously)
 
    // feeding onIdle event and registering elevators 
    public synchronized void onUpdate(double deltaTime) {
        if (game == null) {
            return;
        }
        time += deltaTime;
        if (!game.hasGameHadFirstUpdate()) {
            int elevatorCount = game.getElevatorCount();
            int floorCount = game.getFloorCount();
            for (int i = 0; i < elevatorCount; i++) {
                AutonomousElevator elevator = new AutonomousElevator(i, 0, floorCount - 1);
                elevators.add(elevator);
            }
        }
        for (AutonomousElevator elevator : elevators) {
            if (game.isElevatorIdle(elevator.selfIdx)) {
                elevator.onIdle();
            }
        }
    }
}