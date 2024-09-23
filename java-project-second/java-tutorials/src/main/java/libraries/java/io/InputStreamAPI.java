package libraries.java.io;

import libraries.Utils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author TomAndersen
 * @see java.io.InputStream
 * @see java.io.BufferedInputStream
 * @see java.lang.System
 */
public class InputStreamAPI {
    public static void main(String[] args) {
        System.out.println("Utils.getClassName(System.in) = " + Utils.getClassName(System.in));
        System.out.println("Utils.getClassName(System.out) = " + Utils.getClassName(System.out));

        System.out.println("(System.in instanceof InputStream) = " + (System.in instanceof InputStream));
        System.out.println("(System.in instanceof BufferedInputStream) = " + (System.in instanceof BufferedInputStream));

        try {
            // read, reads the next byte of data from the input stream
            char c = (char) System.in.read();
            System.out.println(c);
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
