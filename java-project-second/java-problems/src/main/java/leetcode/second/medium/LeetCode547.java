package leetcode.second.medium;

import leetcode.common.Util;

/**
 * 547. Number of Provinces
 * https://leetcode.com/problems/number-of-provinces/description/
 *
 * @author TomAndersen
 */
public class LeetCode547 {
    public static void main(String[] args) {
        int[][] isConnected;
        int output;

        isConnected = Util.strToArrayArray("[[1,1,0],[1,1,0],[0,0,1]]");
        output = 2;
        System.out.println(new LeetCode547_1().findCircleNum(isConnected) == output);

        isConnected = Util.strToArrayArray("[[1,0,0],[0,1,0],[0,0,1]]");
        output = 3;
        System.out.println(new LeetCode547_1().findCircleNum(isConnected) == output);
    }
}

/**
 * BFS
 */
class LeetCode547_1 {
    public int findCircleNum(int[][] isConnected) {
        // input
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }

        // transform
        int length = isConnected.length;
        boolean[] isVisited = new boolean[length];
        int provincesCount = 0;

        for (int i = 0; i < length; i++) {
            if (isVisited[i]) {
                continue;
            }

            isVisited[i] = true;
            provincesCount += 1;
            for (int j = i; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    dfsRecursionMark(isConnected, isVisited, j);
                }
            }
        }

        // output
        return provincesCount;
    }

    private void dfsRecursionMark(int[][] isConnected, boolean[] isVisited, int node) {
        // skip if current node is visited
        if (isVisited[node]) {
            return;
        }

        // else dfs recursive all connected node of current node
        isVisited[node] = true;

        int[] nodes = isConnected[node];
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == 1) {
                dfsRecursionMark(isConnected, isVisited, i);
            }
        }
    }
}
