package algorithm.practice.hw;

import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;


/**
 * @author TomAndersen
 */
class HJ_3_1Test {

    @Test
    void main() throws IOException {
        String input = "3\n" +
            "2\n" +
            "2\n" +
            "1\n";
        System.setIn(
            new BufferedInputStream(new ByteArrayInputStream(input.getBytes()))
        );

        new HJ_3_1().main(new String[]{});
    }
}