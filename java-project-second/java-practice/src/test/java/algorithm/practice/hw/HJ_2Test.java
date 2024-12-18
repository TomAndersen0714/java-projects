package algorithm.practice.hw;

import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author TomAndersen
 */
class HJ_2Test {

    @Test
    void main() throws IOException {
        String input = "ABCabc\n" +
            "A";
        System.setIn(
            new BufferedInputStream(new ByteArrayInputStream(input.getBytes()))
        );

        new HJ_2().main(new String[]{});
    }
}