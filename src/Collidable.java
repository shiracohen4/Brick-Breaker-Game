/**
 * @author Shira Cohen
 * ID: 209088368
 * This interface will be used by collidable objects.
 */
public interface Collidable {

    /**
     * The "collision shape" of the object.
     * @return Returns the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     * @param hitter The ball that hits the object.
     * @param collisionPoint The collision point.
     * @param currentVelocity The current velocity of the ball.
     * @return Returns the new velocity expected after the hit.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}