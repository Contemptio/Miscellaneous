package time;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void doReorganize() throws IOException {
        String[] lines =
                new String(Files.readAllBytes(Paths.get("src/pokemon/PokemonTypeChart.csv"))).split("\\s*\n\\s*");
        String[] nameArray = lines[0].split("\\s*[,|;]\\s*");

        lines = Arrays.copyOfRange(lines, 1, lines.length);

        Map<String, Map<String, Double>> map = new HashMap<String, Map<String, Double>>();
        for (String name : nameArray) {
            map.put(name, new HashMap<String, Double>());
        }

        List<String> names = new ArrayList<String>();
        for (int i = 0; i < lines.length - 1; ++i) {
            String[] words = lines[i].split("\\s*[,|;]\\s*");
            String name = words[0];
            names.add(name);
            Map<String, Double> values = map.get(name);

            for (int j = 1; j < words.length; ++j) {
                values.put(nameArray[j], Double.parseDouble(words[j]));
            }
        }

        Collections.<String> sort(names);

        for (String attacker : names) {
            System.out.print(attacker.toUpperCase() + "(");
            String prefix = "";
            Map<String, Double> values = map.get(attacker);
            for (String defender : names) {
                System.out.print(prefix + values.get(defender));
                prefix = ", ";
            }
            System.out.println("),");
        }
    }

    public static void main(String[] args) throws IOException {
        doReorganize();

        System.exit(1);

        double[][] strengths = parseDoubleMatrix(new String(Files.readAllBytes(Paths.get("src/pokemon/types.txt"))));
        String[] names = {
            "BUG", "DARK", "DRAGON", "ELECTRIC", "FAIRY", "FIGHTING", "FIRE", "FLYING", "GHOST", "GRASS", "GROUND",
            "ICE", "NORMAL", "POISON", "PSYCHIC", "ROCK", "STEEL", "WATER",
        };

        int expected = names.length;
        int actual = strengths.length;

        if (expected != actual) {
            throw new UnsupportedOperationException(
                    "Insufficient number of strength entries, expected " + expected + ", got " + actual + ".");
        }

        for (int i = 0; i < expected; ++i) {
            double[] row = strengths[i];
            int length = row.length;

            if (length != expected) {
                throw new UnsupportedOperationException("Insufficient number of strength entries at row " + i
                        + ", expected " + expected + ", got " + actual + ".");
            }

            System.out.println(names[i] + "(" + Arrays.toString(row).replaceAll("[\\[|\\]]", "") + "),");
        }
    }

    public static double[][] parseDoubleMatrix(String string) {
        String[] lines = string.split("\\s*\n\\s*");

        int length = lines.length;

        double[][] entries = new double[length][];
        for (int i = 0; i < length; ++i) {
            String[] numbers = lines[i].split("\\s*,\\s*");
            int n = numbers.length;
            entries[i] = new double[n];
            for (int j = 0; j < n; ++j) {
                entries[i][j] = Double.parseDouble(numbers[j]);
            }
        }
        return entries;
    }
}
