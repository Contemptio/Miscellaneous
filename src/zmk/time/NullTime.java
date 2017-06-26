package zmk.time;

/**
 * {@code null} object for the {@link Time} class.
 * 
 * @author Zimon Kuhs
 * @date 2017-03-22
 */
public class NullTime extends Time {
    private static final Time instance = new NullTime();

    /**
     * Hide the default constructor to realize the singleton pattern.
     */
    private NullTime() {
        super(0);
    }

    /**
     * Returns the singleton instance of this object.
     * 
     * @return
     *         the singleton instance of this object.
     */
    public static Time instance() {
        return instance;
    }

    @Override
    public boolean isNull() {
        return true;
    }
}
