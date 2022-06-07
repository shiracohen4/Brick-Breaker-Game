/**
 * @author Shira Cohen
 * ID: 209088368
 * This class is used for counting things.
 */
public class Counter {
    private int count;

    /**
     * Constructor.
     * @param c The number that is added to the counter during construction.
     */
    public Counter(int c) {
        this.count = c;
    }


    /**
     * Adds number to current count.
     * @param number The number.
     */
    public void increase(int number) {
        this.count += number;
    }

    /**
     * Subtracts number from current count.
     * @param number The number.
     */
    public void decrease(int number) {
        this.count -= number;
    }

    /**
     * Gets current count.
     * @return Returns the current count.
     */
    public int getValue() {
        return this.count;
    }
}
