package algorithm.pat.level1;

import java.util.Scanner;

// https://www.nowcoder.com/pat/6/problem/4078
public class _1002_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final short N = sc.nextShort();
        String[] nums = sc.nextLine().split(" ");

        int a1 = 0, a2 = 0, a3 = 0, a5 = 0;
        int count = 0;
        boolean flag = false;
        double a4 = 0.0, sum = 0.0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(nums[i]);

            switch (num % 5) {
                case 0:
                    if (num % 2 == 0) a1 += num;
                    break;
                case 1:
                    if (!flag) a2 += num;
                    else a2 -= num;
                    flag = !flag;
                    break;
                case 2:
                    a3 += 1;
                    break;
                case 3:
                    count += 1;
                    sum += num;
                    a4 = sum / count;
                    break;
                case 4:
                    if (num > a5) a5 = num;
                    break;
                default:
                    break;
            }
        }
        System.out.print(a1);
        System.out.print(a2);
        System.out.print(a3);
        System.out.printf("%.1f", a4);
        System.out.print(a5);
    }

}
