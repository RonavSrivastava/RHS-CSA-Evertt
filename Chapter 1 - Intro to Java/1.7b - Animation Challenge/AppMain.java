import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class AppMain {
    static final String FRAME_PATH_FORMAT = "anim 1\\frame_%d.gif";

    /* Challenge Goal
     *  Create the most interesting Ascii Art animation that you can. This must
     * be your own creation (don't plagiarize), but you can look for inspiration 
     * on the web. The most creative animation(s) will win Victory Points at EOD Monday.
     * 
     * You can use the provided endFrame() function (call it after drawing/printing
     * a frame of animation). A simple example is provided.
     */
    public static void main(String[] args) {

        LoadScreen loadScreen = new LoadScreen();
        System.out.println("\033[37m"); // WHITE


        /*
        FrameBuilding f1 = new FrameBuilding("anim 1\\frame_00.gif");
        FrameBuilding f2 = new FrameBuilding("anim 1\\frame_01.gif");
        FrameBuilding f3 = new FrameBuilding("anim 1\\frame_02.gif");
        FrameBuilding f4 = new FrameBuilding("anim 1\\frame_03.gif");
        FrameBuilding f5 = new FrameBuilding("anim 1\\frame_04.gif");
        FrameBuilding f6 = new FrameBuilding("anim 1\\frame_05.gif");
        FrameBuilding f7 = new FrameBuilding("anim 1\\frame_06.gif");
        FrameBuilding f8 = new FrameBuilding("anim 1\\frame_07.gif");
        FrameBuilding f9 = new FrameBuilding("anim 1\\frame_08.gif");
        FrameBuilding f10 = new FrameBuilding("anim 1\\frame_09.gif");
        FrameBuilding f11 = new FrameBuilding("anim 1\\frame_10.gif");
        FrameBuilding f12 = new FrameBuilding("anim 1\\frame_11.gif");
        FrameBuilding f13 = new FrameBuilding("anim 1\\frame_12.gif");
        FrameBuilding f14 = new FrameBuilding("anim 1\\frame_13.gif");
        FrameBuilding f15 = new FrameBuilding("anim 1\\frame_14.gif");
        FrameBuilding f16 = new FrameBuilding("anim 1\\frame_15.gif");
        FrameBuilding f17 = new FrameBuilding("anim 1\\frame_16.gif");
        FrameBuilding f18 = new FrameBuilding("anim 1\\frame_17.gif");
        FrameBuilding f19 = new FrameBuilding("anim 1\\frame_18.gif");
        FrameBuilding f20 = new FrameBuilding("anim 1\\frame_19.gif");
        FrameBuilding f21 = new FrameBuilding("anim 1\\frame_20.gif");
        FrameBuilding f22 = new FrameBuilding("anim 1\\frame_21.gif");
        FrameBuilding f23 = new FrameBuilding("anim 1\\frame_22.gif");
        FrameBuilding f24 = new FrameBuilding("anim 1\\frame_23.gif");
        FrameBuilding f25 = new FrameBuilding("anim 1\\frame_24.gif");
        FrameBuilding f26 = new FrameBuilding("anim 1\\frame_25.gif");
        FrameBuilding f27 = new FrameBuilding("anim 1\\frame_26.gif");
        FrameBuilding f28 = new FrameBuilding("anim 1\\frame_27.gif");
        FrameBuilding f29 = new FrameBuilding("anim 1\\frame_28.gif");
        FrameBuilding f30 = new FrameBuilding("anim 1\\frame_29.gif");
        */ 

        LinkedList<FrameBuilding> builders = new LinkedList<>();
        File curFrameFile;
        int curFrame = 0;
        do {
            builders.add(new FrameBuilding(String.format(FRAME_PATH_FORMAT, curFrame)));
            curFrame++;
            curFrameFile = new File(String.format(FRAME_PATH_FORMAT, curFrame));
        } while (curFrameFile.exists());

        ExecutorService executor = Executors.newFixedThreadPool(5);

        builders.forEach((FrameBuilding builder) -> {
            executor.submit(builder);
        });

        // executor.submit(f1);
        // executor.submit(f2);
        // executor.submit(f3);
        // executor.submit(f4);
        // executor.submit(f5);
        // executor.submit(f6);
        // executor.submit(f7);
        // executor.submit(f8);
        // executor.submit(f9);
        // executor.submit(f10);
        // executor.submit(f11);
        // executor.submit(f12);
        // executor.submit(f13);
        // executor.submit(f14);
        // executor.submit(f15);
        // executor.submit(f16);
        // executor.submit(f17);
        // executor.submit(f18);
        // executor.submit(f19);
        // executor.submit(f20);
        // executor.submit(f21);
        // executor.submit(f22);
        // executor.submit(f23);
        // executor.submit(f24);
        // executor.submit(f25);
        // executor.submit(f26);
        // executor.submit(f27);
        // executor.submit(f28);
        // executor.submit(f29);
        // executor.submit(f30);

        loadScreen.loadScreen();
        loadScreen.loadScreen();

        shutdownAndAwaitTermination(executor);


        builders.forEach((FrameBuilding builder) -> {
            printAndEnd(builder.curFrame);
        });

        resetColor();
    }

    /* Tips...
     *  - After you've draw your 'scene' for the frame, call delayAndClearForNextFrame()
     *  - If you'd like to use colors, you can use this...
     *      System.out.println("\033[0m");  // RESET TO DEFAULT COLOR
     *      System.out.println("\033[31m"); // RED
     *      System.out.println("\033[32m"); // GREEN
     *      System.out.println("\033[33m"); // YELLOW
     *      System.out.println("\033[34m"); // BLUE
     *      System.out.println("\033[35m"); // MAGENTA
     *      System.out.println("\033[36m"); // CYAN
     *      System.out.println("\033[37m"); // WHITE
     */

    /* Call this function when you are done drawing/printing your "Frame" of animation.
     *  It will leave your Ascii art on the screen for a short time
     *    and then clear the console so that you can print out your next frame.
     *  If you call endFrame(), that will default to a 250ms (or 0.25 second) delay.
     *  If you call endFrame(100), you control the delay time (this example is 100ms).
     */
    public static void endFrame() {
        endFrame(150);
    }
    public static void endFrame(int delayMilliSeconds) {  
        // Delay a for a short time (leave it on the screen)
        try {
            Thread.sleep(delayMilliSeconds);
        } 
        catch (Exception ex) {
        }

        // Clear the console
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
    public static void resetColor() {
        System.out.print("\033[0m");
    }
    public static void printAndEnd(String AsciiImg) {
        System.out.println(AsciiImg);
        endFrame();
    }
    public static void shutdownAndAwaitTermination(ExecutorService executorService) {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            } 
        } catch (InterruptedException ie) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
