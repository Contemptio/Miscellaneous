package zmk.run;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Class for representing options to a program.
 * 
 * @author Zimon
 * @date 2017-04-15
 */
public final class Arguments {
    private Map<String, List<String>> options;

    /**
     * Hidden default constructor.
     */
    private Arguments() {
        this.options = new LinkedHashMap<String, List<String>>();
    }

    /**
     * Creates an {@code Argument} object from a string array.
     * 
     * @param args
     *            The string array of arguments.
     */
    public Arguments(String[] args) {
        this();
        parseOptions(args);
    }

    /**
     * Parses options from a string array of arguments.
     * 
     * @param args
     *            The string array of arguments.
     */
    private void parseOptions(String[] args) {
        List<String> currentValues = new ArrayList<String>();
        String currentOption = null;

        for (int i = 0; i < args.length; ++i) {
            String[] opt = args[i].split("-|--");
            int length = opt.length;

            if (length <= 1) {
                currentValues.add(opt[0]);
            } else if (length > 2) {
                throw new IllegalArgumentException("Badly formatted option: " + args[i] + ".");
            } else {
                if (currentValues.size() > 0) {
                    if (currentOption == null) {
                        throw new IllegalArgumentException(
                                "No option specified before value(s): " + currentValues + ".");
                    }
                    options.put(currentOption, new ArrayList<String>(currentValues));
                }
                currentOption = opt[1];
            }
        }
    }

    /**
     * Retrieves the values set for an option.
     * 
     * @param optionName
     *            The name of the option for which to retrieve values.
     * @return
     *         a {@link List} of the option {@code optionName}'s values.
     */
    public List<String> get(String optionName) {
        if (!options.containsKey(optionName)) {
            throw new IllegalArgumentException("No such option among arguments: " + optionName + ".");
        }
        return options.get(optionName);
    }
}
