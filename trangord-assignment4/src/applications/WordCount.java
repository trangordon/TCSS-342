/* Gordon Tran
 * Assignment 4
 * TCSS 342 
 */

package applications;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * The Class WordCount accepts an input file and gives statistics on word count and frequency.
 *
 * @author Gordon Tran
 * @version Winter 2019
 */
public final class WordCount {
    
    /** The number of run time attempts. */
    private static final int RUN_TIME_ATTEMPT = 1000;
    
    /** The start time. */
    private static long startTime;
    
    /** The end time. */
    private static long endTime;
    
    /** The time elapsed. */
    private static long timeElapsed;
    
    /** The best time. */
    private static long bestTime = Integer.MAX_VALUE;
    
    /** The total time. */
    private static long totalTime;
    
    /**Private constructor. */
    private WordCount() {
    }

    /**
     * Diver and converts file contents into list.
     *
     * @param theArgs the arguments
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(final String[] theArgs) throws IOException {
        //Declare variables
        final int freqWord;
        Scanner console = new Scanner(new BufferedReader(new FileReader("ASH.txt")));
        Scanner input;
        final BufferedWriter out = new BufferedWriter(new FileWriter("temp.txt"));
        final ArrayList<String> list = new ArrayList<String>();
        String line;
        String processedLine = "";
        //User input
        //File input
        System.out.print("File name to be word counted (Defaults to \"ASH.txt\"): ");
        input = new Scanner(System.in);
        try {
            console = new Scanner(new BufferedReader(new FileReader(input.next())));
        } catch (final FileNotFoundException e) {
            System.out.println("Invalid file; Defaulting to \"ASH.txt\"");
        }
        //Number of words input
        do {
            System.out.print("Number of most frequent words: ");
            input = new Scanner(System.in);    
        } while (!input.hasNextInt());
        freqWord = input.nextInt();
        //Appraise, format, and clean punctuation
        while (console.hasNext()) {
            line = console.nextLine();
            processedLine = line.replaceAll("'s", "s").replaceAll(""
                            + "[^a-zA-Z0-9�]"
                            + "", " ").toLowerCase().replaceAll(""
                                            + "( )+", " ");
            out.write(processedLine + "\n");
        }
        out.close();
        console = new Scanner(new BufferedReader(new FileReader("temp.txt")));
        //Add words to list
        while (console.hasNext()) {
            list.add(console.next());
        }
        
        console.close();
        input.close();
        
        //Running the programs and timing
        //TreeMap
        printOutput(treeMapCount(list), freqWord);
        for (int i = 0; i < RUN_TIME_ATTEMPT; i++) {
            startTime = System.nanoTime();
            testOutput(treeMapCount(list), freqWord);
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            if (timeElapsed < bestTime) {
                bestTime = timeElapsed;
            }
            totalTime = totalTime + timeElapsed;
        }
        totalTime = totalTime / RUN_TIME_ATTEMPT;
        System.out.println("Average time for TreeMap over " + RUN_TIME_ATTEMPT + " runs:"
                        + "\nNanoseconds: " + totalTime + " ns"
                        + "\nMilliseconds: " + totalTime / 1000000 + " ms"
                        + "\nBest Time: " + bestTime + " ns");

        //Reset
        totalTime = 0;
        bestTime = Integer.MAX_VALUE;
        
        //HashMap
        printOutput(hashMapCount(list), freqWord);
        for (int i = 0; i < RUN_TIME_ATTEMPT; i++) {
            startTime = System.nanoTime();
            testOutput(hashMapCount(list), freqWord);
            endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            if (timeElapsed < bestTime) {
                bestTime = timeElapsed;
            }
            totalTime = totalTime + timeElapsed;
        }
        totalTime = totalTime / RUN_TIME_ATTEMPT;
        System.out.println("Average time for HashMap over " + RUN_TIME_ATTEMPT + " runs:"
                        + "\nNanoseconds: " + totalTime  + " ns"
                        + "\nMilliseconds: " + totalTime / 1000000 + " ms"
                        + "\nBest Time: " + bestTime + " ns");
    }
    
    
    /**
     * Uses a TreeMap to count frequency of words. 
     *
     * @param theList the list of words
     * @return the map of words
     */
    public static Map<String, Integer> treeMapCount(final ArrayList<String> theList) {
        //Declare variables
        final Map<String, Integer> countMap = new TreeMap<String, Integer>();
        String buffer;
        int index = 0;
        //Add words to map
        while (index < theList.size()) {
            buffer = theList.get(index);
            if (countMap.containsKey(buffer)) { 
                countMap.put(buffer, countMap.get(buffer) + 1);
            } else {
                countMap.put(buffer, 1);
            }
            index++;
        }
        
        return countMap;
    }
    
    /**
     * Uses a HashMap to count frequency of words. 
     *
     * @param theList the list of words
     * @return the map of words
     */
    public static Map<String, Integer> hashMapCount(final ArrayList<String> theList) {
        //Declare variables
        final Map<String, Integer> countMap = new HashMap<String, Integer>();
        String buffer;
        int index = 0;
        //Add words to map
        while (index < theList.size()) {
            buffer = theList.get(index);
            if (countMap.containsKey(buffer)) { 
                countMap.put(buffer, countMap.get(buffer) + 1);
            } else {
                countMap.put(buffer, 1);
            }
            index++;
        }
        
        return countMap;
    }
    
    /**
     * Output number of words and most frequent words.
     *
     * @param theMap the map of words
     * @param theFreq the number of most frequent numbers
     */
    public static void printOutput(final Map<String, Integer> theMap, final int theFreq) {
        //Declare Variable
        final Map<String, Integer> tempMap = theMap;
        Map.Entry<String, Integer> maxEntry = null;
        String tmpStr;
        System.out.println("Number of words: " + tempMap.size());
        //Look for entry with largest value
        for (int j = 0; j < theFreq; j++) {
            for (Map.Entry<String, Integer> entry : tempMap.entrySet()) {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                    maxEntry = entry;
                }
            }

            try {
                //Print and remove entry from map
                tmpStr = maxEntry.toString();
                tempMap.remove(maxEntry.getKey());
                System.out.println(tmpStr);
            } catch (final NullPointerException e) {
                //Ends method early if number of words requested is more than words in map
                System.out.println("Requested number exceeds amount of words!");
                return;
            }
            
            
            maxEntry = null;
        }
    }
    
    /**
     * Test speed of printOutput without printing.
     *
     * @param theMap the map of words
     * @param theFreq the number of most frequent numbers
     */
    public static void testOutput(final Map<String, Integer> theMap, final int theFreq) {
        //Declare Variable
        final Map<String, Integer> tempMap = theMap;
        Map.Entry<String, Integer> maxEntry = null;
        String tmpStr;
        //Look for entry with largest value
        for (int j = 0; j < theFreq; j++) {
            for (Map.Entry<String, Integer> entry : tempMap.entrySet()) {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                    maxEntry = entry;
                }
            }

            try {
                //Print and remove entry from map
                tmpStr = maxEntry.toString();
                tempMap.remove(maxEntry.getKey());
            } catch (final NullPointerException e) {
                //Ends method early if number of words requested is more than words in map
                return;
            }
            
            
            maxEntry = null;
        }
    }
}
