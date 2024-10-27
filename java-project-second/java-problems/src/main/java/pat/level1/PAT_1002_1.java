package pat.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.nowcoder.com/pat/6/problem/4078
public class PAT_1002_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = bufferedReader.readLine().split(" ");
        if (nums.length <= 1) return;

        final short N = Short.parseShort(nums[0]);
        int a1 = 0, a2 = 0, a3 = 0, a5 = 0;
        boolean a3Flag = false;
        int a4Cnt = 0;
        double a4 = 0.0, a4Sum = 0.0;

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(nums[i]);

            switch (num % 5) {
                case 0:
                    if (num % 2 == 0) a1 += num;
                    break;
                case 1:
                    if (!a3Flag) a2 += num;
                    else a2 -= num;
                    a3Flag = !a3Flag;
                    break;
                case 2:
                    a3 += 1;
                    break;
                case 3:
                    a4Cnt += 1;
                    a4Sum += num;
                    a4 = a4Sum / a4Cnt;
                    break;
                case 4:
                    if (num > a5) a5 = num;
                    break;
                default:
                    break;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        if (a1 != 0) stringBuilder.append(a1);
        else stringBuilder.append("N");
        stringBuilder.append(" ");

        if (a2 != 0) stringBuilder.append(a2);
        else stringBuilder.append("N");
        stringBuilder.append(" ");

        if (a3 != 0) stringBuilder.append(a3);
        else stringBuilder.append("N");
        stringBuilder.append(" ");

        if (a4 != 0.0) stringBuilder.append(String.format("%.1f", a4));
        else stringBuilder.append("N");
        stringBuilder.append(" ");

        if (a5 != 0) stringBuilder.append(a5);
        else stringBuilder.append("N");

        System.out.println(stringBuilder);
    }
}
