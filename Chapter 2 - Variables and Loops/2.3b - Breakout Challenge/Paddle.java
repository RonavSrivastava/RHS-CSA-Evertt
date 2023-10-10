import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;

public class Paddle {
    private final double PADDLE_HEIGHT = 0.15;

    private double posX;
    private double posY = 0;
    private double halfWidth;
    private double halfHeight;
    private Point prevMousePos;

    public Paddle(double posX, double halfWidth) {
        this.posX = posX;
        this.halfWidth = halfWidth;
    }

    public boolean isInGridSquare(int x, int y) {
        return (y == posY) && ((double)x >= posX - halfWidth) && ((double)x  < posX + halfWidth);
    }

    // Returns null is no intersection, otherwise the normal vector
    //  Method also assumes substepping, so doesn't do clip motion at intersection
    public Vec2 rayCast(Vec2 start, Vec2 end) {
        // If it's breaking the plane of the paddle, just check for containment (not super accurate, probably be ok)
        if ((start.y > PADDLE_HEIGHT) && (end.y <= PADDLE_HEIGHT)) {
            if ((end.x >= posX - halfWidth) && (end.x <= posX + halfWidth)) {
                Vec2 paddleToBall = Vec2.subtract(start, new Vec2(posX, PADDLE_HEIGHT)).unit();
                Vec2 collisionNormal = Vec2.add(paddleToBall, Vec2.multiply(Vec2.up(), 10)); // Keep it pointed upright
                return collisionNormal.unit();
            }
        }
        return null;
    }

    public void update(double deltaTime) {
        // Mouse movement drive the cursor
        PointerInfo mouse = MouseInfo.getPointerInfo();
        Point mousePos = mouse.getLocation();
        if (prevMousePos != null) {
            double pixelsToGridUnits = 0.05;
            double paddleDeltax = (double)(mousePos.x - prevMousePos.x) * pixelsToGridUnits;
            posX = Math.min(Math.max(posX + paddleDeltax, halfWidth), Simulation.GRID_WIDTH - halfWidth);
            double paddleDeltay = (double)(mousePos.y - prevMousePos.y) * pixelsToGridUnits;
            posY = Math.min(Math.max(posX + paddleDeltay, halfHeight), Simulation.GRID_HEIGHT - halfWidth);
        }
        prevMousePos = mousePos;
    }
}
