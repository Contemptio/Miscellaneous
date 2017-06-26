package zmk.util;

/**
 * Utility class for runtime management.
 */
public class RunUtil {
    /**
     * Reports an error on {@code stderr} and exits with failure.
     * 
     * @param message
     *            The error message to report.
     */
    public static void error(String message) {
        System.err.println(message);
        System.exit(1);
    }
}
