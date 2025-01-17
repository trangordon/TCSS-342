/* Gordon Tran  
 * Assignment 1
 * CSS 342 
 */
package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import program.StackUtilities;

/**
 * The Class StackUtilitiesTest.
 * @author Gordon Tran
 * @version Winter 2019
 */
public class StackUtilitiesTest {
    
    /**
     * decimalToBinary method.
     */
    @Test
    public void test() {
        assertEquals("1010", StackUtilities.decimalToBinary(10));
        assertEquals("Invalid number", StackUtilities.decimalToBinary(-10));
        assertEquals("0", StackUtilities.decimalToBinary(0));
        assertEquals("1111111111111111111111111111111", 
                   StackUtilities.decimalToBinary(Integer.MAX_VALUE));
        assertEquals("Invalid number", StackUtilities.decimalToBinary(Integer.MAX_VALUE + 1));
    }

}
