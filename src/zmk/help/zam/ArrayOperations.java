package zmk.help.zam;

import java.util.HashSet;
import java.util.Set;

/**
 * Auxiliary array methods.
 * 
 * @author Zimon Kuhs
 * @date 2017-05-22
 */
public class ArrayOperations {

    /**
     * Reverses an array.
     * 
     * @param array
     *            The array to reverse.
     * @return
     *         {@code array} with the elements in reverse order.
     */
    public static double[] reverse(double[] array) {

        return array;
    }

    /**
     * Retrieves the positive numbers in an array.
     * 
     * @param array
     *            The array from which to retrieve positive numbers.
     * @return
     *         an array of the positive numbers in {@code array}.
     */
    public static double[] positives(double[] array) {

        return array;
    }

    /**
     * Retrieves every second element from an array.
     * 
     * @param array
     *            The array from which to retrieve every second element.
     * @return
     *         an array containing every second element from {@code array}.
     */
    public static double[] everySecond(double[] array) {

        return array;
    }

    /**
     * Tests the operations described in this class.
     * 
     * @param args
     *            this program's arguments do nothing.
     */
    public static void main(String[] args) {
        boolean correct = true;
        double[] array = {
            -4, 3, -2, 1, 0
        };
        int length = array.length;

        StringBuilder errorMessage = new StringBuilder("Incorrect methods:\n");
        double[] reversed = reverse(array);

        if (reversed.length == length) {
            for (int i = 0; i < array.length; ++i) {
                if (reversed[i] != ((int) (i * Math.pow(-1, i + 1)))) {
                    correct = false;
                    errorMessage.append("\treversed: " + reversed + "\n");
                    break;
                }
            }
        } else {
            correct = false;
            errorMessage.append("\treversed: " + reversed + "\n");
        }
        Set<Double> positives = new HashSet<Double>();
        for (Double d : array) {
            if (d >= 0) {
                positives.add(d);
            }
        }
        double[] positiveArray = positives(array);
        for (int i = 0; i < positiveArray.length; ++i) {
            double number = positiveArray[i];
            if (number >= 0 && !positives.contains(number) || number < 0 && positives.contains(number)) {
                correct = false;
                errorMessage.append("\tpositives: " + positiveArray);
                break;
            }
        }

        double[] everySecond = everySecond(array);
        if (everySecond.length != (length + 1) / 2) {
            correct = false;
            errorMessage.append("\teverySecond: " + everySecond);
        } else {
            for (int i = 0; i < everySecond.length; ++i) {
                if (everySecond[i] != everySecond[i * 2]) {
                    correct = false;
                    errorMessage.append("\teverySecond: " + everySecond);
                    break;
                }
            }
        }
        if (correct) {
            System.out.println("Nice!");
        } else {
            System.out.println(errorMessage.toString());
        }
    }
}