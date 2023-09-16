package algorithm.practice.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 990. Satisfiability of Equality Equations: https://leetcode.com/problems/satisfiability-of-equality-equations/
 *
 * @author TomAndersen
 */
public class LeetCode990 {
}


/**
 * Union-Find
 * TC: O(n*log(n)), SC: O(n)
 */
class LeetCode990_1 {
    public boolean equationsPossible(String[] equations) {
        // exclude boundary situations
        if (equations == null || equations.length == 0) {
            return true;
        }

        // solve problem
        boolean res = true;
        int[] roots = new int[256];
        Arrays.fill(roots, -1);

        for (String equation : equations) {
            int a = equation.charAt(0), b = equation.charAt(3);
            boolean isEqual = equation.charAt(1) != '!';

            if (roots[a] == -1) {
                roots[a] = a;
            }
            if (roots[b] == -1) {
                roots[b] = b;
            }

            if (isEqual) {
                roots[b] = roots[a];
            }
            else {
            }
        }


        // return
        return res;
    }

    public static void main(String[] args) {

    }
}
