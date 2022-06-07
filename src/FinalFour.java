import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Shira Cohen
 * ID: 209088368
 * This class provides information about the fourth level of the game.
 */
public class FinalFour implements LevelInformation {
    private int numOfBalls = 3;
    private int numOfBlocks = 105;
    private int paddleSpeed = 20;
    private int paddleWidth = 100;

    /**
     * Provides the number of balls in the level.
     * @return number of balls
     */
    public int numberOfBalls() {
        return numOfBalls;
    }

    /**
     * Provides the initial velocity of each ball.
     * @return a list of the velocities
     */
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l = new ArrayList<Velocity>();
        l.add(Velocity.fromAngleAndSpeed(40, 4.5));
        l.add(Velocity.fromAngleAndSpeed(320, 4.5));
        l.add(Velocity.fromAngleAndSpeed(0, 4.5));
        return l;
    }

    /**
     * Provides the paddle speed in this level.
     * @return the paddle speed
     */
    public int paddleSpeed() {
        return paddleSpeed;
    }

    /**
     * Provides the paddle width in this level.
     * @return the paddle width
     */
    public int paddleWidth() {
        return paddleWidth;
    }

    /**
     * The level name that will be displayed at the top of the screen.
     * @return a string of the level name
     */
    public String levelName() {
        return "Final Four";
    }

    /**
     * Provides a sprite with the background of the level.
     * @return the background sprite
     */
    public Sprite getBackground() {
        return new Background(Color.BLUE);
    }

    /**
     * Provides the Blocks that make up this level, each block contains its size, color and location.
     * @return a list of the blocks
     */
    public List<Block> blocks() {
        List<Block> l = new ArrayList<Block>();

        int rows = 7;
        int columns = 15;
        int gap1;
        int gap2 = 0;

        for (int i = 0; i < rows; i++) {
            gap1 = 0;
            for (int j = 0; j < columns; j++) {
                Block b = new Block(new Rectangle(new Point(739 - gap1, 75 + gap2), 50, 20));
                if (i == 0) {
                    b.setColor(Color.GRAY);
                }
                if (i == 1) {
                    b.setColor(Color.RED);
                }
                if (i == 2) {
                    b.setColor(Color.YELLOW);
                }
                if (i == 3) {
                    b.setColor(Color.GREEN);
                }
                if (i == 4) {
                    b.setColor(Color.WHITE);
                }
                if (i == 5) {
                    b.setColor(Color.PINK);
                }
                if (i == 6) {
                    b.setColor(Color.CYAN);
                }
                l.add(b);
                gap1 += 52;
            }
            gap2 += 22;
        }

        return l;
    }

    /**
     * Provides the number of blocks that should be removed before the level is considered to be "cleared".
     * @return the number of blocks
     */
    public int numberOfBlocksToRemove() {
        return numOfBlocks;
    }
}
