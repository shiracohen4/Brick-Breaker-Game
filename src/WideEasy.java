import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shira Cohen
 * ID: 209088368
 * This class provides information about the second level of the game.
 */
public class WideEasy implements LevelInformation {
    private int numOfBalls = 10;
    private int numOfBlocks = 15;
    private int paddleSpeed = 12;
    private int paddleWidth = 600;

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
        List<Velocity> l = new ArrayList<>();
        int anglePos = 0;
        int angleNeg = 0;
        for (int i = 0; i < numOfBalls; i++) {
            if (i < 5) {
                Velocity v = Velocity.fromAngleAndSpeed(30 + anglePos, 4);
                l.add(v);
                anglePos += 10;
            } else {
                Velocity v = Velocity.fromAngleAndSpeed(330 + angleNeg, 4);
                l.add(v);
                angleNeg -= 10;
            }
        }
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
        return "Wide Easy";
    }

    /**
     * Provides a sprite with the background of the level.
     * @return the background sprite
     */
    public Sprite getBackground() {
        return new Background(Color.WHITE);
    }

    /**
     * Provides the Blocks that make up this level, each block contains its size, color and location.
     * @return a list of the blocks
     */
    public List<Block> blocks() {
        List<Block> l = new ArrayList<>();
        int xGap = 0;
        for (int i = 0; i < numOfBlocks; i++) {
            Block b = new Block(new Rectangle(new Point(11 + xGap, 200), 50, 15));
            xGap += 52;
            if (i <= 1) {
                b.setColor(Color.RED);
            }
            if (i > 1 && i <= 3) {
                b.setColor(Color.ORANGE);
            }
            if (i > 3 && i <= 5) {
                b.setColor(Color.YELLOW);
            }
            if (i > 5 && i <= 8) {
                b.setColor(Color.GREEN);
            }
            if (i > 8 && i <= 10) {
                b.setColor(Color.BLUE);
            }
            if (i > 10 && i <= 12) {
                b.setColor(Color.PINK);
            }
            if (i > 12 && i <= 14) {
                b.setColor(Color.CYAN);
            }
            l.add(b);
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
