package algorithm.practice.huawei;

import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author TomAndersen
 */
class HJ_3Test {

    @Test
    void main() throws IOException {
        String input = "3\n" +
            "2\n" +
            "2\n" +
            "1\n";
        System.setIn(
            new BufferedInputStream(new ByteArrayInputStream(input.getBytes()))
        );

        new HJ_3().main(new String[]{});
    }
}