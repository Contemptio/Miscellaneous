package zmk.run.option.type;

/**
 * Option class representing string options.
 * 
 * @author Zimon
 * @date 2017-02-23
 */
public class DoubleOption extends Option<Double> {

    /**
     * Constructs a string option.
     * 
     * @param name
     *            The name of the option.
     * @param value
     *            The default value of the option.
     * @see Option#Option(String, Object)
     */
    public DoubleOption(String name, double value) {
        super(name, value);
    }

    public boolean isType(double value) {
        return true;
    }

    @Override
    public boolean isType(Double value) {
        return true;
    }

}
