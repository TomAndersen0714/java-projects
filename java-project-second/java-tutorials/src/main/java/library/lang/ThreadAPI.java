package library.lang;

import java.util.Arrays;

/**
 * @author TomAndersen
 * @see java.lang.Thread
 */
public class ThreadAPI {
    /**
     * @param args
     * @see StackTraceElementAPI
     */
    public static void main(String[] args) {
        // NOTE: class method

        // Thread.currentThread()
        Thread currentThread = Thread.currentThread();
        System.out.println("Thread.currentThread() = " + currentThread);

        // NOTE: instance method

        // getStackTrace()
        // Returns an array of stack trace elements representing the stack dump of this thread.
        StackTraceElement[] traceElements = currentThread.getStackTrace();
        System.out.println("traceElements = " + Arrays.toString(traceElements));
    }
}
