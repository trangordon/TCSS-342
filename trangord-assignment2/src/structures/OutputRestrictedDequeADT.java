/* Gordon Tran
 * TCSS 342
 * Assignment 2
 */
package structures;

/**
 * The Interface OutputRestrictedDequeADT.
 *
 * @author Gordon Tran
 * @version Winter 2019
 * @param <E> the element type
 */
public interface OutputRestrictedDequeADT<E> extends QueueADT<E> {
    
    /**
     * Enqueue at front.
     *
     * @param theElement the the element
     */
    void enqueueAtFront(E theElement);

}
