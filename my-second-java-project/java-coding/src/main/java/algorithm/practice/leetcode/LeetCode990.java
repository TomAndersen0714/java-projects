package algorithm.practice.leetcode;

/**
 * 990. Satisfiability of Equality Equations: https://leetcode.com/problems/satisfiability-of-equality-equations/
 *
 * @author TomAndersen
 */
public class LeetCode990 {
}


/**
 * Union-Find
 * TC: O(n), SC: O(n)
 */
class LeetCode990_1 {
    public boolean equationsPossible(String[] equations) {
        // exclude boundary situations
        if (equations == null || equations.length == 0) {
            return true;
        }

        // initialize disjoint set
        boolean res = true;
        int[] parents = new int[26];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        // iterate all equations and build disjoint set
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int a = equation.charAt(0) - 'a', b = equation.charAt(3) - 'a';
                // find roots
                while (a != parents[a]) {
                    a = parents[a];
                }
                while (b != parents[b]) {
                    b = parents[b];
                }

                // union set by path compression
                parents[b] = parents[parents[a]];
            }
        }

        // iterate all in-equations
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int a = equation.charAt(0) - 'a', b = equation.charAt(3) - 'a';

                // find roots
                while (a != parents[a]) {
                    a = parents[a];
                }
                while (b != parents[b]) {
                    b = parents[b];
                }

                if (a == b) {
                    res = false;
                    break;
                }
            }
        }

        // return
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode990_1().equationsPossible(new String[]{"a==b", "b!=a"}) == false);
        System.out.println(new LeetCode990_1().equationsPossible(new String[]{"b==a", "a==b"}) == true);
        System.out.println(new LeetCode990_1().equationsPossible(new String[]{"a==b", "e==c", "b==c", "a!=e"}) == false);
    }
}
