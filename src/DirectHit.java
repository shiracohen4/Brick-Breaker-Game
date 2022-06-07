import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shira Cohen
 * ID: 209088368
 * This class provides information about the first level of the game.
 */
public class DirectHit implements LevelInformation {
    private int numOfBalls = 1;
    private int numOfBlocks = 1;
    private int paddleSpeed = 10;
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
        List<Velocity> l = new ArrayList<>();
        l.add(new Velocity(0, -2));
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
        return "Direct Hit";
    }

    /**
     * Provides a sprite with the background of the level.
     * @return the background sprite
     */
    public Sprite getBackground() {
        return new Background(Color.BLACK);
    }

    /**
     * Provides the Blocks that make up this level, each block contains its size, color and location.
     * @return a list of the blocks
     */
    public List<Block> blocks() {
        List<Block> l = new ArrayList<>();
        l.add(new Block(new Rectangle(new Point(385, 150), 30, 30)));
        l.get(0).setColor(Color.RED);
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
