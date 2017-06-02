package time;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import util.IntegerUtil;

/**
 * Test class for the {@link time#Time} class.
 * 
 * @author Zimon Kuhs
 * @date 2017-03-22
 */
public class TimeTest {
    /**
     * Fetched approximately 2017-03-22 06:27.
     */
    private static final long NOW = 0 + (0 + (27 + (6 * 60)) * 60) * 1000;
    private static final String NOW_STR = "06:27:00:00";

    /**
     * Tests all constructors:
     * <ul>
     * <li>{@link Time#Time(int...)}</li>
     * <li>{@link Time#Time(long)}</li>
     * <li>{@link Time#Time(string)}</li>
     * </ul>
     * <p>
     * The t
     */
    @Test
    public void constructors() {
        assertEquals("Wrong time for object.", NOW, new Time(NOW).millis());
        assertEquals("Wrong time for object.", NOW, new Time(NOW_STR).millis());
        assertEquals("Wrong time for object.", NOW, new Time(IntegerUtil.parseInteger(NOW_STR.split(":"))).millis());
    }

    /**
     * Tests {@link Time#compareTo(Time)} and {@link Time#equals(Object)}.
     */
    @Test
    public void identity() {
        assertEquals("Objects should be compared by time, not reference.", new Time(0), new Time(0));

        Time early = new Time(0);
        Time late = new Time(1);

        assertTrue("Later time should be greater than earlier time.", early.compareTo(late) < 0);
        assertEquals("Opposite comparison should yield a negated result.", early.compareTo(late),
                -late.compareTo(early));
    }

    /**
     * Tests {@link Time#add(Time)}.
     */
    @Test
    public void add() {
        Time first = new Time(1);
        Time second = new Time(2);
        Time sum = new Time(1 + 2);

        assertEquals("Adding two times together should produce a time representing the milliseconds added together.",
                first.add(second), sum);
        assertEquals("Addition should be associative.", first.add(second), second.add(first));
    }

    /**
     * Tests {@link Time#sub(Time)}.
     */
    @Test
    public void sub() {
        Time first = new Time(1);
        Time second = new Time(2);
        Time sum = new Time(1 + 2);

        assertEquals("Subtracting one time from another time representing the subtraction of milliseconds.",
                first.sub(second), sum);
        assertEquals("Subtraction should not be associative; reversing operands should negate the result.",
                first.sub(second), second.sub(first).negate());
    }

    /**
     * Tests {@link Time#toString()}.
     */
    @Test
    public void string() {
        assertEquals("String representation is incorrect.", "00:00:00:00", new Time(NOW).toString());
        assertEquals("String representation is incorrect.", NOW_STR, new Time(NOW_STR).toString());
        assertEquals("String representation is incorrect.", "00:00:00",
                new Time(IntegerUtil.parseInteger(NOW_STR.split(":"))).toString());
    }
}
