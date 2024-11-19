package hw.first;

import java.io.*;

/**
 * https://www.nowcoder.com/practice/3ab09737afb645cc82c35d56a5ce802a
 *
 * @author TomAndersen
 */
public class HJ_7 {
    public static void main(String[] args) throws IOException {
        String input = "5.5";
        System.setIn(new BufferedInputStream(new ByteArrayInputStream(input.getBytes())));
        HJ_7_1.main(new String[]{});


        input = "2.499";
        System.setIn(new BufferedInputStream(new ByteArrayInputStream(input.getBytes())));
        HJ_7_1.main(new String[]{});
    }
}

class HJ_7_1 {
    public static void main(String[] args) throws IOException {
        // parse inputs
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        double inputDouble = Double.parseDouble(bf.readLine());

        // solve problem
        double floatNum = inputDouble - Math.floor(inputDouble);
        if (floatNum >= 0.5) {
            System.out.println((int) Math.ceil(inputDouble));
        }
        else {
            System.out.println((int) Math.floor(inputDouble));
        }
    }
}
