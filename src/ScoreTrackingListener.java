/**
 * @author Shira Cohen
 * ID: 209088368
 * ScoreTrackingListener updates the score counter when blocks are being hit and removed.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * Constructor.
     * @param scoreCounter The score counter that will be updated.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * Adds 5 points to the score counter every time a block is being hit.
     * @param beingHit The object that is being hit.
     * @param hitter The Ball that's doing the hitting.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
       this.currentScore.increase(5);
    }
}
