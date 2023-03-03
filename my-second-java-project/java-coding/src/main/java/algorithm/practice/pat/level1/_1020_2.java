package algorithm.practice.pat.level1;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author TomAndersen
 */
public class _1020_2 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(" ");
        String[] numbers = bf.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int p = Integer.parseInt(inputs[1]);
        int[] nums = new int[numbers.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(numbers[i]);
        }

        // sort and iterate
        Arrays.sort(nums);
        int maxLen = 0, len = nums.length;
        while (maxLen < len) {
            boolean existPerfect = false;
            for (int i = 0; i + maxLen < len; i++) {
                if (nums[i + maxLen] <= nums[i] * p) {
                    maxLen++;
                    existPerfect = true;
                    break;
                }
            }
            if (!existPerfect) {
                break;
            }
        }

        // output
        System.out.println(maxLen);
    }
}
