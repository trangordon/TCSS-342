/* Gordon Tran
 * TCSS 342
 * Assignment 2
 */
package structures;

/**
 * The Class LinkedOutputRestrictedDeque.
 *
 * @author Gordon Tran
 * @version Winter 2019
 * @param <E> the element type
 */
public class LinkedOutputRestrictedDeque<E> extends LinkedQueue<E>
                implements OutputRestrictedDequeADT<E> {

    /**
     * Instantiates a new linked output restricted double ended queue.
     */
    public LinkedOutputRestrictedDeque() {
        super();
    }
    
    @Override
    public void enqueueAtFront(final E theElement) {
        if (mySize == 0) { // Make a queue of one element
            myFront = new Node<E>(theElement);
            myRear = myFront;
        } else { // Regular case
            final LinkedQueue<E>.Node<E> temp = new Node<E>(theElement);
            temp.myNext = myFront;
            myFront = temp;
        }
        mySize++;
    }
}
