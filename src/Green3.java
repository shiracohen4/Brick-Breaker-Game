import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shira Cohen
 * ID: 209088368
 * This class provides information about the third level of the game.
 */
public class Green3 implements LevelInformation {
    private int numOfBalls = 2;
    private int numOfBlocks = 40;
    private int paddleSpeed = 17;
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
        l.add(Velocity.fromAngleAndSpeed(30, 4.5));
        l.add(Velocity.fromAngleAndSpeed(330, 4.5));
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
        return "Green 3";
    }

    /**
     * Provides a sprite with the background of the level.
     * @return the background sprite
     */
    public Sprite getBackground() {
        return new Background(Color.GREEN);
    }

    /**
     * Provides the Blocks that make up this level, each block contains its size, color and location.
     * @return a list of the blocks
     */
    public List<Block> blocks() {
        List<Block> l = new ArrayList<>();

        int rows = 5;
        int columns = 10;
        int c = 0;
        int gap1;
        int gap2 = 0;

        for (int i = 0; i < rows; i++) {
            gap1 = 0;
            for (int j = c; j < columns; j++) {
                Block b = new Block(new Rectangle(new Point(739 - gap1, 150 + gap2), 50, 20));
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
                    b.setColor(Color.BLUE);
                }
                if (i == 4) {
                    b.setColor(Color.WHITE);
                }
                l.add(b);
                gap1 += 52;
            }
            gap2 += 22;
            c++;
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
