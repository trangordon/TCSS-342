/**
 * Gordon Tran
 * Assignment 1
 */
package program;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Runs interactive program. 
 * @author Gordon Tran
 * @version Winter 2019
 */
public final class Driver {
    
    /**
     * Private constructor. 
     */
    private Driver() {
    }

    /**
     * Main method.
     * @param theArgs the arguments.
     */
    public static void main(final String[] theArgs) {
        final Scanner console = new Scanner(System.in);
        String repeatCheck = "";
        int buffer = 0;
        while (!"0".equals(repeatCheck)) {
            try {
                System.out.println("Enter a positive decimal number to convert to binary:");
                buffer = console.nextInt();
                System.out.println(StackUtilities.decimalToBinary(buffer));
                System.out.println("Would you like to convert another number?");
                System.out.println("Enter 0 to stop\nEnter anything else to continue:");
                repeatCheck = console.next();
            } catch (final InputMismatchException ex) {
                System.out.println("Invalid input");
                console.nextLine();
            }
            
        }
        console.close();
    }

}
