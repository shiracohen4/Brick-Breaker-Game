import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author Shira Cohen
 * ID: 209088368
 * ScoreIndicator is in charge of displaying the current score.
 * It holds a reference to the score counter,
 * and will be added to the game as a sprite positioned at the top of the screen.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;

    /**
     * Constructor.
     * @param score The score counter.
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    /**
     * Draws the score counter on the screen.
     * @param d The given surface.
     */
    public void drawOn(DrawSurface d) {
        Integer s = this.score.getValue();
        d.setColor(Color.DARK_GRAY);
        d.fillRectangle(0, 0, 800, 25);
        d.setColor(Color.WHITE);
        d.drawText(350, 20, "Score: " + s.toString(), 15);
    }

    /**
     * Notifies the sprite that time has passed.
     */
    public void timePassed() {
        //Not relevant.
    }
}
