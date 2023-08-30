package algorithm.practice.leetcode;

import java.util.*;

/**
 * 207. Course Schedule: https://leetcode.com/problems/course-schedule/
 * <p>
 * tags: medium, graph, bfs, dfs
 *
 * @author TomAndersen
 */
public class LeetCode207 {
}

/**
 * DFS recursion
 * TC: O(n), SC: O(n)
 */
class LeetCode207_1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // exclude boundary situation
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        // solve problem
        boolean isPossible = true;

        // build graph in adjacency list, and visit all edges in the graph by DFS recursion
        HashMap<Integer, List<Integer>> outEdges = new HashMap<>();
        // record the state of pointers, 0-not visited, 1-visiting, 2-visited
        int[] states = new int[numCourses];

        for (int[] outEdge : prerequisites) {
            List<Integer> outEdgeList = outEdges.getOrDefault(outEdge[0], new ArrayList<>());
            outEdgeList.add(outEdge[1]);
            outEdges.put(outEdge[0], outEdgeList);
        }

        for (int[] edge : prerequisites) {
            if (!dfsRecursion(outEdges, states, edge[0])) {
                isPossible = false;
                break;
            }
        }

        // return result
        return isPossible;
    }

    private boolean dfsRecursion(Map<Integer, List<Integer>> outEdges, int[] states, int x) {

        // if current point is visited or visiting
        if (states[x] == 2) {
            return true;
        }
        else if (states[x] == 1) {
            return true;
        }
        else {
            // visit current point and all subsequent points by dfs recursion
            states[x] = 1;

            List<Integer> subsequentPoints = outEdges.getOrDefault(x, Collections.emptyList());
            for (int point : subsequentPoints) {
                if (!dfsRecursion(outEdges, states, point)) {
                    return false;
                }
            }

            states[x] = 2;
            return true;
        }
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode207_1().canFinish(2, new int[][]{{1, 0}}) == true);
        System.out.println(new LeetCode207_1().canFinish(2, new int[][]{{1, 0}, {0, 1}}) == false);
        System.out.println(new LeetCode207_1().canFinish(3, new int[][]{{1, 0}, {1, 2}, {0, 1}}) == false);
    }
}