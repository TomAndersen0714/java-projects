package algorithm.pat;

import algorithm.pat.level1._1003_2;
import algorithm.pat.level1._1004_1;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author TomAndersen
 */
public class Test {
    public static void main(String[] args) {
        String inputStr = "3485Abak?@YHC#gcDC*ZOKxh4hggdsb\n" +
            "2984aBAk?~YHC#gCdc$ZOKkkkkhG\n" +
            "s&Hglfdker#?!#?!#?!#?!#?!#?!Azty\n" +
            "d&hyscvndp#?!#?!#?!#?!#?!#?!Am";
        System.setIn(new BufferedInputStream(
            new ByteArrayInputStream(inputStr.getBytes(StandardCharsets.UTF_8)))
        );

        try {
            _1004_1.main(args);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
