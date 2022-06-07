/**
 * @author Shira Cohen
 * ID: 209088368
 * Objects that want to be notified of hit events, should implement this interface.
 */
public interface HitListener {

    /**
     * This method is called whenever the beingHit object is hit.
     * @param beingHit The object that is being hit.
     * @param hitter The Ball that's doing the hitting.
     */
    void hitEvent(Block beingHit, Ball hitter);
}

