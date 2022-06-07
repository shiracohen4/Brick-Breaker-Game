import biuoop.DrawSurface;
import java.awt.Color;
/**
 * @author Shira Cohen
 * ID: 209088368
 * This class defines a ball, which is essentially a circle of a certain size, color, location and speed.
 */
public class Ball implements Sprite {
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;

    /**
     * Constructor.
     * @param center The center point of the ball.
     * @param r The radius (size) of the ball.
     * @param color The color of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
    }

    /**
     * 2nd constructor.
     * @param x The x value of the center point of the ball.
     * @param y The y value of the center point of the ball.
     * @param r The radius (size) of the ball.
     * @param color The color of the ball.
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
    }

    /**
     * Returns x value of center.
     * @return Returns the x value of the center point of this ball.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * Returns y value of center.
     * @return Returns the y value of the center point of this ball.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Returns the size of the ball.
     * @return Returns the radius of this ball.
     */
    public int getSize() {
        return this.r;
    }

    /**
     * Returns the color.
     * @return Returns the color of this ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * Draws this ball on a given surface.
     * @param surface The given surface.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.BLACK);
        surface.fillCircle(getX(), getY(), getSize() + 1);
        surface.setColor(getColor());
        surface.fillCircle(getX(), getY(), getSize());
    }

    /**
     * Sets the ball's speed.
     * @param v The velocity that is set to the ball.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * Another way to set the ball's speed.
     * @param dx The ball's movement on the x axis.
     * @param dy The ball's movement on the y axis.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * Sets the ball's GameEnvironment.
     * @param game The GameEnvironment object the ball needs to be aware of.
     */
    public void setGameEnvironment(GameEnvironment game) {
        this.gameEnvironment = game;
    }

    /**
     * Returns this ball's speed.
     * @return Returns this ball's velocity.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * Moves the ball one step according to its velocity.
     * If the ball hits a collidable object, change its velocity accordingly.
     */
    public void moveOneStep() {
        Line trajectory = new Line(this.center, this.velocity.applyToPoint(this.center));
        if (this.gameEnvironment.getClosestCollision(trajectory) == null) {
            this.center = this.velocity.applyToPoint(this.center);
        } else {
            Point collision = this.gameEnvironment.getClosestCollision(trajectory).collisionPoint();
            Velocity newV;
            double delta = this.center.distance(collision) * 0.5;
            if (gameEnvironment.getClosestCollision(trajectory).isOnUpperSide()) {
                this.center = new Point(collision.getX(), collision.getY() - delta);
            } else if (gameEnvironment.getClosestCollision(trajectory).isOnLowerSide()) {
                this.center = new Point(collision.getX(), collision.getY() + delta);
            } else if (gameEnvironment.getClosestCollision(trajectory).isOnLeftSide()) {
                this.center = new Point(collision.getX() - delta, collision.getY());
            } else if (gameEnvironment.getClosestCollision(trajectory).isOnRightSide()) {
                this.center = new Point(collision.getX() + delta, collision.getY());
            }
            newV = this.gameEnvironment.getClosestCollision(trajectory).collisionObject().hit(this, collision,
                    this.velocity);
            this.setVelocity(newV);
        }
    }

    /**
     * Moves the ball one step according to its velocity.
     * If the ball hits a certain frame, change its velocity.
     * Differently to the previous method, this one gets the frame borders as parameters.
     * @param xLeftLim The left border.
     * @param xRightLim The right border.
     * @param yUpperLim The upper border.
     * @param yLowerLim The lower border.
     */
    public void moveOneStepInFrame(int xLeftLim, int xRightLim, int yUpperLim, int yLowerLim) {
        if (this.center.getX() + this.r >= xRightLim) {
            if (getVelocity().getDx() > 0) {
                this.setVelocity(-getVelocity().getDx(), getVelocity().getDy());
            }
        }
        if (this.center.getX() - this.r <= xLeftLim) {
            if (getVelocity().getDx() < 0) {
                this.setVelocity(-getVelocity().getDx(), getVelocity().getDy());
            }
        }
        if (this.center.getY() + this.r >= yLowerLim) {
            if (getVelocity().getDy() > 0) {
                this.setVelocity(getVelocity().getDx(), -getVelocity().getDy());
            }
        }
        if (this.center.getY() - this.r <= yUpperLim) {
            if (getVelocity().getDy() < 0) {
                this.setVelocity(getVelocity().getDx(), -getVelocity().getDy());
            }
        }

        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * Moves the ball one step.
     */
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * Adds the ball to a Game object.
     * @param g The Game object.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Removes the ball from a Game object.
     * @param game The Game object.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}
