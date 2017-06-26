package zmk.collection;

import java.util.Arrays;
import java.util.Collection;

/**
 * Extension of {@link java.util.PriorityQueue}.
 * 
 * @author Zimon Kuhs
 * @date 2017-05-13
 *
 * @param <E>
 *            The type of element in the list.
 */
public class PriorityQueue<E> extends java.util.PriorityQueue<E> {

    /**
     * Serial identification number.
     */
    private static final long serialVersionUID = 5669994110307786900L;

    /**
     * Constructs a {@link PriorityQueue} from zero or more elements.
     * 
     * @param elements
     *            The elements initially in this queue.
     */
    @SafeVarargs
    public PriorityQueue(E... elements) {
        this(Arrays.asList(elements));
    }

    /**
     * Constructs a new {@link PriorityQueue} using zero or more elements.
     * 
     * @param elements
     *            The elements initially in this queue.
     */
    public PriorityQueue(Collection<? extends E> elements) {
        super();
        for (E element : elements) {
            offer(element);
        }
    }
}
