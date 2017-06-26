package zmk.run.option.type;

/**
 * Option class representing string options.
 * 
 * @author Zimon
 * @date 2017-02-23
 */
public class BooleanOption extends Option<Boolean> {

    /**
     * Constructs a string option.
     * 
     * @param name
     *            The name of the option.
     * @param defaultValue
     *            The default value of the option.
     * @see Option#Option(String, Object)
     */
    @SuppressWarnings("boxing")
    BooleanOption(String name, boolean defaultValue) {
        super(name, defaultValue);
    }
    
    /**
     * Constructs a string option.
     * 
     * @param name
     *            The name of the option.
     * @param defaultValue
     *            The default value of the option.
     * @see Option#Option(String, Object)
     */
    BooleanOption(String name, Boolean defaultValue) {
        super(name, defaultValue);
    }

    @Override
    public boolean isType(Boolean value) {
        return true;
    }
}
