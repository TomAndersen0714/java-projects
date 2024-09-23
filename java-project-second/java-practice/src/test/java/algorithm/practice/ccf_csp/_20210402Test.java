package algorithm.practice.ccf_csp;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.io.BufferedInputStream;

/**
 * @author TomAndersen
 */
class _20210402Test {

    @Test
    void main() throws IOException {
        String inputStr = "11 8 2 2\n" +
            "0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 7 0 0 0 7 0 0 7 7 0\n" +
            "7 0 7 0 7 0 7 0 7 0 7\n" +
            "7 0 0 0 7 0 0 0 7 0 7\n" +
            "7 0 0 0 0 7 0 0 7 7 0\n" +
            "7 0 0 0 0 0 7 0 7 0 0\n" +
            "7 0 7 0 7 0 7 0 7 0 0\n" +
            "0 7 0 0 0 7 0 0 7 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0\n" +
            "0 0 0 0 0 0 0 0 0 0 0";
        System.setIn(new BufferedInputStream(new ByteArrayInputStream(inputStr.getBytes())));
        _20210402.main(new String[]{});
    }
}