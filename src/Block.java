import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shira Cohen
 * ID: 209088368
 * This class defines a block.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private java.awt.Color color;
    private List<HitListener> hitListeners = new ArrayList<>();

    /**
     * Constructor.
     * @param rect The rectangle that block is shaped to.
     */
    public Block(Rectangle rect) {
        this.rectangle = rect;
    }

    /**
     * Sets the block's color.
     * @param c The desired color.
     */
    public void setColor(java.awt.Color c) {
        this.color = c;
    }

    /**
     * Returns the shape of the block (the rectangle).
     * @return Returns a rectangle object.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * Notifies the object that we collided with it at collisionPoint with a given velocity.
     * @param hitter The ball that hits the object.
     * @param collisionPoint The collision point.
     * @param currentVelocity The current velocity of the ball.
     * @return Returns the new velocity expected after the hit.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double cPointX = collisionPoint.getX();
        double cPointY = collisionPoint.getY();
        double uLeftX = rectangle.getUpperLeft().getX();
        double uRightX = rectangle.getUpperRight().getX();
        double uRightY = rectangle.getUpperRight().getY();
        double lRightY = rectangle.getLowerRight().getY();
        if ((cPointX == uLeftX || cPointX == uRightX) && cPointY != uRightY && cPointY != lRightY) {
            this.notifyHit(hitter);
            return new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
        }
        if ((cPointY == uRightY || cPointY == lRightY) && cPointX != uLeftX && cPointX != uRightX) {
            this.notifyHit(hitter);
            return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        }
        this.notifyHit(hitter);
        return new Velocity(-currentVelocity.getDx(), -currentVelocity.getDy());
    }

    /**
     * Draws the ball on a given surface.
     * @param d The given surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) rectangle.getUpperLeft().getX(), (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());
    }

    /**
     * We were asked to not implement this method yet.
     */
    public void timePassed() {
        //Not relevant yet.
    }

    /**
     * Adds the block to a Game object.
     * @param g The Game object.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * Removes the block from a Game object.
     * @param game The Game object.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }

    /**
     * This method will be called whenever a hit() occurs,
     * and will notify all of the registered HitListener objects by calling their hitEvent method.
     * @param hitter The ball that hits the block.
     */
    private void notifyHit(Ball hitter) {
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * Adds hl as a listener to hit events.
     * @param hl The hit listener.
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * Removes hl from the list of listeners to hit events.
     * @param hl The hit listener.
     */
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}
