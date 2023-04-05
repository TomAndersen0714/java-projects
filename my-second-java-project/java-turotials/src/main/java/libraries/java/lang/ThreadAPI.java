package libraries.java.lang;

import java.util.Arrays;

/**
 * @author TomAndersen
 * @see java.lang.Thread
 */
public class ThreadAPI {
    /**
     * @param args
     * @see libraries.java.lang.StackTraceElementAPI
     */
    public static void main(String[] args) {
        // note: class method
        Thread currentThread = Thread.currentThread();
        System.out.println("Thread.currentThread() = " + currentThread);

        // note: instance method

        // getStackTrace()
        // Returns an array of stack trace elements representing the stack dump of this thread.
        StackTraceElement[] traceElements = currentThread.getStackTrace();
        System.out.println("traceElements = " + Arrays.toString(traceElements));
    }
}
