import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
/**
 * @author Shira Cohen
 * ID: 209088368
 * This class takes an Animation object and runs it.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    /**
     * Constructor.
     * @param g the GUI object
     * @param fps frames per second
     * @param s the Sleeper object
     */
    public AnimationRunner(GUI g, int fps, Sleeper s) {
        this.gui = g;
        this.framesPerSecond = fps;
        this.sleeper = s;
    }

    /**
     * This method runs the animation.
     * @param animation The Animation object that is being run
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * Closes the gui object.
     */
    public void closeGui() {
        this.gui.close();
    }
}
