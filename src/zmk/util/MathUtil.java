package zmk.util;

/**
 * Utility class for static mathematical functions.
 * 
 * @author Zimon Kuhs
 * @date 2017-03-21
 */
public class MathUtil {

    /**
     * Returns the product sum of all numbers.
     * 
     * @param start
     *            The index at which to start multiplication from.
     * @param end
     *            The index of the first number not to include in the
     *            multiplication.
     * @param factors
     *            The numbers.
     * @return
     *         the product sum of all the numbers.
     */
    public static double productSum(int start, int end, double... factors) {
        double result = 1.0;
        for (int i = start; i < Math.min(end, factors.length); ++i) {
            result *= factors[i];
        }
        return result;
    }

    /**
     * Returns the product sum of all numbers.
     * 
     * @param start
     *            The index at which to start multiplication from.
     * @param end
     *            The index of the first number not to include in the
     *            multiplication.
     * @param factors
     *            The numbers.
     * @return
     *         the product sum of all the numbers.
     */
    public static int productSum(int start, int end, int... factors) {
        int result = 1;
        for (int i = start; i < Math.min(end, factors.length); ++i) {
            result *= factors[i];
        }
        return result;
    }

    /**
     * Wrapper for {@link #productSum(int, int, double...)} including all
     * numbers.
     * 
     * @param factors
     *            The numbers.
     * @return
     *         the product sum of all the numbers.
     */
    public static double productSum(double... factors) {
        return productSum(0, factors.length, factors);
    }

    /**
     * Wrapper for {@link #productSum(int, int, int...)} including all numbers.
     * 
     * @param factors
     *            The numbers.
     * @return
     *         the product sum of all the numbers.
     */
    public static int productSum(int... factors) {
        return productSum(0, factors.length, factors);
    }
}
