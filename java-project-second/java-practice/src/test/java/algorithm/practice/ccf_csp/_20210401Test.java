package algorithm.practice.ccf_csp;

import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author TomAndersen
 */
class _20210401Test {

    @Test
    void main() throws IOException {
        String inputStr = "4 4 16\n" +
            "0 1 2 3\n" +
            "4 5 6 7\n" +
            "8 9 10 11\n" +
            "12 13 14 15";
        System.setIn(
            new BufferedInputStream(
                new ByteArrayInputStream(inputStr.getBytes())
            )
        );
        new _20210401().main(new String[]{});
    }
}