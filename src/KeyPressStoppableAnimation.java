import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * @author Shira Cohen
 * ID: 209088368
 * A decorator-class that will wrap an existing animation and add a "waiting-for-key" behavior to it.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor kSensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * Constructor.
     * @param sensor KeyboardSensor
     * @param key The key that stops the animation when it is pressed
     * @param animation Animation object
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.kSensor = sensor;
        this.key = key;
        this.animation = animation;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    /**
     * One frame of the animation.
     * @param d the DrawSurface
     */
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (!this.kSensor.isPressed(key)) {
            isAlreadyPressed = false;
        }
        if (this.kSensor.isPressed(key)) {
            if (!isAlreadyPressed) {
                this.stop = true;
            }
        }
    }

    /**
     * Indicates whether the animation should stop.
     * @return true or false.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
