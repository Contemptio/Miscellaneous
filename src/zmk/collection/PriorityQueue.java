package zmk.collection;

import java.util.Arrays;
import java.util.Collection;

public class PriorityQueue<E> extends java.util.PriorityQueue<E> {

    /**
     * Serial identification number.
     */
    private static final long serialVersionUID = 5669994110307786900L;

    /**
     * Constructs a {@link PriorityQueue} from an array.
     * 
     * @param es
     */
    public PriorityQueue(E[] es) {
        this(Arrays.asList(es));
    }

    public PriorityQueue(Collection<? extends E> es) {
        super();
        for (E e : es) {
            offer(e);
        }
    }
}
