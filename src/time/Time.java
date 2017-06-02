package time;

import interfaces.NullObject;
import util.IntegerUtil;
import util.MathUtil;
import util.RunUtil;

/**
 * A class representing time units.
 * 
 * @author Zimon Kuhs
 * @date 2017-03-21
 */
public class Time implements Comparable<Time>, NullObject {
    /**
     * Milliseconds per second.
     */
    public static final int MS_PER_SEC = 1000;

    /**
     * Seconds per minute.
     */
    public static final int SEC_PER_MIN = 60;

    /**
     * Minutes per hour.
     */
    public static final int MIN_PER_HOUR = 60;

    /**
     * Hours per day.
     */
    public static final int HOURS_PER_DAY = 24;

    private static final int[] constants = {
        SEC_PER_MIN, MIN_PER_HOUR, HOURS_PER_DAY
    };

    private int days;
    private int hours;
    private int minutes;
    private int seconds;
    private int milliseconds;
    private long ms;

    /**
     * Constructs a {@link Time} object from milliseconds.
     * 
     * @param milliseconds
     *            The number of milliseconds for this {@link Time} object.
     */
    public Time(long milliseconds) {
        this.ms = milliseconds;
    }

    /**
     * Constructs a {@link Time} object from several units.
     * <p>
     * The expected ordering is:
     * <ol>
     * <li>Hours.</li>
     * <li>Minutes.</li>
     * <li>Seconds.</li>
     * <li>Milliseconds.</li>
     * </ol>
     * 
     * @param times
     *            The time units.
     */
    public Time(int... times) {
        int[] actual = new int[4];

        for (int i = 0; i < times.length; ++i) {
            actual[i] = times[i];
        }
        this.hours = actual[0];
        this.minutes = actual[1];
        this.seconds = actual[2];
        this.milliseconds = actual[3];

        ms = milliseconds + MS_PER_SEC * (seconds + SEC_PER_MIN * (minutes + MIN_PER_HOUR * hours));
    }

    /**
     * Constructs a {@link Time} object from a string format.
     * <p>
     * The delimiter used is ':', and the expected ordering is the same as for
     * {@link #Time(int...)}.
     * 
     * @param string
     *            The string from which to get the time units. Units are
     *            expected to be separated by ':'.
     */
    public Time(String string) {
        this(IntegerUtil.parseInteger(string.split(":")));
    }

    /**
     * Adds time to this object using another {@link Time} object.
     * 
     * @param other
     *            The other {@link Time} object.
     * @return
     *         a new {@link Time} object with {@code this}' time and
     *         {@code other}'s time added together.
     */
    public Time add(Time other) {
        return new Time(ms + other.ms);
    }

    /**
     * Subtracts time from this object using another {@link Time} object.
     * 
     * @param other
     *            The other {@link Time} object.
     * @return
     *         a new {@link Time} object with {@code other}'s time subtracted
     *         from {@code this}' time.
     */
    public Time sub(Time other) {
        return new Time(ms - other.ms);
    }

    /**
     * Divides this time with another {@link Time} object.
     * <p>
     * Make sense of it yourself.
     * 
     * @param other
     *            The other {@link Time} object.
     * @return
     *         a new {@link Time} object with {@code this}' time multiplied by
     *         the other {@link Time} object.
     */
    public Time mul(Time other) {
        return new Time(ms * other.ms);
    }

    /**
     * Divides this time with another {@link Time} object.
     * <p>
     * Make sense of it yourself.
     * 
     * @param other
     *            The other {@link Time} object.
     * @return
     *         a new {@link Time} object with {@code this}' time divided by the
     *         other {@link Time} object.
     */
    public Time div(Time other) {
        return new Time(ms / other.ms);
    }

    /**
     * Retrieves the total number of milliseconds this {@link Time} object
     * represents.
     * 
     * @return
     *         the number of milliseconds represented by this object.
     */
    public long millis() {
        return ms;
    }

    /**
     * Update method for calculating the new time units from {@link #ms}.
     */
    @SuppressWarnings("unused")
    private void convert() {
        long millis = ms;
        int fac = MathUtil.productSum(constants);
        int segments = constants.length;
        int[] result = new int[segments];

        for (int i = 0; i < segments; ++i) {
            result[i] = (int) millis / fac;
            millis %= fac;
            fac /= constants[i];
        }

        this.days = result[0];
        this.hours = result[1];
        this.minutes = result[2];
        this.seconds = result[3];
        this.milliseconds = result[4];
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public int compareTo(Time other) {
        return (int) (ms - other.ms);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Time)) {
            return false;
        }
        return compareTo((Time) other) == 0;
    }

    @Override
    public String toString() {
        return (days > 0 ? days + ";" : "") + hours + ":" + minutes + ":" + seconds + ":" + milliseconds;
    }

    /**
     * Constructs a negated {@link Time} object.
     * 
     * @return
     *         a negated version of {@code this} {@link Time} object.
     */
    public Time negate() {
        return new Time(-ms);
    }

    /**
     * Testing the {@link Time} class.
     * 
     * @param args
     *            Program arguments.
     */
    public static void main(String[] args) {
        if (args.length < 3) {
            RunUtil.error("Usage: <time> <operator> <time>");
        }
        Time t1 = new Time(args[0]);
        Time t2 = new Time(args[2]);
        String operator = args[1];
        Time result = null;
        switch (operator) {
        case "+":
            result = t1.add(t2);
            break;
        case "-":
            result = t1.sub(t2);
            break;
        case "*":
            result = t1.mul(t2);
            break;
        case "/":
            result = t1.div(t2);
            break;
        default:
            throw new IllegalArgumentException("No such operator " + args[1] + ".");
        }
        System.out.println(result);
    }

}
