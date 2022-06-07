import biuoop.DrawSurface;

/**
 * @author Shira Cohen
 * ID: 209088368
 * This class creates a Background sprite for the game.
 */
public class Background implements Sprite {
    private java.awt.Color color;

    /**
     * Constructor.
     * @param c the background color
     */
    public Background(java.awt.Color c) {
        this.color = c;
    }

    /**
     * Draws the background to the screen.
     * @param d The given surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle(0, 0, 800, 600);
    }

    /**
     * Irrelevant for this sprite.
     */
    public void timePassed() {
        //Not relevant
    }
}
