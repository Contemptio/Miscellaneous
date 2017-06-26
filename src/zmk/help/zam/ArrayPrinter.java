package zmk.help.zam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Prints the sum of an array.
 * 
 * @author Zamuel Kuhs, Zimon Kuhs
 * @date 2017-05-18
 */
public class ArrayPrinter {

    /**
     * Reads input from the user until it answers {@code j/J} or it inputs more
     * than 20 numbers, or anything other than a number, at which point the
     * program crashes.
     * 
     * @param args
     *            Expected arguments: none.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char svar = '\0';
        List<Double> numbers = new ArrayList<Double>();
        int i = 0;

        System.out.print("Mata in ett antal tal:");

        do {
            System.out.println("(" + (i + 1) + ") " + "Mata in ett tal: ");

            numbers.add(input.nextDouble());

            System.out.print("\nVill du fortsätta (j/J)? ");
            svar = input.next().charAt(0);
        } while (svar == 'j' || svar == 'J');

        System.out.println("Totalt:\t" + numbers + ".");
        input.close();

    }

    /**
     * Builds a string explaining the summarisation of the elements of a real
     * array.
     * 
     * @param array
     *            The array to summarise.
     * @return
     *         a string showing the summarisation of all the operands in the
     *         array.
     */
    private static String sumString(double[] array) {
        StringBuilder message = new StringBuilder("[");
        String prefix = "";

        double sum = 0.0;
        for (int i = 0; i < array.length; ++i) {
            message.append(prefix + array[i]);
            prefix = " + ";
        }

        return message.append("] = " + sum + ".").toString();
    }
}