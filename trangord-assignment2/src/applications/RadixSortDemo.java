/* Gordon Tran
 * TCSS 342
 * Assignment 2
 */
package applications;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The Class RadixSortDemo.
 * @author Gordon Tran
 * @version Winter 2019
 */
public final class RadixSortDemo {
    
    /**
     * Empty constructor.
     */
    private RadixSortDemo() {
    }

    /**
     * Main method for demo.
     * @param theArgs arguments
     * @throws FileNotFoundException 
     */
    public static void main(final String[] theArgs) throws FileNotFoundException {
//        final Scanner console = new Scanner(System.in);
//        System.out.println("This program only accepts .txt files "
//                        + "that include integers separated by line.");
//        System.out.println("Enter the file name including \".txt\":");
//        final String fileName = console.next();
//        RadixSort.radixSort(fileName);
//        console.close();
//        System.out.println("File created!");
        RadixSort.radixSort("input100.txt");
    }
}
