package libraries.java.io;

import java.io.IOException;

/**
 * @author TomAndersen
 * @see java.io.InputStream
 * @see java.lang.System.in
 */
public class InputStreamAPI {
    public static void main(String[] args) {
        try {
            // read, reads the next byte of data from the input stream
            char c = (char) System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
