package zmk.exception;

/**
 * {@link Exception} class for managing unimplemented classes and methods.
 * 
 * @author Zimon
 * @date 2017-06-26
 */
public class NotImplementedException extends RuntimeException {

    /**
     * Constructs a {@code NotImplementedException}.
     * 
     * @param classType
     *            The {@link Class} object of the class not yet implemented.
     */
    public NotImplementedException(Class<?> classType) {
        super("Class " + classType.getSimpleName() + " is not implemented yet.");
    }

    /**
     * Constructs a {@code NotImplementedException}.
     * 
     * @param methodName
     *            The name of the method not implemented.
     */
    public NotImplementedException(String methodName) {
        super("Method " + methodName + " is not implemented yet.");
    }

    /**
     * Serial version ID.
     */
    private static final long serialVersionUID = -918126588577705737L;

}
