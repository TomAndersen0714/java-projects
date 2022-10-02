package cn.tomandersen.java.reading.core_java.chapter03;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDemo {
    public static void main(String[] args) {
        LotteryDrawing();
        compoundInterest();
        LotteryArray();
    }

    /**
     * This program demonstrates array manipulation
     *
     * @author Tom Andersen
     */
    static void LotteryDrawing() {
        Scanner in = new Scanner(System.in);

        System.out.println("What is the biggest number you can draw? ");
        int n = in.nextInt();

        System.out.println("How many numbers do you need to draw? ");
        int k = in.nextInt();

        if (k > n) {
            System.out.println("The size of numbers you need to draw shouldn't exceed the biggest number you can draw!");
            return;
        }

        // create an array, and fill the array with numbers of a ascending sequence which start from 1
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        // draw k numbers and put them into a result array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            // generate a random index in [0, n-1)
            int idx = (int) (Math.random() * n);

            // pick the element at the random location
            result[i] = nums[idx];

            // move the last element into the random location
            nums[idx] = nums[n - 1];
            n--;
        }
        // print the result array
        Arrays.sort(result);
        System.out.println("Bet the following combination, it'll make you rich!");
//        for (int num : nums) {
//            System.out.println(num);
//        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * This program shows how to store tabular data in a 2D array
     */
    static void compoundInterest() {
        final int N_RATES = 6;
        final int N_YEARS = 10;
        final double START_RATE = 10d;
        final double DELTA_RATE = 1d;
        final double START_BALANCE = 10000d;
        double[] interestRates = new double[N_RATES];
        double[][] balances = new double[N_YEARS][N_RATES];

        // initiate interest array and balance array
        for (int i = 0; i < interestRates.length; i++) {
            interestRates[i] = (START_RATE + i * DELTA_RATE) / 100.0;
            balances[0][i] = START_BALANCE;
        }

        // compute the balance for future years
        for (int i = 1; i < balances.length; i++) {
            for (int j = 0; j < balances[i].length && j < interestRates.length; j++) {
                balances[i][j] = balances[i - 1][j] * interestRates[j] + balances[i - 1][j];
            }
        }

        // print the row of interest rates
        for (double rate : interestRates) {
            System.out.printf("%9.0f%%", 100 * rate);
        }
        System.out.println();

        // print the table of balance
        for (double[] balanceRow : balances) {
            for (double balance : balanceRow) {
                System.out.printf("%10.2f", balance);
            }
            System.out.println();
        }

    }

    /**
     * This program demonstrates a triangular array
     */
    static void LotteryArray() {
        final int N_MAX = 10;

        // allocate triangular array
        int[][] odds = new int[N_MAX + 1][];
        for (int n = 0; n <= N_MAX; n++)
            odds[n] = new int[n + 1];

        // fill triangular array
        for (int n = 0; n < odds.length; n++) {
            for (int k = 0; k < odds[n].length; k++) {
                // compute binomial coefficient n*(n-1)*(n-2)*(n-3)...*(n-k+1)/(1*2*3*...*k)
                int lotteryOdds = 1;
                for (int i = 1; i <= k; i++) {
                    lotteryOdds = lotteryOdds * (n - i + 1) / i;
                }
                odds[n][k] = lotteryOdds;
            }
        }

        // print triangular array
        for (int[] row : odds) {
            for (int odd : row) {
                System.out.printf("%4d", odd);
            }
            System.out.println();
        }
    }

}
