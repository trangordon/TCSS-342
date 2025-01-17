/*
 * Gordon Tran
 * TCSS 342
 * Assignment 1
 */
package program;
import structures.ArrayStack;
/**
 * The Class Stack Utilities.
 * @author Gordon Tran
 * @version Winter 2019
 */
public final class StackUtilities {
    /**
     * Array Stack object.
     */
    private static ArrayStack<Integer> myArrayStack = new ArrayStack<Integer>();
    /**
     * Empty constructor.
     */
    private StackUtilities() {
    }
    /**
     * Decimal to binary.
     * @param theNumber the decimal given
     * @return the string
     */
    public static String decimalToBinary(final int theNumber) {
        int remainder = 0;
        int newNumber = theNumber;
        String output = "";
        if (theNumber < 0) {
            return "Invalid number";
        }
        if (theNumber == 0) {
            return "0";
        } 
        while (newNumber > 0) {
            remainder = newNumber % 2;
            myArrayStack.push(remainder);
            newNumber =  newNumber / 2;
        }
        while (!myArrayStack.isEmpty()) {
            output = output + myArrayStack.pop();
        }
        return output;
    }
}