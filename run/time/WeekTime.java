package time;

import java.util.Arrays;
import java.util.List;

/**
 * Calculates the hours spent working for each day of a week.
 */
public class WeekTime {
    private static String[] lunches = {
        "00:30", "00:30", "00:45", "00:30", "00:30"
    };
    private static String[] starts = {
        "08:20", "07:20", "07:20", "07:20", "07:20"
    };
    private static String[] ends = {
        "15:35", "15:50", "15:35", "15:35", "15:35"
    };

    private static List<WorkDay> times = WorkDay.toDays(starts, ends);
    private static List<Double> totals = WorkDay.totalTimes(times, Arrays.asList(Time.asHours(lunches)));
    private static double total = WorkDay.totalTime(times);

    /**
     * Runs this program.
     * 
     * @param args
     *            Expected arguments: none.
     */
    public static void main(String[] args) {
        say(times);
        say(totals);
        say("Total time: " + total + ".");
    }

    /**
     * Short-hand method for printing to {@code stdout}.
     * 
     * @param message
     *            the object to print.
     */
    private static void say(Object message) {
        System.out.println(message);
    }
}
