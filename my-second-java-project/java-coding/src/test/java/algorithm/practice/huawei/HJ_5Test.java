package algorithm.practice.huawei;

import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author TomAndersen
 */
class HJ_5Test {

    @Test
    void main() throws IOException {
        String input = "0xAA";
        System.setIn(new BufferedInputStream(new ByteArrayInputStream(input.getBytes())));

        new HJ_5().main(new String[]{});
    }
}