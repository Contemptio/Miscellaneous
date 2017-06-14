package time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class representing a work day (a tuple of times, start and end).
 */
public class WorkDay {
    private Time start;
    private Time end;

    /**
     * Creates a work day, a tuple of times, start and end times.
     * 
     * @param start
     *            The start time.
     * @param end
     *            The end time.
     */
    public WorkDay(String start, String end) {
        this(new Time(start), new Time(end));
    }

    /**
     * Creates a work day, a tuple of times, start and end times.
     * 
     * @param start
     *            The start time.
     * @param end
     *            The end time.
     */
    public WorkDay(Time start, Time end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Return the value to entry into a time logging program (real number).
     * 
     * @return
     *         the real representation of the work time.
     */
    public double hours() {
        return end.sub(start).hours();
    }

    /**
     * Converts an array of time strings to a list of days.
     * 
     * @param strings
     *            The array of time strings.
     * @return
     *         a list of days.
     */
    public static List<WorkDay> toDays(String... strings) {
        int length = strings.length;
        if (length % 2 != 0) {
            throw new IllegalArgumentException("Odd number of times (" + length + "): " + Arrays.toString(strings));
        }

        List<WorkDay> days = new ArrayList<WorkDay>();
        for (int i = 0; i + 1 < length; ++i) {
            days.add(new WorkDay(strings[i], strings[i + 1]));
        }
        return days;
    }

    /**
     * Converts an array of start and end times to a list of days.
     * 
     * @param starts
     *            The array of start time strings.
     * @param ends
     *            The array of end time strings.
     * @return
     *         a list of days.
     */
    public static List<WorkDay> toDays(String[] starts, String[] ends) {
        int startLength = starts.length;
        int endLength = ends.length;

        if (startLength != endLength) {
            throw new IllegalArgumentException("Non-equal number of start and end times (" + startLength + ", "
                    + endLength + "):\n\t" + Arrays.toString(starts) + "\n\t" + Arrays.toString(ends));
        }

        List<WorkDay> days = new ArrayList<WorkDay>();
        for (int i = 0; i < startLength; ++i) {
            days.add(new WorkDay(starts[i], ends[i]));
        }
        return days;
    }

    /**
     * Adds together the total time of work days.
     * 
     * @param times
     *            The times to add together.
     * @return
     *         the time of {@code times} added together as hours.
     */
    public static double totalTime(List<WorkDay> times) {
        double total = 0.0;
        for (WorkDay day : times) {
            total += day.hours();
        }
        return total;
    }

    @Override
    public String toString() {
        return start + " - " + end;
    }

    /**
     * Adds together the total time of work days.
     * 
     * @param times
     *            The times to add together.
     * @return
     *         the time of {@code times} added together as hours.
     */
    public static List<Double> totalTimes(List<WorkDay> times) {
        List<Double> totals = new ArrayList<Double>(times.size());
        for (WorkDay day : times) {
            totals.add(day.hours());
        }
        return totals;
    }

    /**
     * Adds together the total time of work days.
     * 
     * @param times
     *            The times to add together.
     * @param modifiers
     *            The time modifiers to add to the days.
     * @return
     *         the time of {@code times} added together as hours.
     */
    public static List<Double> totalTimes(List<WorkDay> times, List<Double> modifiers) {
        int length = times.size();

        List<Double> totals = new ArrayList<Double>(length);
        for (int i = 0; i < length; ++i) {
            totals.add(times.get(i).hours());
        }
        for (int i = 0; i < Math.min(length, modifiers.size()); ++i) {
            totals.set(i, totals.get(i) + modifiers.get(i));
        }
        return totals;
    }
}
