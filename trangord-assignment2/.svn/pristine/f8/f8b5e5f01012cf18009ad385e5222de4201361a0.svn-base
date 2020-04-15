/* Gordon Tran
 * TCSS 342
 * Assignment 2
 */
package tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import exceptions.EmptyCollectionException;
import structures.LinkedOutputRestrictedDeque;

/**
 * The Class LinkedOutputRestrictedDequeTest.
 * @author Gordon Tran
 * @version Winter 2019
 */
public class LinkedOutputRestrictedDequeUnitTest {

    /** The Linked Output Restricted Double Ended Queue. */
    private LinkedOutputRestrictedDeque<Integer> myLORDQue;
    
    /**
     * Setup.
     */
    @Before
    public void setup() {
        myLORDQue = new LinkedOutputRestrictedDeque<Integer>();
    }
    
    /**
     * Test default constructor.
     */
    @Test
    public void testLinkedOutputRestrictedDeque() {
        assertEquals(0, myLORDQue.size());
    }

    /**
     * Test enqueue at front.
     */
    @Test
    public void testEnqueueAtFront() {
        myLORDQue.enqueueAtFront(1);
        int temp = myLORDQue.first();
        assertEquals(1, temp);
        myLORDQue.enqueueAtFront(2);
        temp = myLORDQue.first();
        assertEquals(2, temp);
    }

    /**
     * Test dequeue.
     */
    @Test
    public void testDequeue() {
        myLORDQue.enqueue(1);
        myLORDQue.enqueue(2);
        final int temp = myLORDQue.dequeue();
        assertEquals(1, temp);
    }

    /**
     * Test first.
     */
    @Test
    public void testFirst() {
        myLORDQue.enqueue(1);
        final int temp = myLORDQue.first();
        assertEquals(1, temp);
        
    }
    
    /**
     * Test first when empty.
     */
    @Test (expected = EmptyCollectionException.class)
    public void testFirstEmpty() {
        myLORDQue.first();
    }
    
    /**
     * Test dequeue when empty.
     */
    @Test (expected = EmptyCollectionException.class)
    public void testDequeueEmpty() {
        myLORDQue.dequeue();
    }

    /**
     * Test size.
     */
    @Test
    public void testSize() {
        assertEquals(0, myLORDQue.size());
        for (int i = 0; i < 10; i++) {
            myLORDQue.enqueue(i);
        }
        assertEquals(10, myLORDQue.size());
    }

    /**
     * Test is empty.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(myLORDQue.isEmpty());
        myLORDQue.enqueue(1);
        assertFalse(myLORDQue.isEmpty());
    }

    /**
     * Test to string.
     */
    @Test
    public void testToString() {
        final String testString = "front -> 1";
        myLORDQue.enqueue(1);
        final String temp = myLORDQue.toString();
        assertEquals(testString, temp);
    }
}
