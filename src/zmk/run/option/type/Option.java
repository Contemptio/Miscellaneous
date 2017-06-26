package zmk.run.option.type;

import zmk.run.option.NullOption;
import zmk.run.option.OptionSpecification;

/**
 * Class representing program options.
 * 
 * @author Zimon
 * @date 2017-02-23
 * @param <T>
 *            The type of option value.
 */
public abstract class Option<T> {
    protected String name;
    protected final T defaultValue;
    protected T value;

    /**
     * Creates an option without a default value.
     * 
     * @param name
     *            The name of the option.
     */
    protected Option(String name) {
        this(name, null);
    }

    /**
     * Creates an {@link Option} object.
     * 
     * @param name
     *            The name of the option.
     * @param defaultValue
     *            The default value of the option.
     */
    protected Option(String name, T defaultValue) {
        this.name = name;
        this.value = (this.defaultValue = defaultValue);
    }

    /**
     * Sets this option to a new value.
     * 
     * @param value
     *            The value to set this option to.
     */
    public final void setValue(T value) {
        this.value = value;
    }

    /**
     * Checks whether or not this option's value is of a certain type.
     * <p>
     * This method is expected to be overridden by extending subclasses that
     * match the option's type. E.g., for an integer option (typically
     * {@code IntegerOption}), {@code #isType(Integer)} would return
     * true.
     * 
     * @param value
     *            An object of the type to check if this option is of.
     * @return
     *         {@code true} if this option is of the same type as {@code value},
     *         {@code false} otherwise.
     */
    public boolean isType(T value) {
        return false;
    }

    /**
     * Checks whether this {@link Option}'s type is the same as
     * {@code classType}.
     * 
     * @param classType
     *            The option type to check if this option is of.
     * @return
     *         {@code true} if this option is of the same type as
     *         {@code classType}, {@code false} otherwise.
     */
    public final boolean isType(Class<T> classType) {
        return classType.equals(value.getClass());
    }

    /**
     * Retrieves the default value of this option.
     * 
     * @return
     *         the default value of this option.
     */
    public final T defaultValue() {
        return defaultValue;
    }

    /**
     * Retrieves the name of the option.
     * 
     * @return
     *         the name of the option.
     */
    public final String name() {
        return name;
    }

    /**
     * Retrieves the value of this option.
     * 
     * @return
     *         the value of this option.
     */
    public final T value() {
        return value;
    }

    /**
     * Checks whether or not {@code this} instance is a null object.
     * 
     * @return {@code true} if {@code this} is an instance of
     *         {@link NullOption}, {@code false} otherwise.
     */
    public boolean isNull() {
        return false;
    }

    @Override
    public final String toString() {
        return name + "(" + defaultValue.getClass().getSimpleName() + ": " + defaultValue + "):\t" + value + ".";
    }

    public static Option<?>[] create(OptionSpecification[] values) {
        // TODO Auto-generated method stub
        return null;
    }

    public static Option<?> create(String name, Object value) {
        if (value instanceof Boolean) {
            return new BooleanOption(name, (boolean) value);
        } else if (value instanceof Double) {
            return new DoubleOption(name, (double) value);
        } else if (value instanceof Integer) {
            return new IntegerOption(name, (int) value);
        } else if (value instanceof String) {
            return new StringOption(name, (String) value);
        }
        throw new IllegalArgumentException(
                "Expected primitive type, got " + value + " of class " + value.getClass().getSimpleName());
    }
}
