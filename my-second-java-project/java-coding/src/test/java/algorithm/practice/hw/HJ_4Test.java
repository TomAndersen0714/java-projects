package algorithm.practice.hw;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.BufferedInputStream;
import java.io.IOException;

/**
 * @author TomAndersen
 */
class HJ_4Test {

    @Test
    void main() throws IOException {
        String input = "232332323";
        System.setIn(new BufferedInputStream(new ByteArrayInputStream(input.getBytes())));

        new HJ_4().main(new String[]{});
    }
}