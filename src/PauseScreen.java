import biuoop.DrawSurface;

/**
 * @author Shira Cohen
 * ID: 209088368
 * This class defines a pause screen for the game.
 */
public class PauseScreen implements Animation {
    /**
     * The pause screen.
     * @param d the DrawSurface
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }
    /**
     * Indicates whether the animation should stop.
     * @return false.
     */
    public boolean shouldStop() {
        return false;
    }
}
