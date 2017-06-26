package zmk.run.option.type;

/**
 * Option class representing string options.
 * 
 * @author Zimon
 * @date 2017-02-23
 */
public class IntegerOption extends Option<Integer> {

    /**
     * Constructs a string option.
     * 
     * @param name
     *            The name of the option.
     * @param value
     *            The default value of the option.
     * @see Option#Option(String, Object)
     */
    public IntegerOption(String name, int value) {
        super(name, value);
    }

    public boolean isType(int value) {
        return true;
    }

    @Override
    public boolean isType(Integer value) {
        return true;
    }

}
