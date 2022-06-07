/**
 * @author Shira Cohen
 * ID: 209088368
 * A BallRemover is in charge of removing balls from the game when they hit the bottom of the screen.
 * It is also keeping count of the number of balls that remain.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * Constructor.
     * @param game The Game object.
     * @param remainingBalls Counts the remaining balls.
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }

    /**
     * When a ball hits the bottom of the screen, it is removed from the game.
     * In addition, the ball counter is being updated.
     * @param beingHit The block at the bottom of the screen that is being hit by the ball.
     * @param hitter The ball that hits the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }
}
