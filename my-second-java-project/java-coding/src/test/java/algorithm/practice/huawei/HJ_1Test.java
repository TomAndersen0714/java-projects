package algorithm.practice.huawei;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.BufferedInputStream;
import java.io.IOException;

/**
 * @author TomAndersen
 */
class HJ_1Test {

    @Test
    void main() throws IOException {
        String input = "hello nowcoder";
        System.setIn(
            new BufferedInputStream(new ByteArrayInputStream(input.getBytes()))
        );

        new HJ_1().main(new String[]{});
    }
}