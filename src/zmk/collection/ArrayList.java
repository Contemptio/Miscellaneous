package zmk.collection;

/**
 * Extension of {@link java.util.ArrayList}.
 * 
 * @author Zimon Kuhs
 *
 * @param <T>
 *            The type of element in the list.
 */
public class ArrayList<T> extends java.util.ArrayList<T> {
    /**
     * Serialization identifier.
     */
    private static final long serialVersionUID = -5210454915332732003L;

    /**
     * Constructs a new {@link List} using zero or more elements.
     * 
     * @param elements
     *            The elements initially in this list.
     */
    @SafeVarargs
    public ArrayList(T... elements) {
        super();
        for (T t : elements) {
            add(t);
        }
    }
}
