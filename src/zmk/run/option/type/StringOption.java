package zmk.run.option.type;

/**
 * Option class representing string options.
 * 
 * @author Zimon
 * @date 2017-02-23
 */
public class StringOption extends Option<String> {

    /**
     * Constructs a string option.
     * 
     * @param name
     *            The name of the option.
     * @param defaultValue
     *            The default value of the option.
     * @see Option#Option(String, Object)
     */
    public StringOption(String name, String defaultValue) {
        super(name, defaultValue);
    }

    @Override
    public boolean isType(String value) {
        return true;
    }

}
