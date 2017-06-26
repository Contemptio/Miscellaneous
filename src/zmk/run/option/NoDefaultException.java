package zmk.run.option;

import zmk.run.option.type.Option;

/**
 * An {@link OptionException} for options without default values.
 * 
 * @author Zimon
 * @date 2017-06-04
 */
public class NoDefaultException extends OptionException {

    /**
     * Serial ID.
     */
    private static final long serialVersionUID = 5211294076734875752L;

    /**
     * Creates an exception for when a default value for an option does not
     * exist.
     * 
     * @param option
     *            The option for which no default value exists.
     */
    public NoDefaultException(Option<?> option) {
        super(option, "no default exists");
    }

}
