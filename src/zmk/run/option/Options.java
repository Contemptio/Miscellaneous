package zmk.run.option;

import java.util.List;

import zmk.run.option.type.BooleanOption;
import zmk.run.option.type.DoubleOption;
import zmk.run.option.type.IntegerOption;
import zmk.run.option.type.Option;
import zmk.run.option.type.StringOption;

/**
 * Interface for {@code OptionFactory}s, i.e. program-specific factories that
 * create options.
 * 
 * @author Zimon
 * @date 2017-06-04
 */
interface Options {
    /**
     * Creates an option with its default value, if possible.
     * 
     * @param option
     *            The option name.
     * @return
     *         an {@link Option}.
     * @throws NoDefaultException
     *             if there was any error creating the option.
     */
    Option<?> create(String option) throws NoDefaultException;

    /**
     * Creates an option from a string value.
     * 
     * @param option
     *            The option name.
     * @param value
     *            The option value.
     * @return
     *         an {@link Option}.
     */
    Option<?> create(String option, String value);

    /**
     * Creates an option from a string value.
     * 
     * @param option
     *            The option name.
     * @param values
     *            The option values.
     * @return
     *         an {@link Option}.
     */
    Option<?> create(String option, List<String> values);

    /**
     * Retrieves an option.
     * 
     * @param option
     *            The option name.
     * @return
     *         the option with the name {@code name}.
     */
    Option<?> get(String option);

    public static Option<?> create(String name, Object defaultValue) {
        if (defaultValue instanceof Boolean) {
            return new BooleanOption(name, (boolean) defaultValue);
        } else if (defaultValue instanceof Double) {
            return new DoubleOption(name, (double) defaultValue);
        } else if (defaultValue instanceof Integer) {
            return new IntegerOption(name, (int) defaultValue);
        } else if (defaultValue instanceof String) {
            return new StringOption(name, defaultValue.toString());
        }
        return Option.nullOption();
    }

}
