package leetcode.common;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author TomAndersen
 */
class UtilsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void randomIntArray() {
        System.out.println(Arrays.toString(Util.randomIntArray(10)));
    }
}
