import biuoop.DrawSurface;
/**
 * @author Shira Cohen
 * ID: 209088368
 * This interface will be used by animation objects.
 */

public interface Animation {
    /**
     * One frame of the animation.
     * @param d the DrawSurface
     */
    void doOneFrame(DrawSurface d);

    /**
     * Indicates whether the animation should stop.
     * @return true or false.
     */
    boolean shouldStop();
}
