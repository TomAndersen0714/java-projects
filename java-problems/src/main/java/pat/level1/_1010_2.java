package pat.level1;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author TomAndersen
 */
public class _1010_2 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        double demand = Double.parseDouble(inputs[1]);

        // input
        String[] s = bf.readLine().split(" ");
        String[] p = bf.readLine().split(" ");
        double[] stocks = new double[n];
        double[] profiles = new double[n];

        for (int i = 0; i < n; i++) {
            stocks[i] = Double.parseDouble(s[i]);
            profiles[i] = Double.parseDouble(p[i]);
        }

        // search the max and sell
        double profileSum = 0.0;
        while (demand != 0) {
            double unitPrice = 0.0;
            int idx = 0;
            // search the max
            for (int i = 0; i < n; i++) {
                if (stocks[i] > 0 && profiles[i] / stocks[i] > unitPrice) {
                    unitPrice = profiles[i] / stocks[i];
                    idx = i;
                }
            }

            // break if all sellout
            if (stocks[idx] == 0) {
                break;
            }

            // sell
            if (demand >= stocks[idx]) {
                profileSum += profiles[idx];
                demand -= stocks[idx];
                stocks[idx] = 0;
                profiles[idx] = 0;
            }
            else {
                profileSum += unitPrice * demand;
                profiles[idx] -= unitPrice * demand;
                stocks[idx] -= demand;
                demand = 0;
            }

        }

        // output
        System.out.printf("%.2f\n", profileSum);
    }
}
