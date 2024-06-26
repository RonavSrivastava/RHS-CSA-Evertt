package simulation;

import framework.FluidRendererBase;
import framework.FluidSimulationBase;
import framework.Vec3;

import java.awt.image.WritableRaster;

/* FluidRenderer is responsible for rendering/drawing the simulation.
 *  You are implementing the method shown below. The renderTarget is an image. You
 *    can write individual pixels of the image using something like this...
 *        renderTarget.setPixel(x, y, new int[] { 0, 255, 0, 255 });
 *    the above line would write green to the pixel location at location (x,y). 
 *  Note that the 3rd argument is in the format Red,Green,Blue,Alpha. Alpha is
 *    used for transparency. You probably want to keep that as 255 all the time.
 *    Each R/G/B/A value is in the range of [0,255].
 * 
 * Tips...
 *   - You probably want to draw the density field and ignore the velocity field, 
 *      as this is generally the only thing that would be visible (though, using
 *      the velocity field as well might be a fun thing to play with).
 *   - You can get the density field with: double[][] densityField = sim.getDensityField();
 *   - Until you add sources in the FluidSimulation, your density field will be
 *      all zeros, so don't expect to be able to rendering anything interesting until 
 *      you have at least some test code adding a source there.
 */
public class FluidRenderer implements FluidRendererBase {
    // private Vec3 color = new Vec3(64, 224, 208); // turquoise
    private Vec3 color = new Vec3(57, 255, 20); //neon green

    public void render(WritableRaster renderTarget, FluidSimulationBase sim) {
        double[][] f = sim.getDensityField();

        // for (int i = 0; i < f.length; i++) {
        // for (int j = 0; j < f[i].length; j++) {
        // renderTarget.setPixel(i, j, new int[] { 0, (int) Math.min((f[i][j])/10, 255),
        // 0,
        // 255 });
        // }
        // }
        for (int i = 0; i < f.length - 1; i++) {
            for (int j = 0; j < f[i].length - 1; j++) {
                for (int r = 0; r < 7; r++) {
                    for (int r2 = 0; r2 < 7; r2++) {
                        renderTarget.setPixel((i * 7) + r, (j * 7) + r2, new int[] {
                                Math.min((int) (lerp(lerp(f[i][j], f[i + 1][j], r / 7.0),
                                        lerp(f[i][j + 1], f[i + 1][j + 1], r / 7.0), r2 / 7.0) * 1), 255) * (int) color.x/255,
                                Math.min((int) (lerp(lerp(f[i][j], f[i + 1][j], r / 7.0),
                                        lerp(f[i][j + 1], f[i + 1][j + 1], r / 7.0), r2 / 7.0) * 1), 255)  * (int) color.y/255,
                                Math.min((int) (lerp(lerp(f[i][j], f[i + 1][j], r / 7.0),
                                        lerp(f[i][j + 1], f[i + 1][j + 1], r / 7.0), r2 / 7.0) * 1), 255)  * (int) color.z/255,
                                255 });
                    }
                }
            }
        }
    }

    public double lerp(double min, double max, double weight) {
        return (1 - weight) * min + (weight) * max;
    }
}
