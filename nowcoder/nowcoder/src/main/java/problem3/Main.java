package problem3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author TomAndersen
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // read stdin
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] numsStr = bufferedReader.readLine().split(" ");
        int[] nums = new int[numsStr.length];
        for (int i = 0; i < numsStr.length; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }

        // sort + two pointers
        Arrays.sort(nums);

        // if is the max length
        int sum = nums[nums.length - 1];
        int left = 0, right = nums.length - 1, counter = 0;
        while (left < right) {
            if (nums[left] == sum) {
                left += 1;
                counter += 1;
            }

            if (nums[right] == sum) {
                right -= 1;
                counter += 1;
            }

            if (left < right && nums[left] + nums[right] == sum) {
                left += 1;
                right -= 1;
                counter += 1;
            }
            else if (left == right && nums[left] == sum) {
                counter += 1;
                System.out.print(counter);
                return;
            }
            else {
                break;
            }
        }

        // print
        System.out.print(-1);
    }
}
