package algorithm.practice.huawei;


import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * https://www.nowcoder.com/practice/8c949ea5f36f422594b306a2300315da
 * <br>
 * tags: string
 *
 * @author TomAndersen
 */
public class HJ_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] words = bf.readLine().split(" ");
        System.out.println(words[words.length - 1].length());
    }
}
