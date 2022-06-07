/**
 * @author Shira Cohen
 * ID: 209088368
 * Objects that implement this interface send notifications when they are being hit.
 */
public interface HitNotifier {

    /**
     * Add hl as a listener to hit events.
     * @param hl The hit listener.
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hl from the list of listeners to hit events.
     * @param hl The hit listener.
     */
    void removeHitListener(HitListener hl);
}
