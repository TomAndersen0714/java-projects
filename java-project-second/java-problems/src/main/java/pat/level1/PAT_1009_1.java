package pat.level1;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
// https://www.nowcoder.com/pat/6/problem/4045
// PS: 此题坑点在于
// 1. 题目的输入描述有误, 输入的整数范围为[0, 10000), 而非题目中描述的[1000, 10000)
// 2. 题目的输出描述有误, 输出的行间应该不存在空格

/**
 * @author TomAndersen
 */
public class PAT_1009_1 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        char[] nums = String.format("%04d", n).toCharArray();

        // sort in ascending
        Arrays.sort(nums);
        if (nums[0] == nums[3]) {
            System.out.println("N - N = 0000");
            return;
        }

        // iterate, concat and print
        StringBuilder sb = new StringBuilder();
        String a = String.valueOf(new char[]{nums[3], nums[2], nums[1], nums[0]});
        String b = String.valueOf(nums);
        int numA = Integer.parseInt(a), numB = Integer.parseInt(b);
        int res = numA - numB;
        sb.append(a);
        sb.append(" - ");
        sb.append(b);
        sb.append(" = ");
        sb.append(res);

        while (res != 6174) {
            nums = String.valueOf(res).toCharArray();
            Arrays.sort(nums);
            a = String.valueOf(new char[]{nums[3], nums[2], nums[1], nums[0]});
            b = String.valueOf(nums);
            numA = Integer.parseInt(a);
            numB = Integer.parseInt(b);
            res = numA - numB;

            sb.append('\n');
            sb.append(a);
            sb.append(" - ");
            sb.append(b);
            sb.append(" = ");
            sb.append(res);
        }
        System.out.print(sb);
    }
}
