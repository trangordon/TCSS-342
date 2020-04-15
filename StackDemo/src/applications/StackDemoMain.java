/* 
 * TCSS 342
 */

package applications;

/**
 * @author Alan Fowler acfowler@uw.edu
 * @version 1.1
 */
public final class StackDemoMain {

    /**
     * Private constructor to inhibit instantiation.
     */
    private StackDemoMain() {
    }

    /**
     * Simple graphical Stack demo.
     * 
     * @param theArgs array of Strings
     */
    public static void main(final String[] theArgs) {
        new StackDemoGUI().display();
    }
}
