package util;

/**
 * Utility class for integral operations.
 * 
 * @author Zimon Kuhs
 * @date 2017-03-21
 */
public class IntegerUtil {

    /**
     * Converts a string array to an integer array.
     * 
     * @param strings
     *            The string objects which integers to parse.
     * @return
     *         an integer array of the parsed strings.
     */
    public static int[] parseInteger(String[] strings) {
        int length = strings.length;
        int[] integers = new int[length];
        for (int i = 0; i < length; ++i) {
            integers[i] = Integer.parseInt(strings[i]);
        }
        return integers;
    }

}
