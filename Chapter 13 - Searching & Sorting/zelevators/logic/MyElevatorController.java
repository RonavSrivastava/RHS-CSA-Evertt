package logic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;

import game.ElevatorController;
import game.Game;

// *********************************************************************************
//  This is the code for SECOND PLAYER (your code goes in MyElevatorController.java)
// *********************************************************************************

public class MyElevatorController implements ElevatorController {

    // Private member data
    private Game game;
    // private int[] counts1;
    // private int[] counts2;
    private ArrayList<Integer> prevReqs;
    private ArrayList<Integer> curFloors;
    private boolean first = true;

    // Students should implement this function to return their name
    public String getStudentName() {
        return "potato1"; // <-- TODO: Replace with your name
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
        // counts1[floorIdx]++;
        // } else {
        // counts1[floorIdx]--;
        // }
    }

    // Event: "inside-the-elevator" request, requesting to go to a floor.
    // The event will be triggered with the request is created/enabled & when it is
    // cleared (reqEnable indicates which).
    public void onFloorRequestChanged(int elevatorIdx, int floorIdx, boolean reqEnable) {
        // System.out.println("onFloorRequesteChanged(" + elevatorIdx + ", " + floorIdx
        // + ", " + reqEnable + ")");
        // if (elevatorIdx == 1 && reqEnable) {
        // counts2[floorIdx]++;
        // } else if (elevatorIdx == 1 && !reqEnable) {
        // counts2[floorIdx]--;
        // }
    }

    // Event: Elevator has arrived at the floor & doors are open.
    public void onElevatorArrivedAtFloor(int elevatorIdx, int floorIdx, Direction travelDirection) {
        // System.out.println("onElevatorArrivedAtFloor(" + elevatorIdx + ", " +
        // floorIdx + ", " + travelDirection + ")");

    }

    // Event: Called each frame of the simulation (i.e. called continuously)
    public void onUpdate(double deltaTime) {
        if (game == null) {
            return;
        }
        // for (int el = 0; el < game.getElevatorCount(); el++) {
        // curFloors.add((int) game.getElevatorFloor(el));
        // }

        if (game.getLevelTimeRemaining() < 60 && first) {
            try {
                saveImage("https://m.media-amazon.com/images/I/51KrLlub+cL._AC_SY300_SX300_.jpg",
                        "textures/zombie_00.png");
                saveImage("https://m.media-amazon.com/images/I/51KrLlub+cL._AC_SY300_SX300_.jpg",
                        "textures/zombie_01.png");
                saveImage("https://m.media-amazon.com/images/I/51KrLlub+cL._AC_SY300_SX300_.jpg",
                        "textures/zombie_02.png");
                saveImage("https://m.media-amazon.com/images/I/51KrLlub+cL._AC_SY300_SX300_.jpg",
                        "textures/zombie_03.png");
                saveImage("https://m.media-amazon.com/images/I/51KrLlub+cL._AC_SY300_SX300_.jpg",
                        "textures/zombie_04.png");
                saveImage("https://m.media-amazon.com/images/I/51KrLlub+cL._AC_SY300_SX300_.jpg",
                        "textures/zombie_05.png");
            } catch (IOException e) {
                e.printStackTrace();
            }
            first = false;
        }

        for (int el = 0; el < game.getElevatorCount(); el++) {
            prevReqs = new ArrayList<Integer>();
            curFloors = new ArrayList<Integer>();

            for (int el2 = 0; el2 < game.getElevatorCount(); el2++) {
                curFloors.add((int) game.getElevatorFloor(el2));
                for (int i = 0; i < game.getFloorCount(); i++) {
                    if (game.isElevatorIsHeadingToFloor(el2, i)) {
                        prevReqs.add(i);
                    }
                }
            }

            // System.out.println(curFloors);
            // System.out.println(prevReqs);
            int max = -1;
            for (int i = 0; i < game.getFloorCount(); i++) {
                if ((game.hasElevatorRequestDown(i) || game.hasElevatorRequestUp(i))
                        && i != game.getElevatorFloor(el)
                        && game.isElevatorIdle(el) && !prevReqs.contains(i) && !curFloors.contains(i)) {
                    max = i;
                }
            }

            int max2 = -1;
            for (int i = 0; i < game.getFloorCount(); i++) {
                if (game.elevatorHasFloorRequest(el, i) && i != game.getElevatorFloor(el) && game.isElevatorIdle(el)
                        && !prevReqs.contains(i) && !curFloors.contains(i)) {
                    max2 = i;
                }
            }

            int j = -1;
            for (int i = 0; i < game.getFloorCount(); i++) {
                // System.out.println(game.getElevatorFloor(0) + " curFloor");
                // - .... .. ... / .. ... / .-. --- -. .- ...- ... / -.-. --- -.. . / .-.. -- .-
                // ---
                if (game.hasElevatorRequestDown(i) && (int) game.getElevatorFloor(el) >= i && !prevReqs.contains(i)
                        && !curFloors.contains(i)) {
                    j = i > j ? i : j;
                } else if (game.hasElevatorRequestUp(i) && (int) game.getElevatorFloor(el) <= i
                        && !prevReqs.contains(i) && !curFloors.contains(i)) {
                    j = i < j ? i : j;
                }
                if ((int) game.getElevatorFloor(el) < i && game.elevatorHasFloorRequest(el, i)) {
                    j = i > j ? i : j;
                } else if ((int) game.getElevatorFloor(el) > i && game.elevatorHasFloorRequest(el, i)) {
                    j = i < j ? i : j;
                }
            }

            if (j != -1) {
                // System.out.println(j + " j");
                // if (j > game.getElevatorFloor(el)) {
                // game.setElevatorTravelDirection(el, Direction.Up);
                // } else {
                // game.setElevatorTravelDirection(el, Direction.Down);
                // }
                if (!game.isElevatorIsHeadingToFloor(el, j) && game.isElevatorIdle(el)) {
                    // System.out.println("go to " + j);
                    curFloors.add((int) game.getElevatorFloor(el));
                    prevReqs.add(j);
                    gotoFloor(el, j);
                }
            } else {
                // System.out.println(j + " j");
                // System.out.println(max2 + " max2");
                // System.out.println(max + " max");
                if (!game.isElevatorIsHeadingToFloor(el, max2) && game.isElevatorIdle(el)
                        && max2 >= 0) {
                    // System.out.println("go to " + max2);
                    curFloors.add((int) game.getElevatorFloor(el));
                    prevReqs.add(max2);
                    // if (max2 > game.getElevatorFloor(el)) {
                    // game.setElevatorTravelDirection(el, Direction.Up);
                    // } else {
                    // game.setElevatorTravelDirection(el, Direction.Down);
                    // }
                    gotoFloor(el, max2);
                } else if (!game.isElevatorIsHeadingToFloor(el, max) && game.isElevatorIdle(el) && max >= 0) {
                    // System.out.println("go to " + max);
                    curFloors.add((int) game.getElevatorFloor(el));
                    prevReqs.add(max);
                    // if (max > game.getElevatorFloor(el)) {
                    // game.setElevatorTravelDirection(el, Direction.Up);
                    // } else {
                    // game.setElevatorTravelDirection(el, Direction.Down);
                    // }
                    gotoFloor(el, max);
                }

                // if (curFloors.size() > 0) {
                // System.out.println(curFloors);
                // }

            }
        }
    }

    public static void saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destinationFile);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
    }
}