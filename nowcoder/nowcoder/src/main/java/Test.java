import problem2.Main;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author TomAndersen
 */
public class Test {
    public static void main(String[] args) throws IOException {
        String input = "4,4,0,0,3,3";
        System.setIn(new BufferedInputStream(new ByteArrayInputStream(input.getBytes())));
        Main.main(new String[]{});
    }
}
