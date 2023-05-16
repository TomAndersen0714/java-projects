package algorithm.practice.huawei;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;


/**
 * @author TomAndersen
 */
class HJ_6Test {

    @Test
    void main() throws IOException {
        String input = "25";
        System.setIn(new BufferedInputStream(new ByteArrayInputStream(input.getBytes())));

        new HJ_6().main(new String[]{});
    }
}