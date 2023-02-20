package algorithm.pat;

import algorithm.pat.level1._1002_1;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author TomAndersen
 */
public class Test {
    public static void main(String[] args) {
        String inputStr = "13 1 2 3 4 5 6 7 8 9 10 20 16 18";
        System.setIn(new BufferedInputStream(
            new ByteArrayInputStream(inputStr.getBytes(StandardCharsets.UTF_8)))
        );

        try {
            _1002_1.main(args);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
