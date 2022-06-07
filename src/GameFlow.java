import biuoop.KeyboardSensor;
import java.util.List;

/**
 * @author Shira Cohen
 * ID: 209088368
 * This class will be in charge of creating the different levels, and moving from one level to the next.
 */
public class GameFlow {
    private AnimationRunner runner;
    private KeyboardSensor kSensor;
    private Counter score;

    /**
     * Constructor.
     * @param ar AnimationRunner
     * @param ks KeyboardSensor
     * @param scr score Counter
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, Counter scr) {
        this.runner = ar;
        this.kSensor = ks;
        this.score = scr;
    }

    /**
     * Runs the levels according to the order in the provided list.
     * @param levels List of the levels
     */
    public void runLevels(List<LevelInformation> levels) {

        int blocksLeft = -1;

        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.kSensor, this.runner, this.score);

            level.initialize();

            while (level.getRemainingBlocks() > 0 && level.getRemainingBalls() > 0) {
                level.run();
            }

            blocksLeft = level.getRemainingBlocks();

            if (level.getRemainingBalls() == 0) {
                break;
            }
        }

        this.runner.run(new KeyPressStoppableAnimation(this.kSensor,
                KeyboardSensor.SPACE_KEY,
                new EndScreen(this.score.getValue(), blocksLeft)));

        this.runner.closeGui();
    }
}

