package algorithm.practice.hw;

import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author TomAndersen
 */
class HJ_7Test {

    @Test
    void main() throws IOException {
        String input = "5.5";
        System.setIn(new BufferedInputStream(new ByteArrayInputStream(input.getBytes())));
        new HJ_7().main(new String[]{});
    }
}