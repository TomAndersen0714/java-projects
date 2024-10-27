package pat.level1;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
// https://www.nowcoder.com/pat/6/problem/4046

/**
 * @author TomAndersen
 */
public class PAT_1010_1 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        double d = Double.parseDouble(inputs[1]);

        // input, and calculate the unit profit
        String[] stocks = bf.readLine().split(" ");
        String[] profits = bf.readLine().split(" ");
        double[][] goods = new double[n][];

        for (int i = 0; i < n; i++) {
            double stock = Double.parseDouble(stocks[i]);
            double profit = Double.parseDouble(profits[i]);

            goods[i] = new double[]{stock, profit};
        }

        // sort the goods by the unit profit in descending
        Arrays.sort(goods, (x, y) -> {
            return Double.compare(y[1] / y[0], x[1] / x[0]);
        });

        // iterate and get the result
        double demand = d;
        double profitSum = 0.0;
        for (int i = 0; i < n; i++) {
            if (demand > goods[i][0]) {
                demand -= goods[i][0];
                profitSum += goods[i][1];
            }
            else {
                double unitProfit = goods[i][1] / goods[i][0];
                profitSum += unitProfit * demand;
                demand = 0;
            }
        }

        // print
        System.out.printf("%.2f\n", profitSum);
    }
}
