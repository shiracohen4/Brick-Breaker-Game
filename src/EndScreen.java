import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author Shira Cohen
 * ID: 209088368
 * This class defines two end screens for the game.
 */
public class EndScreen implements Animation {
    private int score;
    private int remainingBlocks;

    /**
     * Constructor.
     * @param s the score at the end of the game
     * @param rb the amount of remaining blocks at the end of the game
     */
    public EndScreen(int s, int rb) {
        this.score = s;
        this.remainingBlocks = rb;
    }

    /**
     * Two end screens: "game over" and "you win".
     * @param d the DrawSurface
     */
    public void doOneFrame(DrawSurface d) {

        if (remainingBlocks == 0) {
            d.setColor(Color.PINK);
            d.fillRectangle(0, 0, 800, 600);
            d.setColor(Color.BLACK);
            d.drawText(145, 245, "YOU WIN! :D", 80);
            d.drawText(260, 450, "Your score is " + score, 30);
            d.setColor(Color.WHITE);
            d.drawText(150, 250, "YOU WIN! :D", 80);

        }

        if (remainingBlocks > 0) {
            d.setColor(Color.BLACK);
            d.fillRectangle(0, 0, 800, 600);
            d.setColor(Color.RED);
            d.drawText(145, 245, "GAME OVER", 80);
            d.setColor(Color.WHITE);
            d.drawText(150, 250, "GAME OVER", 80);
            d.drawText(260, 450, "Your score is " + score, 30);
        }

    }

    /**
     * Indicates whether the animation should stop.
     * @return false.
     */
    public boolean shouldStop() {
        return false;
    }
}
