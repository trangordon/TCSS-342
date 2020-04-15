/* 
 * TCSS 342
 */

package structures;

import java.util.EmptyStackException;

/**
 * A linked node-based LIFO stack.
 * 
 * @author Alan Fowler - adopted from textbook code.
 * @version 1.1
 *
 * @param <E>
 */
public class LinkedStack<E> implements StackADT<E> {
    
    /**
     * The number of elements currently in the stack.
     */
    private int mySize;
    
    /**
     * A reference to the front node of the stack.
     */
    private Node<E> myFront;
    
    /**
     * Initialize the stack.
     */
    public LinkedStack() {
        mySize = 0;
        myFront = null; // intentional null assignment - OK to ignore the warning
    }

    @Override
    public void push(final E theElement) {
        
        myFront = new Node<E>(theElement, myFront);
        mySize++;
    }

    @Override
    public E pop() {
        if (mySize == 0) { // mySize == 0 instead of isEmpty() for efficiency
            throw new EmptyStackException();
        }
        
        final Node<E> temp = myFront;
        myFront = myFront.myNext;
        mySize--;
        return temp.myElement;
    }

    @Override
    public E peek() {
        if (mySize == 0) {
            throw new EmptyStackException();
        }
        return myFront.myElement;
    }

    @Override
    public int size() {
        return mySize;
    }

    @Override
    public boolean isEmpty() {
        return mySize == 0;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        if (isEmpty()) {
            sb.append("Empty Stack");  // maybe an empty stack should return an empty String?
        } else {
            Node<E> temp = myFront;
            while (temp != null) {                
                sb.append(temp.myElement);
                temp = temp.myNext;
                
                sb.append('\n');
            }
        }
        return sb.toString();
    }
    
    // inner class
    /**
     * Represents one Node in a singly linked structure.
     * 
     * @author Alan Fowler - adopted from textbook code.
     * @version 1.1
     *
     * @param <T>
     */
    private class Node<T> {
        
        /** A reference to the data held by this Node. */ 
        private final T myElement;
        
        /** A reference to the next Node in the linked structure. */
        private final Node<T> myNext;
        
        /**
         * Initialize the Node using the specified element and next Node reference.
         * 
         * @param theElement a reference to the data element for this Node
         * @param theNextNode a reference to the next Node in the linked structure
         */
        Node(final T theElement, final Node<T> theNextNode) {
            myElement = theElement;
            myNext = theNextNode;
        }
    }

}
