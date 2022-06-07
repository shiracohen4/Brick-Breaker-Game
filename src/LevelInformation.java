import java.util.List;
/**
 * @author Shira Cohen
 * ID: 209088368
 * This interface specifies the information required to fully describe a level.
 */

public interface LevelInformation {
    /**
     * Provides the number of balls in the level.
     * @return number of balls
     */
    int numberOfBalls();

    /**
     * Provides the initial velocity of each ball.
     * @return a list of the velocities
     */
    List<Velocity> initialBallVelocities();

    /**
     * Provides the paddle speed in this level.
     * @return the paddle speed
     */
    int paddleSpeed();

    /**
     * Provides the paddle width in this level.
     * @return the paddle width
     */
    int paddleWidth();

    /**
     * The level name that will be displayed at the top of the screen.
     * @return a string of the level name
     */
    String levelName();

    /**
     * Provides a sprite with the background of the level.
     * @return the background sprite
     */
    Sprite getBackground();

    /**
     * Provides the Blocks that make up this level, each block contains its size, color and location.
     * @return a list of the blocks
     */
    List<Block> blocks();

    /**
     * Provides the number of blocks that should be removed before the level is considered to be "cleared".
     * @return the number of blocks
     */
    int numberOfBlocksToRemove();
}
