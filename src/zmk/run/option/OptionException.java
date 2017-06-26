package zmk.run.option;

import zmk.run.option.type.Option;

/**
 * Class representing exceptions related to {@link Option}s.
 * 
 * @author Zimon
 *
 */
public class OptionException extends RuntimeException {

    /**
     * Serial ID.
     */
    private static final long serialVersionUID = -3508501461486551964L;

    /**
     * Creates a generic option error for an option.
     * 
     * @param option
     *            The option for which to create an exception.
     */
    public OptionException(Option<?> option) {
        this(option, "unknown error");
    }

    /**
     * Creates an option error for an option.
     * 
     * @param option
     *            The option for which to create an exception.
     * @param message
     *            The exception message.
     */
    public OptionException(Option<?> option, String message) {
        super("Option error for " + option.name() + ": " + message + ".");
    }
}
