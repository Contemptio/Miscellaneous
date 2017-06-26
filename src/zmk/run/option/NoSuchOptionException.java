package zmk.run.option;

import zmk.run.option.type.Option;
import zmk.run.option.type.StringOption;

/**
 * Exception class for missing options.
 * 
 * @author Zimon
 * @date 2017-06-04
 */
public class NoSuchOptionException extends OptionException {
    /**
     * Serial ID.
     */
    private static final long serialVersionUID = 2756002152689341147L;
    private static final Option<?> NO_OPTION = new StringOption("no such option", "");

    /**
     * Creates an exception for missing options.
     * 
     * @param name
     *            The name of the sought option.
     */
    public NoSuchOptionException(String name) {
        super(NO_OPTION);
    }
}
