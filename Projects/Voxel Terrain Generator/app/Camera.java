package app;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextField;

import framework.CameraBase;
import framework.WorldBase;
import math.Mat3x3;
import math.Vec2;
import math.Vec3;

/* In this lab, you will be implementing a camera that lets you fly/run around the
 *   world. Before any modifications, you'll just be stuck looking forward and unable
 *   to move. All of your code can go in this file.
 * 
 * Inputs...
 *   - Arrow keys (including WASD) cab be queried with the methods...
 *          isArrowKeyPressed_Left(), isArrowKeyPressed_Right(),
 *          isArrowKeyPressed_Up(), isArrowKeyPressed_Down()
 *   - Mouse position can be queried with...
 *          getMouseCursorPos()
 * 
 * You would make the motion nice and smooth (using acceleration & velocity for position).
 *  You can get and set the position of the camera in 3D space with getPos() and setPos(...).
 *  The mouse look is a bit tricker. The orientation of the camera is specified by two 
 *  vectors: lookDirection (use getLookDir() & setLookDir(...) for access) and 
 *  upVector (use up() & setUpDir(...) for access). You can use the Mat3x3 class to help
 *  you with rotation about an axis. For example, the static Mat3x3.transRotAxis(...) method
 *  creates a 3x3 rotation matrix about the specified axis. You can use this to rotate vectors.
 *  I'd suggest watching a youTube video about rotating vectors with 3x3 matrices to get
 *  you started.
 */
public class Camera extends CameraBase {
    // consts

    // data
    Vec3 vel = new Vec3(0, 0, 0);
    Vec3 accel = new Vec3(0, 0, 0);
    double speed = 5;
    JTextField textField = new JTextField();

    // constructor(s)
    public Camera(Vec3 pos, Vec3 forward) {
        super(pos, forward);
        KeyListener j = new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Handle the key press event
            }
            @Override
            public void keyReleased(KeyEvent e) {
                // Handle the key release event
            }
        }
        textField.addKeyListener(j);
    }

    // methods
    private void updateMotion(double deltaTime) {
        // World access
        WorldBase world = WorldBase.get();
        if(isArrowKeyPressed_Left()) {
            accel.add(new Vec3(speed, 0, 0));
        }
        if(isArrowKeyPressed_Right()) {
            accel.subtract(new Vec3(speed, 0, 0));
        }
        if(isArrowKeyPressed_Down()) {
            accel.add(new Vec3(0, 0, speed));
        }
        if(isArrowKeyPressed_Up()) {
            accel.subtract(new Vec3(0, 0, speed));
        }
        if(isKeyPressed(KeyEvent.VK_W)) {
            System.out.println("what");
            accel.add(new Vec3(0, speed, 0));
        }
        if(isKeyPressed(KeyEvent.SHIFT_DOWN_MASK)) {
            System.out.println("what2");
            accel.subtract(new Vec3(0, speed, 0));
        }
        vel.add(accel);
        accel.multiply(0.95);
        setPos(getPos().add(vel.multiply(deltaTime)));
    }
    private void updateLookDirection(double deltaTime) {
        // TODO
    }
    public void update(double deltaTime) {
        updateMotion(deltaTime);
        updateLookDirection(deltaTime);
    }
}
