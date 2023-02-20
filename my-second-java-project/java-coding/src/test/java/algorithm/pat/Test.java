package algorithm.pat;

import algorithm.pat.level1._1003_1;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author TomAndersen
 */
public class Test {
    public static void main(String[] args) {
        String inputStr = "10000 10000";
        System.setIn(new BufferedInputStream(
            new ByteArrayInputStream(inputStr.getBytes(StandardCharsets.UTF_8)))
        );

        try {
            _1003_1.main(args);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
