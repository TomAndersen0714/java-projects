package algorithm.pat.lesson1;

import algorithm.practice.pat.level1._1020_1;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author TomAndersen
 */
public class Test {
    public static void main(String[] args) {
        String inputStr = "6 3\n" +
            "1 7 8 9 20 1000";
        System.setIn(new BufferedInputStream(
            new ByteArrayInputStream(inputStr.getBytes(StandardCharsets.UTF_8)))
        );

        try {
            _1020_1.main(args);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
