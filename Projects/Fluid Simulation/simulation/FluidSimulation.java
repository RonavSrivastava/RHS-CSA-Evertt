package simulation;

import java.util.ArrayList;
import java.util.Random;

import java.awt.*;

import framework.FluidSimulationBase;
import framework.Vec2;
import framework.Vec3;

/* FluidSimulation is responsible for updating the fluid's simulation.
 *  The majority of the simulation code is provided for you. 
 * 
 * You are adding a few key things to bring it to life. They include...
 *   - User input, responsible for two thing...
 *      - Add "smoke/dye" sources for the density field (without this, its all just black).
 *      - Add velocity sources/forces for the velocity field (without this, no motion).
 * 
 * This class derives off of a base class that contains both fields. That base class
 *  calls two methods in this class that you should implement:
 *   - setSourcesForDensityField(double[][] densField) 
 *      This method should add "smoke/dye" sources/input into the system. If, for example,
 *      this method set "densField[0][0] = 10", this would insert some "smoke/dye" density
 *      into the lower left of the simulation.
 *   - setSourcesForVelocityField(Vec2[][] velField)
 * 
 * Both of the above methods are called for you at each simulation step (every frame). Note
 *  that you can also get direct access to fields using getDensityField() & getVelocityField(), 
 *  though they are parameters to the above methods, so you may not need to. The main update
 *  method for the simulation is also implemented in this class, though the implementation is
 *  provided, you may want to add other things to update (maybe process/smooth mouse input).
 * 
 * Tips...
 *   - Keyboard and mouse input events are provided in this class, you'll want to make use
 *      of those, maybe save off information in instance data and then use it in the 
 *      setSources methods.
 *   - If you are looking for useful math/intersection methods, many are provided for you
 *      in framework\Util.java (they are public, so feel free to use them).
 */
public class FluidSimulation extends FluidSimulationBase {
    // consts
    private final double DENSITY_DAMP_FACTOR = 0.05;
    private ArrayList<Vec3> sources = new ArrayList<Vec3>();
    private boolean pressed = false;
    PointerInfo a = MouseInfo.getPointerInfo();
    PointerInfo prevA = MouseInfo.getPointerInfo();
    private boolean first = true;
    PointerInfo v = MouseInfo.getPointerInfo();
    PointerInfo prevV = MouseInfo.getPointerInfo();
    private boolean pressed2 = false;

    // input
    public void onKeyPressed(char ch) {
        if (ch == ' ') {

        }
    }

    public void onKeyReleased(char ch) {
    }

    public void onMouseButtonPressed(int buttonId) {
        if (buttonId == 1) {
            pressed = true;
        } else if (buttonId == 3) {
            pressed2 = true;
        }
    }

    public void onMouseButtonReleased(int buttonId) {
        if (buttonId == 1) {
            pressed = false;
        }else if (buttonId == 3) {
            pressed2 = false;
        }
    }

    // Update method is called continuously, once per frame, with the amount of time
    // that has
    // passed since the last update. The method is responsible for updating the
    // simulation
    // by updating both the velocity & density fields (this is implemented for you).
    // These
    // methods will call other "setSource..." methods in this class which you should
    // also
    // implement to set all the sources/forces that provide the simulation with
    // input.
    //
    // This method should also be used to update your user input, which can be
    // driven by
    // a combination of mouse and keyboard input. Events for these are provided
    // above
    // and you can also call getMousePosition_simRelative() to get the mouse
    // position.
    public void update(double deltaTime) {
        // update the density & velocity fields
        updateSources();
        updateVelocityField(deltaTime);
        updateDensityField(deltaTime);

        // damp the density field (this simulates leakage out of the system)
        dampDensityField(getDensityField(), Math.max(1.0 - deltaTime * DENSITY_DAMP_FACTOR, 0.0));
    }

    private void updateSources() {
        boolean found = false;
        a = MouseInfo.getPointerInfo();
        int x = Math.max(Math.min((int) a.getLocation().getX() - 465, 909), 0);
        int y = Math.max(Math.min((int) a.getLocation().getY() - 256, 461), 0);
        // System.out.println(y);
        x /= 7;
        y /= 7;
        if (pressed) {
            for (int i = 0; i < sources.size(); i++) {
                if (sources.get(i).x == x && sources.get(i).y == y) {
                    found = true;
                    sources.get(i).add(new Vec3(0, 0, 50000));
                }
            }
            if (!found) {
                sources.add(new Vec3(x, y,50000));
            }
        }
        prevA = a;
        // hehe
    }

    // Set the source/forces field for the dye/smoke in the density field
    public void setSourcesForDensityField(double[][] densField) {
        if (first) {
            for (int r = 0; r < densField.length; r++) {
                for (int c = 0; c < densField[r].length; c++) {
                    densField[r][c] = 10 * (r + c + 50);
                }
            }
            first = false;
        } else {
            for (int i = 0; i < sources.size(); i++) {
                densField[(int) (sources.get(i).x)][(int) (sources.get(i).y)] = sources.get(i).z;
            }
        }
        if (sources.size() > 0) {
            for (int i = 0; i < sources.size(); i++) {
                sources.remove(0);
            }
        }
    }

    // Set the source/forces field for the velocity field
    public void setSourcesForVelocityField(Vec2[][] velField) {
        v = MouseInfo.getPointerInfo();
        Random rand = new Random();
        for (int r = 0; r < velField.length; r++) {
            for (int c = 0; c < velField[r].length; c++) {
                if (Math.abs(r - (v.getLocation().getX() - 465)/7) < 3 && Math.abs(c - (v.getLocation().getY() - 256)/7) < 3 && pressed2) {
                    velField[r][c] = new Vec2(
                            (rand.nextDouble() - 0.5) - (prevV.getLocation().getX() - v.getLocation().getX()),
                            (rand.nextDouble() - 0.5) - (prevV.getLocation().getY() - v.getLocation().getY()));
                } else {
                    velField[r][c] = new Vec2((rand.nextDouble() - 0.5), (rand.nextDouble() - 0.5));
                }
            }
        }
        prevV = v;
    }
}
