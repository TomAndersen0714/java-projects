package algorithm.pat;

import algorithm.pat.level1.*;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author TomAndersen
 */
public class Test {
    public static void main(String[] args) {
        String inputStr = "3 20\n" +
            "18 15 10\n" +
            "75 72 45";
        System.setIn(new BufferedInputStream(
            new ByteArrayInputStream(inputStr.getBytes(StandardCharsets.UTF_8)))
        );

        try {
            _1010_1.main(args);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
