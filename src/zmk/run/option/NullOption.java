package zmk.run.option;

import zmk.run.option.type.Option;

/**
 * Null object class for {@link Option}.
 * 
 * @author Zimon
 * @date 2017-06-03
 */
public final class NullOption extends Option<Object> {
    private static final Option<?> instance = new NullOption();

    /**
     * Instantiates the {@link Option} null object.
     */
    private NullOption() {
        super("NULL");
    }

    /**
     * Retrieves the singleton instance of the null object.
     * 
     * @return the singleton instance of the null object.
     */
    public static final Option<?> instance() {
        return instance;
    }

    @Override
    public boolean isNull() {
        return true;
    }
}
