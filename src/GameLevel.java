import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * @author Shira Cohen
 * ID: 209088368
 * This class holds the sprites and the collidables, and will be in charge of the animation.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites = new SpriteCollection();
    private GameEnvironment environment = new GameEnvironment();
    private Counter remainingBlocks = new Counter(0);
    private Counter remainingBalls = new Counter(0);
    private Counter score;
    private AnimationRunner runner;
    private boolean running = false;
    private biuoop.KeyboardSensor keyboard;
    private LevelInformation lvlInfo;

    private final int screenWidth = 800;
    private final int screenHeight = 600;
    private final int borderWidth = 10;

    /**
     * Constructor.
     * @param li LevelInformation
     * @param ks KeyboardSensor
     * @param ar AnimationRunner
     * @param scr score Counter
     */
    public GameLevel(LevelInformation li, KeyboardSensor ks, AnimationRunner ar, Counter scr) {
        this.lvlInfo = li;
        this.keyboard = ks;
        this.runner = ar;
        this.score = scr;
    }

    /**
     * Adds a given collidable object to the game.
     * @param c The given collidable object.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * Adds a given sprite to the game.
     * @param s The given sprite.
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * Removes a collidable object from the game.
     * @param c The collidable object.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidableGameEnv(c);
    }

    /**
     * Removes a Sprite object from the game.
     * @param s The Sprite object.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSpriteSpriteCol(s);
    }

    /**
     * Initializes a new game: creates the blocks, the ball and the paddle and adds them to the game.
     */
    public void initialize() {
        //background
        this.addSprite(lvlInfo.getBackground());

        //paddle
        Paddle paddle = new Paddle(keyboard, lvlInfo.paddleWidth());
        paddle.setColor(Color.LIGHT_GRAY);
        paddle.setSpeed(lvlInfo.paddleSpeed());
        paddle.addToGame(this);

        //balls
        for (int i = 0; i < lvlInfo.numberOfBalls(); i++) {
            Ball b = new Ball(400, 550, 7, Color.WHITE);
            b.setVelocity(lvlInfo.initialBallVelocities().get(i));
            b.setGameEnvironment(this.environment);
            b.addToGame(this);
            this.remainingBalls.increase(1);
        }

        //blocks
        BlockRemover blockR = new BlockRemover(this, this.remainingBlocks);
        this.remainingBlocks.increase(lvlInfo.numberOfBlocksToRemove());
        ScoreTrackingListener scoreL = new ScoreTrackingListener(this.score);
        for (int i = 0; i < lvlInfo.blocks().size(); i++) {
            Block block = lvlInfo.blocks().get(i);
            block.addHitListener(blockR);
            block.addHitListener(scoreL);
            block.addToGame(this);
        }

        //borders
        Block left = new Block(new Rectangle(new Point(0, 0), borderWidth, screenHeight));
        left.setColor(Color.LIGHT_GRAY);
        left.addToGame(this);
        Block right = new Block(new Rectangle(new Point(screenWidth - borderWidth, 0), borderWidth, screenHeight));
        right.setColor(Color.LIGHT_GRAY);
        right.addToGame(this);
        Block upper = new Block(new Rectangle(new Point(0, 0), screenWidth, 25));
        upper.setColor(Color.LIGHT_GRAY);
        upper.addToGame(this);

        //death region
        BallRemover ballR = new BallRemover(this, this.remainingBalls);
        Block deathRegion = new Block(new Rectangle(new Point(0, screenHeight - borderWidth),
                screenWidth, borderWidth));
        deathRegion.setColor(Color.LIGHT_GRAY);
        deathRegion.addHitListener(ballR);
        deathRegion.addToGame(this);

        //score keeping
        ScoreIndicator scoreInd = new ScoreIndicator(this.score);
        this.addSprite(scoreInd);
    }

    /**
     * Runs the game.
     */
    public void run() {
        this.running = true;
        this.runner.run(this);
    }

    /**
     * One frame of the game animation.
     * @param d the DrawSurface
     */
    public void doOneFrame(DrawSurface d) {
        if (this.remainingBlocks.getValue() == 0) {
            this.score.increase(100);
        }

        if (this.remainingBlocks.getValue() == 0 || this.remainingBalls.getValue() == 0) {
            this.running = false;
        }

        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY, new PauseScreen()));
        }

        this.sprites.drawAllOn(d);
        d.drawText(550, 20, "Level name: " + lvlInfo.levelName(), 15);
        this.sprites.notifyAllTimePassed();
    }

    /**
     * Indicates whether the game animation should stop.
     * @return true or false.
     */
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * Returns the number of the remaining blocks.
     * @return number of the remaining blocks
     */
    public int getRemainingBlocks() {
        return this.remainingBlocks.getValue();
    }

    /**
     * Returns the number of the remaining balls.
     * @return number of the remaining balls
     */
    public int getRemainingBalls() {
        return this.remainingBalls.getValue();
    }

}
