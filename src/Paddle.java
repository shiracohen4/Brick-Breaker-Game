import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * @author Shira Cohen
 * ID: 209088368
 * This class defines a paddle.
 * It is a rectangle that is controlled by the arrow keys, and moves according to the player key presses.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    private java.awt.Color color;
    private int width;
    private int speed;
    private double startX;

    /**
     * Constructor.
     * @param k KeyboardSensor.
     * @param w The paddle width.
     */
    public Paddle(biuoop.KeyboardSensor k, int w) {
        this.keyboard = k;
        this.width = w;
        this.startX = 400 - (w / 2);
        this.rectangle = new Rectangle(new Point(startX, 570), this.width, 10);
    }

    /**
     * Sets the color of the paddle.
     * @param c The given color.
     */
    public void setColor(java.awt.Color c) {
        this.color = c;
    }

    /**
     * Sets the paddle speed.
     * @param s the required speed.
     */
    public void setSpeed(int s) {
        this.speed = s;
    }

    /**
     * Moves the paddle one step to the left.
     */
    public void moveLeft() {
        if (this.rectangle.getUpperLeft().getX() > 0) {
            Point newLoc = new Point(this.rectangle.getUpperLeft().getX() - speed, rectangle.getUpperLeft().getY());
            this.rectangle = new Rectangle(newLoc, this.width, 10);
        }
    }

    /**
     * Moves the paddle one step to the right.
     */
    public void moveRight() {
        if (this.rectangle.getUpperLeft().getX() < (800 - this.width)) {
            Point newLoc = new Point(this.rectangle.getUpperLeft().getX() + speed, rectangle.getUpperLeft().getY());
            this.rectangle = new Rectangle(newLoc, this.width, 10);
        }
    }

    /**
     * Notifies the paddle that time has passed.
     */
    public void timePassed() {
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
    }

    /**
     * Draws the paddle on a given surface.
     * @param d The given surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX() - 2, (int) this.rectangle.getUpperLeft().getY() - 2,
                (int) this.rectangle.getWidth() + 4, (int) this.rectangle.getHeight() + 4);

        d.setColor(this.color);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
    }

    /**
     * The rectangle of the paddle.
     * @return Returns the rectangle object that makes the paddle.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * Notify the paddle that we collided with it at collisionPoint with a given velocity.
     * @param hitter The ball that hits the object.
     * @param collisionPoint The collision point.
     * @param currentVelocity The current velocity of the ball.
     * @return Returns the new velocity expected after the hit.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        if (collisionPoint.getY() == rectangle.getUpperLeft().getY()) {
            double dx = currentVelocity.getDx();
            double dy = currentVelocity.getDy();
            double currentSpeed = Math.sqrt((dx * dx) + (dy * dy));
            double uLeftX = this.rectangle.getUpperLeft().getX();
            double region = this.rectangle.getWidth() / 5;
            if (collisionPoint.getX() >= uLeftX && collisionPoint.getX() < uLeftX + region) {
                return Velocity.fromAngleAndSpeed(300, currentSpeed);
            }
            if (collisionPoint.getX() >= uLeftX + region && collisionPoint.getX() < uLeftX + (2 * region)) {
                return Velocity.fromAngleAndSpeed(330, currentSpeed);
            }
            if (collisionPoint.getX() >= uLeftX + (2 * region) && collisionPoint.getX() < uLeftX + (3 * region)) {
                return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
            }
            if (collisionPoint.getX() >= uLeftX + (3 * region) && collisionPoint.getX() < uLeftX + (4 * region)) {
                return Velocity.fromAngleAndSpeed(30, currentSpeed);
            }
            if (collisionPoint.getX() >= uLeftX + (4 * region) && collisionPoint.getX() <= uLeftX + (5 * region)) {
                return Velocity.fromAngleAndSpeed(60, currentSpeed);
            }
        }
        double cPointX = collisionPoint.getX();
        double cPointY = collisionPoint.getY();
        double uLeftX = rectangle.getUpperLeft().getX();
        double uRightX = rectangle.getUpperRight().getX();
        double uRightY = rectangle.getUpperRight().getY();
        double lRightY = rectangle.getLowerRight().getY();
        if ((cPointX == uLeftX || cPointX == uRightX) && cPointY != uRightY && cPointY != lRightY) {
            return new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());
        }
        if ((cPointY == uRightY || cPointY == lRightY) && cPointX != uLeftX && cPointX != uRightX) {
            return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        }
        return new Velocity(-currentVelocity.getDx(), -currentVelocity.getDy());
    }

    /**
     * Adds this paddle to the game.
     * @param g The given game object.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}
