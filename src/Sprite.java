import biuoop.DrawSurface;

/**
 * @author Shira Cohen
 * ID: 209088368
 * This interface will be used by objects that are sprites.
 */
public interface Sprite {

    /**
     * Draws the sprite to the screen.
     * @param d The given surface.
     */
    void drawOn(DrawSurface d);

    /**
     * Notifies the sprite that time has passed.
     */
    void timePassed();
}