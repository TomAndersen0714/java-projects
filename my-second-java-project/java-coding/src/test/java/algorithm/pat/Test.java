package algorithm.pat;

import algorithm.pat.level1._1003_2;
import algorithm.pat.level1._1004_1;
import algorithm.pat.level1._1005_1;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author TomAndersen
 */
public class Test {
    public static void main(String[] args) {
        String inputStr = "14 60 80\n" +
            "10000001 64 90\n" +
            "10000002 90 60\n" +
            "10000011 85 80\n" +
            "10000003 85 80\n" +
            "10000004 80 85\n" +
            "10000005 82 77\n" +
            "10000006 83 76\n" +
            "10000007 90 78\n" +
            "10000008 75 79\n" +
            "10000009 59 90\n" +
            "10000010 88 45\n" +
            "10000012 80 100\n" +
            "10000013 90 99\n" +
            "10000014 66 60";
        System.setIn(new BufferedInputStream(
            new ByteArrayInputStream(inputStr.getBytes(StandardCharsets.UTF_8)))
        );

        try {
            _1005_1.main(args);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
