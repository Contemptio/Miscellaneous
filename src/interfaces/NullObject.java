package interfaces;

/**
 * Interface for {@code Null} objects.
 * 
 * @author Zimon Kuhs
 * @date 2017-03-22
 */
public interface NullObject {

    /**
     * Checks whether or not this is a {@code null} object.
     * 
     * @return
     *         {@code false} for any object implementing this interface unless a
     *         {@code null} object, in which case {@code true} is returned.
     */
    boolean isNull();
}
