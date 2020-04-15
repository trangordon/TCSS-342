/* Gordon Tran
 * TCSS 342
 * Assignment 2
 */
package applications;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import structures.LinkedOutputRestrictedDeque;
/**
 * The Class RadixSort.
 * @author Gordon Tran
 * @version Winter 2019
 */
public final class RadixSort {
    
    /**Empty Constructor.*/
    private RadixSort() {
        
    }
    
    /**
     * Radix sort for files of numbers up to 4 digits long.
     * Returns output.txt file with sorted integers. 
     * @param theInputFile input file of integers
     * @throws FileNotFoundException throws File Not Found Exception
     */
    public static void radixSort(final String theInputFile) throws FileNotFoundException {
        final int decimal = 10;
        //read file and set it to queue
        final Scanner console = new Scanner(new File(theInputFile));
        final LinkedOutputRestrictedDeque<Integer> list = 
                        new LinkedOutputRestrictedDeque<Integer>();
        while (console.hasNext()) {
            final String temp = console.next();
            list.enqueue(Integer.parseInt(temp));
        }
        final int inputSize = list.size();
        
        //Setup digit queues
        final ArrayList<LinkedOutputRestrictedDeque<Integer>> digitQueues = 
                        new ArrayList<LinkedOutputRestrictedDeque<Integer>>();
        for (int i = 0; i < decimal; i++) {
            digitQueues.add(i, new LinkedOutputRestrictedDeque<Integer>()); 
        }

//Sorting 
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < inputSize; j++) {
                final int temp = list.dequeue();
                final int index = (temp / (int) Math.pow(decimal, i)) % decimal;
                digitQueues.get(index).enqueue(temp);
            }
            
            for (int j = 0; j < decimal; j++) {
                while (!digitQueues.get(j).isEmpty()) {
                    list.enqueue(digitQueues.get(j).dequeue());
                }
            }
        }
        
        try {
            fileWriter(list);
        } catch (final IOException e) {
            System.out.println("IO Exception!");
            e.printStackTrace();
        }
        
        console.close();
    }
    
    /**
     * Helper method to write file.
     * @param theList queue of sorted integers
     * @throws IOException IO exception
     */
    private static void fileWriter(final LinkedOutputRestrictedDeque<Integer> theList) 
                    throws IOException {
        final BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));
        while (!theList.isEmpty()) {
            out.write(theList.dequeue().toString());
            out.newLine();
        }
        out.close();
    }
}
