package libraries.java.io;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author TomAndersen
 * @see java.io.PrintStream
 */
public class PrintWriterAPI {
    public static void main(String[] args) throws IOException {

        // constructor
        PrintWriter printWriter = new PrintWriter(
            "src/main/resources/test.txt", StandardCharsets.UTF_8
        );

        // print
        printWriter.println("Hello world!");
    }
}
